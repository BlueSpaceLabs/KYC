/*
package org.example.service.utils;

import com.awarex.security.AuthToken;
import com.awarex.umw.exception.service.CustomerServiceException;
import com.awarex.umw.impl.globe.dao.RegisterEventDao;
import com.awarex.umw.impl.globe.dao.dot.GetCustomerDetailsDao;
import com.awarex.umw.impl.globe.dao.dot.GetImageDao;
import com.awarex.umw.impl.globe.dao.request.register.event.RegistrationEventDaoRequest;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.IdentifyCandidate;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.TrustFactor;
import com.awarex.umw.impl.globe.dao.response.dot.document.CustomerInfoDaoResponse;
import com.awarex.umw.impl.globe.dao.response.sim.registration.RegistrationEventResponse;
import com.awarex.umw.impl.globe.db.model.RegistrationStatus;
import com.awarex.umw.impl.globe.services.GlobeBaseService;
import com.awarex.umw.model.AdditionalDocument;
import com.awarex.umw.model.DerivedValue;
import com.awarex.umw.model.DigitalOnboardingConfig;
import com.awarex.umw.request.RegisterDigitalOnboardingUserRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Component
public class GlobeDigitalOnboardingRegistrationUtil extends GlobeBaseService {

    private static Logger logger = LoggerFactory.getLogger(GlobeDigitalOnboardingRegistrationUtil.class);

    @Resource
    private GetCustomerDetailsDao getCustomerDetailsDao;

    @Autowired
    private UploadDocumentUtil uploadDocumentUtil;

    @Autowired
    private SimActivationUtil simActivationUtil;

    @Autowired
    private UpdateCustomAttributesUtil updateCustomAttributesUtil;

    @Autowired
    private RegistrationStatusUtil registrationStatusUtil;

    @Autowired
    private RegisterEventDao registerEventDao;

    @Autowired
    private GetImageDao getImageDao;


    private static final List<AdditionalDocument> empty = Collections.emptyList();



    public SimActivationAndDocumentUploadResult activateSimAndUploadDocs(String externalId, RegisterDigitalOnboardingUserRequest request, Map<String, String> opaqueData,
                                                                         List<AdditionalDocument> additionalDocuments, String customerId, GetCustomerDetailsDaoResponse currentCustomerDetailsDaoResponse){


        String encryptedMsisdn = encryptionUtil.encrypt(request.getDigitalOnboardingConfig().getPhoneNumber());     
        
        daoValidationAndLoggingUtil.addSimpleLog(opaqueData, "start Sim activation request sent ");

        List<AdditionalDocument> uploadedDocuments = null;
        DigitalOnboardingConfig config = request.getDigitalOnboardingConfig();

        boolean simActivationRequestSent = true;
        boolean isUploadDocumentsSuccessful = true;

        SimActivationUtil.SimActivateDetails simActivateDetails = getSimActivateDetails(externalId, request, opaqueData);
        RegistrationEventDaoRequest daoRequest = simActivationUtil.getRegistrationEventDaoRequest(simActivateDetails);
        Future<RegistrationEventResponse> registrationEventDaoResponseFuture = registerEventDao.registerSimAsync(daoRequest);

        List<AdditionalDocument> idDocs = new ArrayList<>(2);

        String documentPageUrl = currentCustomerDetailsDaoResponse.getDocuments().get(0).getDocumentPages().get(0).getDataUrl();
        Future<byte[]> documentPageFuture = getImageDao.getImageAsync(documentPageUrl.substring(documentPageUrl.indexOf("/", 8)));
        String idDocument = "";
        String selfyUrl = currentCustomerDetailsDaoResponse.getSelfies().get(0).getImage().getDataUrl();
        byte[] selfyImage = getImageDao.getImage(selfyUrl.substring(selfyUrl.indexOf("/", 8)));

        try {
            idDocument = Base64.getEncoder().encodeToString(documentPageFuture.get());
        } catch (InterruptedException e) {
            daoValidationAndLoggingUtil.addSimpleErrorLog(opaqueData, "InterruptedException: Error while reading ID document");
            Thread.currentThread().interrupt();
            AuthToken authToken = new AuthToken(request.getAuthToken());
            throw new CustomerServiceException(e, authToken);
        } catch (ExecutionException e) {
            daoValidationAndLoggingUtil.addSimpleErrorLog(opaqueData, "ExecutionException: Error while reading ID document");
            AuthToken authToken = new AuthToken(request.getAuthToken());
            throw new CustomerServiceException(e, authToken);
        }

        idDocs.add(getSelfie(request, Base64.getEncoder().encodeToString(selfyImage)));
        idDocs.add(getIdDocument(request, idDocument));

        
        uploadedDocuments = uploadDocumentUtil.uploadDocuments(config.getPhoneNumber(), opaqueData.get("referenceId"),
                externalId, additionalDocuments, idDocs, getUserToken(opaqueData), customerId, opaqueData);

		if (logger.isInfoEnabled()) {

			String developerComment = String
					.format("Uploaded documents for externalId %s and additional docs %s", externalId,
							uploadedDocuments.stream()
									.map(additionalDocument -> additionalDocument.getDocumentName() + " "
											+ additionalDocument.getUploadedSuccessfully())
									.collect(Collectors.toList()));

			daoValidationAndLoggingUtil.addSimpleLog(opaqueData, developerComment);
		}

        if(uploadedDocuments.stream().anyMatch(additionalDocument -> Boolean.FALSE.equals(additionalDocument.getUploadedSuccessfully()))){
            isUploadDocumentsSuccessful = false;
        }

        try {
            RegistrationEventResponse registrationEventDaoResponse = registrationEventDaoResponseFuture.get();
            
			String successfulActivateMessage = String.format(
					"Sim Activation request sent successfully. message from the registration event: %s",
					registrationEventDaoResponse.getMessage());
            
            daoValidationAndLoggingUtil.addSimpleLog(opaqueData, successfulActivateMessage);
            
            //Add validations if any

            if(registrationEventDaoResponse.getError() != null && StringUtils.isNotEmpty(registrationEventDaoResponse.getError().getCode())){

				String failedActivateMessage = String.format(
						"Sim Activation request failed. message from the registration event: errorCode %s errorMessage %s  and details %s",
						registrationEventDaoResponse.getError().getCode(),
						registrationEventDaoResponse.getError().getMessage(),
						registrationEventDaoResponse.getError().getDetails());
                
                daoValidationAndLoggingUtil.addSimpleLog(opaqueData, failedActivateMessage);
                
                simActivationRequestSent = false;
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            
            String simActivateExcpetion = String.format("Error while activating SIM");
            
            daoValidationAndLoggingUtil.addExceptionLogWithDeveloperComment(RegisterEventDao.class, opaqueData, simActivateExcpetion, e);
            
            AuthToken authToken = new AuthToken(request.getAuthToken());

            throw new CustomerServiceException(e, authToken);
        } catch (ExecutionException e){
            logUnifiedErrorMessage("ExecutionException: Error while activating SIM for encrypted msisdn "+encryptedMsisdn, this.getClass(),
                    "activateSimAndUploadDocs",e);

            String simActivateExcpetion = String.format("ExecutionException: Error while activating SIM");
            
            daoValidationAndLoggingUtil.addExceptionLogWithDeveloperComment(RegisterEventDao.class, opaqueData, simActivateExcpetion, e);
            
            AuthToken authToken = new AuthToken(request.getAuthToken());
            
            throw new CustomerServiceException(e, authToken);
        }

        return new SimActivationAndDocumentUploadResult(simActivationRequestSent, uploadedDocuments, isUploadDocumentsSuccessful);
    }

    private SimActivationUtil.SimActivateDetails getSimActivateDetails(String externalId, RegisterDigitalOnboardingUserRequest request, Map<String, String> opaqueData) {
        SimActivationUtil.SimActivateDetails simActivateDetails = new SimActivationUtil.SimActivateDetails();
        simActivateDetails.setAccountType(request.getDigitalOnboardingConfig().getAccountType());
        simActivateDetails.setMsisdn(request.getDigitalOnboardingConfig().getPhoneNumber());
        simActivateDetails.setChannelId(opaqueData.getOrDefault("channelId", "C01"));
        simActivateDetails.setExternalId(externalId);
        String brand = opaqueData.get("brand");

        daoValidationAndLoggingUtil.addSimpleLog(opaqueData, "Network: " + opaqueData.get("network")+ " and brand: " + brand);

        simActivateDetails.setBrand(brand);
        String simType = opaqueData.getOrDefault("simType", "PHYSICAL");

        if(simType.equals("Physical")){
            simType = "PHYSICAL";
        }else if(simType.equalsIgnoreCase("esim")){
            simType = "eSIM";
        }

        daoValidationAndLoggingUtil.addSimpleLog(opaqueData, "simType: " + simType);

        simActivateDetails.setSimType(simType);

        return simActivateDetails;
    }

    private AdditionalDocument getSelfie(RegisterDigitalOnboardingUserRequest request, String image){
        AdditionalDocument additionalDocument = new AdditionalDocument();
        additionalDocument.setDocumentName("selfie");
        additionalDocument.setType("selfie");
        additionalDocument.setBase64EncodedImage(image);
        return additionalDocument;
    }

    private AdditionalDocument getIdDocument(RegisterDigitalOnboardingUserRequest request, String image){
        AdditionalDocument additionalDocument = new AdditionalDocument();
        additionalDocument.setDocumentName("idCard");
        additionalDocument.setType("idCard");
        additionalDocument.setBase64EncodedImage(image);
        return additionalDocument;
    }

    public boolean updateCustomAttributesForError(RegisterDigitalOnboardingUserRequest request,
                                                  String externalId, GetCustomerDetailsDaoResponse daoResponse, CustomerInfoDaoResponse customerInfo, String errorInfo){

        return updateCustomAttributesUtil.updateCustomAttributes(request,externalId,daoResponse,empty, new StatusHolder(externalId, DECLINED), customerInfo, errorInfo);
    }
    public boolean updateCustomAttributes(RegisterDigitalOnboardingUserRequest request,
                                          String externalId, GetCustomerDetailsDaoResponse daoResponse,
                                          List<AdditionalDocument> uploadedDocs, StatusHolder statusHolder, CustomerInfoDaoResponse customerInfo){
        return updateCustomAttributesUtil.updateCustomAttributes(request,externalId,daoResponse,uploadedDocs,statusHolder,customerInfo, "");
    }

    public StatusHolder checkInReviewOnlyForDocumentRecognized( GetCustomerDetailsDaoResponse daoResponse, Map<String, String> topLevelOpaqueData){
        daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData, "Check if in-review only because of the document recognised trust factor");

        List<TrustFactor> trustFactorsWithRejectStatus = daoResponse.getTrustFactors().stream()
                .filter(tf -> REJECT.equalsIgnoreCase(tf.getResult()) && !UNIQUENESS.equalsIgnoreCase(tf.getType()))
                .collect(Collectors.toList());

        //rejected for other type than uniqueness

        if(CollectionUtils.isNotEmpty(trustFactorsWithRejectStatus)){

            String logMessage = String.format("Rejecting the record as there are rejections apart from uniqueness %s",
                    trustFactorsWithRejectStatus.stream()
                            .map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
                            .collect(Collectors.toList()));

            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,logMessage);

            return new StatusHolder("",DECLINED);
        }

        List<TrustFactor> trustFactorsWithReview = daoResponse.getTrustFactors().stream()
                .filter(tf -> REVIEW.equalsIgnoreCase(tf.getResult()))
                .collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(trustFactorsWithReview)){

            String infoMessage = String.format(
                    "Rejecting the record as TF are in review %s",
                    trustFactorsWithReview.stream()
                            .map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
                            .collect(Collectors.toList()));

            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,infoMessage);

            return new StatusHolder("", DECLINED);
        }

        List<TrustFactor> documentTrustFactorsWithRejectStatus = daoResponse.getDocuments().stream()
                .filter(document -> CollectionUtils.isNotEmpty(document.getTrustFactors()))
                .flatMap(document -> document.getTrustFactors().stream())
                .filter(tf -> REJECT.equalsIgnoreCase(tf.getResult()))
                .collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(documentTrustFactorsWithRejectStatus)) {

            String documentTrustMessage = String.format(
                    "Rejecting the record as there are rejections at document trust factors %s",
                    documentTrustFactorsWithRejectStatus.stream()
                            .map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
                            .collect(Collectors.toList()));

            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,documentTrustMessage);

            return new StatusHolder("", DECLINED, true);
        }

        List<TrustFactor> documentTrustFactorsWithReviewStatus = daoResponse.getDocuments().stream()
                .filter(document -> CollectionUtils.isNotEmpty(document.getTrustFactors()))
                .flatMap(document -> document.getTrustFactors().stream())
                .filter(tf -> REVIEW.equalsIgnoreCase(tf.getResult())
                        && !(tf.getType().equalsIgnoreCase("document_recognized")
                            || tf.getType().equalsIgnoreCase("mrz_checksum_valid")
                            || tf.getType().equalsIgnoreCase("screenshot_photo")))
                .collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(documentTrustFactorsWithReviewStatus)) {

            String reviewTrustMessage = String.format(
                    "Rejecting the record as there are review at document trust factors %s",
                    documentTrustFactorsWithReviewStatus.stream()
                            .map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
                            .collect(Collectors.toList()));

            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,reviewTrustMessage);

            return new StatusHolder("", DECLINED, true);
        }

        return new StatusHolder(daoResponse.getExternalId(),MASTER);
    }

    public StatusHolder checkDeclinedOnlyForUniqueness(RegisterDigitalOnboardingUserRequest request, List< DerivedValue> updatedValues, GetCustomerDetailsDaoResponse daoResponse, Map<String, String> topLevelOpaqueData){


        daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData, "1:N mapping, check if failed due to uniqueness only");
        //biometric trust factors and ignore age validation for driver liscense
        List<TrustFactor> trustFactorsWithRejectStatus = daoResponse.getTrustFactors().stream()
                .filter(tf -> REJECT.equalsIgnoreCase(tf.getResult()) && !UNIQUENESS.equalsIgnoreCase(tf.getType()))
                .filter(tf -> {
                    String type = tf.getType();
                    String docType = getDocumentType(daoResponse);

                    if(docType.startsWith("driver") && type.equalsIgnoreCase("age_validation")) {
                        return false;
                    }

                    return REJECT.equalsIgnoreCase(tf.getResult()) ;
                }).collect(Collectors.toList());

        //rejected for other type than uniqueness

        if(CollectionUtils.isNotEmpty(trustFactorsWithRejectStatus)){
            
			String logMessage = String.format("Rejecting the record as there are rejections apart from uniqueness %s",
					trustFactorsWithRejectStatus.stream()
							.map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
							.collect(Collectors.toList()));
            
            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,logMessage);

            return new StatusHolder("",DECLINED);
        }

        //biometric trust factors in review
        List<TrustFactor> trustFactorsWithReview = daoResponse.getTrustFactors().stream()
                .filter(tf -> "review".equalsIgnoreCase(tf.getResult()))
                .collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(trustFactorsWithReview)){
            
			String infoMessage = String.format(
					"Rejecting the record as TF are in review %s",
					trustFactorsWithReview.stream()
							.map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
							.collect(Collectors.toList()));
            
            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,infoMessage);

            return new StatusHolder("", DECLINED);
        }

        //document trust factors with reject except for passport and ignore document portrait genuine and screenshot photo for passport
        List<TrustFactor> documentTrustFactorsWithRejectStatus = daoResponse.getDocuments().stream()
                .filter(document -> CollectionUtils.isNotEmpty(document.getTrustFactors()))
                .flatMap(document -> document.getTrustFactors().stream())
                .filter(tf -> {

                    String type = tf.getType();
                    String docType = getDocumentType(daoResponse);

                    if(docType.equalsIgnoreCase("passport") &&
                            (type.equalsIgnoreCase("document_portrait_genuine") ||
                                    type.equalsIgnoreCase("screenshot_photo"))) {
                        return false;
                    }

                    return REJECT.equalsIgnoreCase(tf.getResult()) ;
                }).collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(documentTrustFactorsWithRejectStatus)) {
            
			String documentTrustMessage = String.format(
					"Rejecting the record as there are rejections at document trust factors %s",
					documentTrustFactorsWithRejectStatus.stream()
							.map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
							.collect(Collectors.toList()));
            
            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,documentTrustMessage);

            return new StatusHolder("", DECLINED, true);
        }

        List<TrustFactor> documentTrustFactorsWithReviewStatus = daoResponse.getDocuments().stream()
                .filter(document -> CollectionUtils.isNotEmpty(document.getTrustFactors()))
                .flatMap(document -> document.getTrustFactors().stream())
                .filter(tf -> {
                    String result = tf.getResult();
                    String type = tf.getType();
                    return  "review".equalsIgnoreCase(result)
                            && !(type.equalsIgnoreCase("document_recognized")
                            || type.equalsIgnoreCase("mrz_checksum_valid")
                            || type.equalsIgnoreCase("screenshot_photo"));
                }).collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(documentTrustFactorsWithReviewStatus)) {
            
			String reviewTrustMessage = String.format(
					"Rejecting the record as there are review at document trust factors %s",
					documentTrustFactorsWithReviewStatus.stream()
							.map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
							.collect(Collectors.toList()));
            
            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,reviewTrustMessage);

            return new StatusHolder("", DECLINED, true);
        }

        List<String> externalIds = daoResponse.getIdentifyCandidates().stream()
                        .map(IdentifyCandidate::getCandidateExternalId)
                        .collect(Collectors.toList());

        AuthToken authToken = new AuthToken(request.getAuthToken());
        
        List<RegistrationStatus> registrationStatuses = registrationStatusUtil.getByExternalIds(externalIds, authToken).stream()
                .filter(Objects::nonNull).collect(Collectors.toList());
        
		String statusMessage = String.format("registrationStatuses %s",
				registrationStatuses.stream().map(RegistrationStatus::getExternalId).collect(Collectors.toList()));
        
        daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,statusMessage);

        if(CollectionUtils.isNotEmpty(registrationStatuses)){

            registrationStatuses = registrationStatuses.stream()
                    .filter(registrationStatus -> registrationStatus.getStatus().equals("ACCEPTED"))
                    .collect(Collectors.toList());
            registrationStatuses.sort(Comparator.comparing(RegistrationStatus::getLastUpdateDateTime).reversed());
           
            String masterExternalId = registrationStatuses.get(0).getExternalId();
            
            daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,"masterExternalId : " + registrationStatuses.get(0).getExternalId());
            
            GetCustomerDetailsDaoResponse getCustomerDetailsDaoResponse =
                    getCustomerDetailsDao.queryByExternalId(masterExternalId, true);

            //Only do fuzzy match on name for now. in Next phase we will handle dob match
           */
/* if(daoResponse.getCustomDetails().getDateOfBirth() != null &&
                    getCustomerDetailsDaoResponse.getCustomDetails().getDateOfBirth() != null &&
                    !daoResponse.getCustomDetails().getDateOfBirth().equals(getCustomerDetailsDaoResponse.getCustomDetails().getDateOfBirth())){
                
				daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,
						"declining because date of birth does not match for external Id and master record : "
								+ masterExternalId);
                
                return new StatusHolder(masterExternalId, DECLINED);
            }*//*


            String currentFullName = getFullNameFromUpdatedValue(updatedValues);
            String fullNameInMaster = getCustomerDetailsDaoResponse.getCustomDetails().getFullName();
            String phoneNo = getCustomerDetailsDaoResponse.getCustomDetails().getPhoneNumber();


            //checking phone number to handle partial updates

            if(phoneNo != null && fullNameInMaster != null) {
                if (doFuzzyMatch(currentFullName, fullNameInMaster, topLevelOpaqueData)) {

                    //Handling for existing master will not have master external ID set and hence checking for empty.
                    String finalMasterExternalId = StringUtils.isNotEmpty(getCustomerDetailsDaoResponse.getCustomDetails().getPersonalNumber()) ?
                            getCustomerDetailsDaoResponse.getCustomDetails().getPersonalNumber() : masterExternalId;

                    daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData, "setting as master: " + finalMasterExternalId + " found masterExternalId: " + masterExternalId);

                    return new StatusHolder(finalMasterExternalId, MASTER);
                } else {

                    daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData, "Name fuzzy match fails, setting as declined and masterExternalId is " + masterExternalId);

                    return new StatusHolder(masterExternalId, DECLINED);
                }
            }
        }

		daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,
				"Setting as master as there is no records with accepted status in the system");

        //As TP declines second onboarding by uniqueness if the face already present and hence need to consider this onboarding as master record
        return new StatusHolder(daoResponse.getExternalId(), MASTER);
    }

    private String getDocumentType(GetCustomerDetailsDaoResponse daoResponse) {
        String docType = "";

        if(CollectionUtils.isNotEmpty(daoResponse.getDocuments())
                && StringUtils.isNotEmpty(daoResponse.getDocuments().get(0).getType())) {
            docType = daoResponse.getDocuments().get(0).getType().toLowerCase();
        }

        return docType;
    }

    public static class StatusHolder {
        private final String externalId;
        private final String status;
        private final boolean isRejectedDueToDocumentIssue;

        public StatusHolder(String externalId, String status) {
            this.externalId = externalId;
            this.status = status;
            this.isRejectedDueToDocumentIssue = false;
        }

        public StatusHolder(String externalId, String status, boolean isRejectedDueToDocumentIssue) {
            this.externalId = externalId;
            this.status = status;
            this.isRejectedDueToDocumentIssue = isRejectedDueToDocumentIssue;
        }

        public String getExternalId() {
            return externalId;
        }

        public String getStatus() {
            return status;
        }

        public boolean isRejectedDueToDocumentIssue() {
            return isRejectedDueToDocumentIssue;
        }
    }

    public static class SimActivationAndDocumentUploadResult{
        private final boolean isSimActivationRequestSent;
        private final List<AdditionalDocument> uploadedDocuments;

        private final boolean isUploadDocumentSuccessful;

        public SimActivationAndDocumentUploadResult(boolean isSimActivationRequestSent, List<AdditionalDocument> uploadedDocuments, boolean isUploadDocumentSuccessful) {
            this.isSimActivationRequestSent = isSimActivationRequestSent;
            this.uploadedDocuments = uploadedDocuments;
            this.isUploadDocumentSuccessful = isUploadDocumentSuccessful;
        }

        public boolean isSimActivationRequestSent() {
            return isSimActivationRequestSent;
        }

        public List<AdditionalDocument> getUploadedDocuments() {
            return uploadedDocuments;
        }

        public boolean isUploadDocumentSuccessful() {
            return isUploadDocumentSuccessful;
        }

        public boolean isSuccess(){
            return isSimActivationRequestSent && isUploadDocumentSuccessful;
        }
    }
}
*/
