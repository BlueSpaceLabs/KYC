package org.techdisqus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import com.innovatrics.dot.integrationsamples.disapi.model.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.CustomerOperations;
import org.techdisqus.dao.GetCustomerDetailsDao;
import org.techdisqus.dao.request.SaveToTrustStoreDaoRequest;
import org.techdisqus.dao.response.SaveToTrustStoreDaoResponse;
import org.techdisqus.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;
import org.techdisqus.request.Consent;
import org.techdisqus.request.Document;
import org.techdisqus.request.RegisterUserRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.response.RegisterUserResponse;
import org.techdisqus.service.RegistrationUtil.SimActivationAndDocumentUploadResult;
import org.techdisqus.service.RegistrationUtil.StatusHolder;
import org.techdisqus.service.util.ApiHelper;
import org.techdisqus.service.utils.DateUtils;
import org.techdisqus.service.utils.RegistrationStatusUtil;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;


@Component
public class RegisterUserServiceImpl extends KycBaseService implements RegisterUserService {



    @Autowired
    private CustomerOperations customerOperations;

    @Autowired
    private GetCustomerDetailsDao getCustomerDetailsDao;

    @Autowired
    private UpdateCustomAttributesUtil updateCustomAttributesUtil;



    @Autowired
    private RegistrationUtil registrationUtil;

    @Autowired
    private RegistrationStatusUtil registrationStatusUtil;

    private Logger logger = LoggerFactory.getLogger(RegisterUserServiceImpl.class);



    private void deleteCustomer(RegisterUserRequest request) {

        String customerId = request.getCustomerId();

        try {

            customerOnboardingApi.deleteCustomer(customerId);
            


        } catch (Exception e) {
        	
			logger.error("Error while deleting the customer ", e);
			
        }
    }

    private String getOnboardingStatusMessage(String status, String locale) {
        switch (status) {
            case MASTER:
                return messageProvider.getMessage("onboarding.request.accepted", locale);
            case DECLINED:
                return messageProvider.getMessage("onboarding.request.declined", locale);
            case REVIEW:
                return messageProvider.getMessage("onboarding.request.review", locale);
            default:
                return messageProvider.getMessage("onboarding.request.taken", locale);
        }
    }

    private boolean isAccepted(String status) {
        return status.equalsIgnoreCase(MASTER);
    }

    private boolean checkConsent(List<Consent> consents, String requiredConsent) {
        return consents.stream().anyMatch(consent -> requiredConsent.equals(consent.getConsentType()));
    }


    @SneakyThrows
    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        RegisterUserResponse response =  RegisterUserResponse.builder().build();
        Map<String, String> reqInfo = request.getRequestInformation();

        String customerId = request.getCustomerId();
        GetCustomerResponse getCustomerResponse = customerOnboardingApi.getCustomer(customerId);

        if(getCustomerResponse == null) {


        }
        String locale = request.getLocale();
        List<Consent> consents = request.getConsents();
        String msisdn = reqInfo.get("msisdn");
        String encryptedMsisdn = encryptionUtil.encrypt(msisdn);

       /* if (CollectionUtils.isEmpty(consents)) {
            logger.error("Consent not given for msisdn {}  ", encryptedMsisdn);
            String missingConsentMessage = messageProvider.getMessage("error.missing.consent", toLocale(request));
            response.setErrorCode("REGISTER-001");
            response.setErrorDetails(missingConsentMessage);

            return response;
        }

        if (!checkConsent(consents, TERMS_ACCEPTANCE_CONFIRMATION) &&
                !checkConsent(consents, ACCEPT_AND_CONFIRMATIONIS)) {
            logger.error("Consent not given for msisdn {} and consents {} ", encryptedMsisdn, consents.stream()
                    .map(consent -> consent.getConsentType() + ":" + consent.isConsentGiven()).collect(Collectors.toList()));

            String missingConsentMessage = messageProvider.getMessage("error.missing.consent", toLocale(request));

            response.setErrorDetails(missingConsentMessage);
            response.setErrorCode("REGISTER-002");

            return response;
        }*/



        String externalId = reqInfo.get("externalId");

        if(StringUtils.isEmpty(externalId)) {
            logger.error("externalId can not be null");
            response.setErrorCode("REGISTER-003");
            response.setErrorDetails("externalId is null");

            return response;
        }

        /*
         * Added externalId in opaqueData so we will have in the logs when we are using the GlobeDaoValidationandLoggingUtil
         */
        reqInfo.put("externalId", externalId);

        logger.info("Registration request started for msisdn {} customerId {} and externalId {}", encryptedMsisdn, customerId, externalId);

        SaveToTrustStoreDaoResponse saveToTrustStoreDaoResponse;
        try {

            SaveToTrustStoreDaoRequest saveToTrustStoreDaoRequest = new SaveToTrustStoreDaoRequest()
                    .withExternalId(externalId)
                    .withOnboardingStatus("FINISHED");


            saveToTrustStoreDaoResponse = customerOperations.saveCustomer(saveToTrustStoreDaoRequest, customerId);


            response.setSimRegistrationDate(DateUtils.getDate());

            CompletableFuture<DocumentInspectResponse> documentInspectResponseCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.documentInspectAsync(customerId, callback), request);

            CompletableFuture<DocumentInspectDiscloseResponse> documentInspectDiscloseResponseCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.documentInspectDiscloseAsync(customerId, callback), request);

            CompletableFuture<CustomerInspectResponse> customerInspectResponseCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.inspectAsync(customerId, callback), request);

            CompletableFuture<ImageCrop> imageCropCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.getSelfieImageAsync(customerId,callback), request);

            CompletableFuture<ImageCrop> documentPageCropCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.documentPageCropAsync(customerId,"front",null,null,callback), request);

            CompletableFuture
                    .allOf(documentInspectResponseCompletableFuture, documentInspectDiscloseResponseCompletableFuture,
                            customerInspectResponseCompletableFuture, imageCropCompletableFuture, documentPageCropCompletableFuture )
                    .thenApply(unused -> {
                        try {
                            DocumentInspectResponse documentInspectResponse = documentInspectResponseCompletableFuture.get();
                            DocumentInspectDiscloseResponse documentInspectDiscloseResponse = documentInspectDiscloseResponseCompletableFuture.get();
                            CustomerInspectResponse customerInspectResponse = customerInspectResponseCompletableFuture.get();
                            Path path = Paths.get("/tmp/"+customerId+".txt");
                            Files.write(path, getCustomerResponse.toJson().getBytes(), StandardOpenOption.CREATE);
                            Files.write(path, "\n****************************************\n".getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, documentInspectResponse.toJson().getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n****************************************\n".getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, documentInspectDiscloseResponse.toJson().getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n****************************************\n".getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, customerInspectResponse.toJson().getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n****************************************\n".getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, imageCropCompletableFuture.get().toJson().getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n****************************************\n".getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, documentPageCropCompletableFuture.get().toJson().getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n****************************************\n".getBytes(), StandardOpenOption.APPEND);

                        } catch (InterruptedException e) {
                            logger.error("request is interrupted ", e);
                           // throw new ApiExecutionException(e,request);
                        } catch (ExecutionException e) {
                            logger.error("execution is failed ", e);
                           // throw new ApiExecutionException(e,request);
                        } catch (IOException e) {
                            logger.error("Error while writing to file", e);
                           // throw new ApiExecutionException(e,request);
                        }

                        return unused;
                    }).join();

            if (saveToTrustStoreDaoResponse == null) {

                GetCustomerDetailsDaoResponse currentCustomerDetailsDaoResponse = getCustomerDetailsDao.queryByExternalId(externalId, true);

                String status = currentCustomerDetailsDaoResponse.getGallery();
                StatusHolder statusHolder = null;


                //gallery status is NOT master AND there are identity candidates (means duplicates)
                if (DECLINED.equalsIgnoreCase(status)
                        && isNotEmpty(currentCustomerDetailsDaoResponse.getIdentifyCandidates())) {
                    List<ExtractedData> updatedValues = request.getUpdatedValues();
                    statusHolder = registrationUtil.checkDeclinedOnlyForUniqueness(request, updatedValues, currentCustomerDetailsDaoResponse, reqInfo);
                    status = statusHolder.getStatus();
                }else if(REVIEW.equalsIgnoreCase(status)){
                    statusHolder = registrationUtil.checkInReviewOnlyForDocumentRecognized(currentCustomerDetailsDaoResponse, reqInfo);
                    status = statusHolder.getStatus();
                }else {
                    statusHolder = new StatusHolder(externalId, status);
                }

                String errorMessage = messageProvider.getMessage("error.customer.onboarding.failed", toLocale(request));

                if (isAccepted(status)) {

                    List<Document> additionalDocuments = new ArrayList<>();
                    long currentMsisdn = Long.parseLong(msisdn);
                    SimActivationAndDocumentUploadResult result = new SimActivationAndDocumentUploadResult(true, new ArrayList<>(), true);


                    if (!result.isSuccess()) {

                        response.setErrorCode("REGISTER-008");
                        response.setErrorDetails("Error while sim activation");

                        if (!registrationUtil.updateCustomAttributesForError(request, externalId, currentCustomerDetailsDaoResponse, getCustomerResponse, "backend error")) {
                            //log
                        }

                        return response;
                    }

                    if (!registrationUtil.updateCustomAttributes(request, externalId, currentCustomerDetailsDaoResponse, result.getUploadedDocuments(), statusHolder, getCustomerResponse)) {
                        logger.error("Error while updating custom attributes for externalId {} encryptedMsisdn {}", externalId, encryptedMsisdn);
                        response.setErrorCode("REGISTER-009");
                        response.setErrorDetails("Error while updating custom attributes");

                        return response;
                    }

                    if (!registrationStatusUtil.registerCustomer(externalId, request.getRequestInformation().get("msisdn"), request.getSelectedAccountType(), RegistrationStatusCode.ACCEPTED)) {
                        logger.error("Error while creating registration record in dynamoDB for externalId {} encryptedMsisdn {}",
                                externalId, encryptedMsisdn);

                        response.setErrorCode("REGISTER-010");
                        response.setErrorCode("Error while creating record");


                        return response;
                    }


                    response.setStatus(status);
                    response.setRequestId(externalId);
                    response.setStatusMessage("registration is successful for externalId " + externalId);
                } else {

                    if (!registrationUtil.updateCustomAttributesForError(request, externalId, currentCustomerDetailsDaoResponse, getCustomerResponse, "")) {
                        logger.error("Failed registration: Error while updating custom attributes for externalId {} encryptedMsisdn {}", externalId, encryptedMsisdn);
                    }

                    response.setErrorCode("REGISTER-012");

                    if(statusHolder.isRejectedDueToDocumentIssue()){
                        response.setErrorCode("REGISTER-013");
                    }

                    response.setStatus(status);
                }

            } else {
                logger.error("externalId {} msisdn {} and customer Id {} saving to trust store failed with error code {} and message {}",
                        externalId, encryptedMsisdn, customerId,
                        saveToTrustStoreDaoResponse.getErrorCode(), saveToTrustStoreDaoResponse.getErrorMessage());

                response.setErrorCode("REGISTER-014");

            }

        } catch (Exception ex) {
            logger.error("Error while storing to trust store external id {}, customer Id {} and msisdn {} ",
                    externalId, customerId, encryptedMsisdn, ex);

            response.setErrorCode("REGISTER-015");

        } finally {
            deleteCustomer(request);
        }
        return null;
    }
}
