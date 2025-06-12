package org.techdisqus.service;



import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import com.innovatrics.dot.integrationsamples.disapi.model.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.techdisqus.dao.GetImageDao;
import org.techdisqus.exception.ApiExecutionException;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UserSelfieRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.response.UserSelfieResponse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.techdisqus.service.util.ApiHelper;



@Component
@Slf4j
public class SelfieScanServiceImpl extends KycBaseService
		implements SelfieScanService {

	@Value("${api.version:v1}")
	private String apiVersion;

    @Value("${smileLivenessScoreThreshold}")
    private double smileLivenessScoreThreshould;

	@Value("${passiveLivenessScoreThreshold}")
	private double passiveLivenessScoreThreshould;
	@Value ("${selfieRetryCount}")
	private int selfieRetryCount;

	@Value ("${smileLivenessRetryCount}")
	private int smileLivenessRetryCount;

	@Value ("${passiveLivenessretryCount}")
	private int passiveLivenessRetryCount;

	@Value ( "${retry_time}")
	private long retryTime;

	@Autowired
	private GetImageDao getImageDao;

	@SneakyThrows
    @Override
	public UserSelfieResponse scanSelfie(UserSelfieRequest request, KycRequestHeaders kycRequestHeaders) {
		log.info("selfie scan started");

		UserSelfieResponse response =  UserSelfieResponse.builder().build();

		Map<String, String> reqInfo = request.getRequestInformation();
		String customerId = reqInfo.get("customerId");
		response.setUserData(reqInfo);

		if(reqInfo.containsKey("livenessCreated")) {
			customerOnboardingApi.deleteLiveness(customerId);
		}

		customerOnboardingApi.createLiveness(customerId);

		CreateCustomerLivenessRecordResponse createCustomerLivenessRecordResponse = customerOnboardingApi.createLivenessRecord(customerId, Base64.getDecoder().decode(request.getImage()));

		if(createCustomerLivenessRecordResponse.getErrorCode() != null) {
			response.setErrorCode("SELFIE-001");
			response.setErrorDetails("Error while creating selfie");
			return response;
		}else {

			EvaluateCustomerLivenessRequest evaluateCustomerLivenessRequest = new EvaluateCustomerLivenessRequest();
			evaluateCustomerLivenessRequest.setType(EvaluateCustomerLivenessRequest.TypeEnum.SMILE_LIVENESS);
			EvaluateCustomerLivenessResponse evaluateCustomerLivenessResponse =
					customerOnboardingApi.evaluateLiveness(customerId, evaluateCustomerLivenessRequest);

			if(evaluateCustomerLivenessResponse.getErrorCode() != null) {
				log.error("Error while evaluating liveness {}" , evaluateCustomerLivenessResponse);
				response.setErrorCode("SELFIE-008");
				response.setErrorDetails("Error while evaluating smile liveness");
				return response;
			}else {

				log.info("liveness score is {} ", evaluateCustomerLivenessResponse.getScore());

				CompletableFuture<CustomerInspectResponse> customerInspectCompletableFuture =
						ApiHelper.execute(callback -> customerOnboardingApi.inspectAsync(customerId, callback), request);

				CompletableFuture<GetCustomerResponse> getCustomerResponseCompletableFuture =
						ApiHelper.execute(callback -> customerOnboardingApi.getCustomerAsync(customerId, callback), request);

				CompletableFuture.allOf(customerInspectCompletableFuture, getCustomerResponseCompletableFuture).thenApply(unused -> {
					try {

						CustomerInspectResponse customerInspectResponse = customerInspectCompletableFuture.get();
						GetCustomerResponse getCustomerResponse = getCustomerResponseCompletableFuture.get();

                        assert getCustomerResponse.getCustomer() != null;
                        assert getCustomerResponse.getCustomer().getAge() != null;
                        assert getCustomerResponse.getCustomer().getGender() != null;
                        response.setSelfieData(List.of(new ExtractedData("selfie.age",getCustomerResponse.getCustomer().getAge().getSelfie(), "Selfie Age"),
								new ExtractedData("selfie.gender",getCustomerResponse.getCustomer().getGender().getSelfie(), "Selfie Gender")));


						if (customerInspectResponse.getSecurity() != null) {
							VideoInjectionInspection videoInjectionInspection = customerInspectResponse.getSecurity().getVideoInjection();
							if (Boolean.TRUE.equals(videoInjectionInspection.getDetected())) {
								response.setErrorCode("SELFIE-002");
								response.setErrorDetails("Video injection detected");
								return response;
							}
						}

							if (customerInspectResponse.getSelfieInspection() != null) {
								log.info("customerInspectResponse.getSelfieInspection()  {}", customerInspectResponse.getSelfieInspection().toJson() );
								if (Boolean.TRUE.equals(customerInspectResponse.getSelfieInspection().getHasMask())) {
									response.setErrorCode("SELFIE-003");
									response.setErrorDetails("User wearing mask");
									return response;
								}

								assert customerInspectResponse.getSelfieInspection().getSimilarityWith() != null;
								if (Boolean.FALSE.equals(customerInspectResponse.getSelfieInspection().getSimilarityWith().getDocumentPortrait())) {
									log.info("portrait does not match with selfie and setting error code SELFIE-004");
									response.setErrorCode("SELFIE-004");
									response.setErrorDetails("Portrait and selfie does not match");
									return response;
								}

								if (Boolean.FALSE.equals(customerInspectResponse.getSelfieInspection().getSimilarityWith().getLivenessSelfies())) {
									response.setErrorCode("SELFIE-005");
									response.setErrorDetails("liveness photo and selfie does not match");
									return response;
								}

								assert customerInspectResponse.getSelfieInspection().getGenderConsistency() != null;
								if (Boolean.FALSE.equals(customerInspectResponse.getSelfieInspection().getGenderConsistency().getDocumentPortrait())) {
									log.info("gender does not match with selfie and setting error code SELFIE-006");
									response.setErrorCode("SELFIE-006");
									response.setErrorDetails("Gender does not match");
									return response;
								}

								Integer age = customerInspectResponse.getSelfieInspection().getAgeEstimate();


								log.info("Estimated age from selfie {}", age);
							} else{
								log.warn("selfie inspection is null");
							}
					}catch(InterruptedException e){
						log.error("Execution is interrupted ", e);
						throw new ApiExecutionException(e, request);
					} catch(ExecutionException e){
						log.error("Execution is failed ", e);
						throw new ApiExecutionException(e, request);
					}
					return unused;
				}).join();

				CreateSelfieRequest createSelfieRequest = new CreateSelfieRequest();
                assert createCustomerLivenessRecordResponse.getLinks() != null;
                LivenessSelfieOrigin livenessSelfieOrigin = new LivenessSelfieOrigin().link(createCustomerLivenessRecordResponse.getLinks().getSelfie());
				createSelfieRequest.setSelfieOrigin(livenessSelfieOrigin);

				CreateSelfieResponse createSelfieResponse = customerOnboardingApi.createSelfie1(customerId, createSelfieRequest);

				if(createSelfieResponse.getErrorCode() != null) {
					log.error("Error while setting selfie {}", createSelfieResponse);
					response.setErrorDetails(createSelfieResponse.getErrorCode().getValue());
					response.setErrorCode("SELFIE-007");
					return response;
				}

				CreateCustomerLivenessSelfieRequest createCustomerLivenessSelfieRequest = new CreateCustomerLivenessSelfieRequest();

				SelfieOrigin selfieOrigin = new SelfieOrigin();
                assert createSelfieResponse.getLinks() != null;
                selfieOrigin.setLink(createSelfieResponse.getLinks().getSelf());
				createCustomerLivenessSelfieRequest.setSelfieOrigin(selfieOrigin);
				createCustomerLivenessSelfieRequest.setAssertion(CreateCustomerLivenessSelfieRequest.AssertionEnum.NONE);

				CreateCustomerLivenessSelfieResponse createCustomerLivenessSelfieResponse = customerOnboardingApi.createLivenessSelfie(customerId, createCustomerLivenessSelfieRequest);

				if(createCustomerLivenessSelfieResponse.getErrorCode() != null) {
					log.error("Error while creating passive liveness selfie {}", createCustomerLivenessSelfieResponse.getErrorCode());
				}

				ImageCrop selfie = customerOnboardingApi.getSelfieImage(customerId);
				response.setUserSelfie(Base64.getEncoder().encodeToString(selfie.getData()));

				EvaluateCustomerLivenessRequest evaluateCustomerLivenessRequestPassive = new EvaluateCustomerLivenessRequest()
						.type(EvaluateCustomerLivenessRequest.TypeEnum.PASSIVE_LIVENESS);

				EvaluateCustomerLivenessResponse evaluateCustomerLivenessResponsePassive = customerOnboardingApi.evaluateLiveness(customerId, evaluateCustomerLivenessRequestPassive);

				log.info("evaluateCustomerLivenessResponsePassive liveness score is {} ", evaluateCustomerLivenessResponsePassive.getScore());
				assert  evaluateCustomerLivenessResponsePassive.getScore() != null;
				double requiredScorePassiveLiveness = 0.81;
				if(evaluateCustomerLivenessResponsePassive.getScore() < requiredScorePassiveLiveness) {
					response.setErrorCode("SMILE-009");
					response.setErrorDetails("passive liveness score is lesser than " + requiredScorePassiveLiveness);
				}
			}

		}

        log.info("selfie scan completed and response error details {} {}", response.getErrorCode(), response.getErrorDetails());

		return response;
	}

}
