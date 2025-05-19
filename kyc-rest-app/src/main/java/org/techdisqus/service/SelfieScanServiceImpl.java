package org.techdisqus.service;



import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import com.innovatrics.dot.integrationsamples.disapi.ApiResponse;
import com.innovatrics.dot.integrationsamples.disapi.model.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.techdisqus.dao.GetImageDao;
import org.techdisqus.exception.ApiExecutionException;
import org.techdisqus.request.UserSelfieRequest;
import org.techdisqus.response.AbstractResponse;
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
	public UserSelfieResponse scanSelfie(UserSelfieRequest request) {
		log.info("selfie scan started");

		UserSelfieResponse response =  UserSelfieResponse.builder().build();

		Map<String, String> reqInfo = request.getRequestInformation();
		String customerId = reqInfo.get("customerId");
		response.setRequestId(reqInfo.get("requestId"));
		response.setSpanId(getRequestId());
		response.setUserData(reqInfo);

		if(reqInfo.containsKey("livenessCreated")) {
			customerOnboardingApi.deleteLiveness(customerId);
		}

		customerOnboardingApi.createLiveness(customerId);

		CreateCustomerLivenessRecordResponse createCustomerLivenessRecordResponse = customerOnboardingApi.createLivenessRecord(customerId, Base64.getDecoder().decode(request.getImage()));

		if(createCustomerLivenessRecordResponse.getErrorCode() != null) {
			response.setErrorCode("SELFIE-001");
			response.setErrorDetails("Error while creating selfie");
		}else {
			EvaluateCustomerLivenessRequest evaluateCustomerLivenessRequest = new EvaluateCustomerLivenessRequest();
			evaluateCustomerLivenessRequest.setType(EvaluateCustomerLivenessRequest.TypeEnum.SMILE_LIVENESS);
			EvaluateCustomerLivenessResponse evaluateCustomerLivenessResponse =
					customerOnboardingApi.evaluateLiveness(customerId, evaluateCustomerLivenessRequest);

			if(evaluateCustomerLivenessResponse.getErrorCode() != null) {
				log.error("Error while evaluating liveness {}" , evaluateCustomerLivenessResponse);
				response.setErrorCode(evaluateCustomerLivenessResponse.getErrorCode().getValue());
				response.setErrorDetails("Error while evaluating smile liveness");
			}else {


				CompletableFuture<CustomerInspectResponse> customerInspectCompletableFuture =
						ApiHelper.execute(callback -> customerOnboardingApi.inspectAsync(customerId, callback), request);

				CompletableFuture.allOf(customerInspectCompletableFuture).thenApply(unused -> {
					try {

						CustomerInspectResponse customerInspectResponse = customerInspectCompletableFuture.get();
						if (customerInspectResponse.getSecurity() != null) {
							VideoInjectionInspection videoInjectionInspection = customerInspectResponse.getSecurity().getVideoInjection();
							if (Boolean.TRUE.equals(videoInjectionInspection.getDetected())) {
								response.setErrorCode("SELFIE-002");
								response.setErrorDetails("Video injection detected");
							}
						}

						if (customerInspectResponse.getSelfieInspection() != null) {
							if (Boolean.TRUE.equals(customerInspectResponse.getSelfieInspection().getHasMask())) {
								response.setErrorCode("SELFIE-003");
								response.setErrorDetails("User wearing mask");
							}

							if (Boolean.FALSE.equals(customerInspectResponse.getSelfieInspection().getSimilarityWith().getDocumentPortrait())) {
								response.setErrorCode("SELFIE-004");
								response.setErrorDetails("Portrait and selfie does not match");
							}

							if (Boolean.FALSE.equals(customerInspectResponse.getSelfieInspection().getSimilarityWith().getLivenessSelfies())) {
								response.setErrorCode("SELFIE-005");
								response.setErrorDetails("liveness photo and selfie does not match");
							}

							if (Boolean.FALSE.equals(customerInspectResponse.getSelfieInspection().getGenderConsistency().getDocumentPortrait())) {
								response.setErrorCode("SELFIE-006");
								response.setErrorDetails("Gender does not match");
							}

							Integer age = customerInspectResponse.getSelfieInspection().getAgeEstimate();


							log.info("Estimated age from selfie {}", age);

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
				LivenessSelfieOrigin livenessSelfieOrigin = new LivenessSelfieOrigin().link(createCustomerLivenessRecordResponse.getLinks().getSelfie());
				createSelfieRequest.setSelfieOrigin(livenessSelfieOrigin);

				CreateSelfieResponse createSelfieResponse = customerOnboardingApi.createSelfie1(customerId, createSelfieRequest);

				if(createSelfieResponse.getErrorCode() != null) {
					log.error("Error while setting selfie {}", createSelfieResponse);
					response.setErrorDetails(createSelfieResponse.getErrorCode().getValue());
					response.setErrorCode("SELFIE-007");
				}

				CreateCustomerLivenessSelfieRequest createCustomerLivenessSelfieRequest = new CreateCustomerLivenessSelfieRequest();

				SelfieOrigin selfieOrigin = new SelfieOrigin();
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
			}

		}

		log.info("selfie scan completed");

		return response;
	}


	private void incrementCount(AbstractResponse response, Map<String, String> opaqueData, String whichCount,
								int count) {
		opaqueData.put("selfieRetryCount", String.valueOf(count + 1));
		opaqueData.put(whichCount, String.valueOf(count + 1));
		opaqueData.put("sentDateTime", String.valueOf(Instant.now().toEpochMilli()));
		response.setUserData(opaqueData);
	}
}
