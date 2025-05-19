package org.techdisqus.service;


import com.innovatrics.dot.integrationsamples.disapi.model.GetCustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.GetCustomerDetailsDao;
import org.techdisqus.dao.GetImageDao;
import org.techdisqus.dao.RegisterEventDao;
import org.techdisqus.dao.RegistrationStatus;
import org.techdisqus.dao.request.RegistrationEventDaoRequest;
import org.techdisqus.dao.response.RegistrationEventResponse;
import org.techdisqus.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;
import org.techdisqus.dao.response.custom.attributes.IdentifyCandidate;
import org.techdisqus.dao.response.custom.attributes.TrustFactor;
import org.techdisqus.request.Document;
import org.techdisqus.request.RegisterUserRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.service.utils.RegistrationStatusUtil;
import org.techdisqus.service.utils.SimActivationUtil;
import org.techdisqus.service.utils.UploadDocumentUtil;
import org.techdisqus.service.utils.Utils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RegistrationUtil extends KycBaseService {


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

    @Autowired
    private Utils utils;


    private static final List<Document> empty = Collections.emptyList();



    public SimActivationAndDocumentUploadResult activateSimAndUploadDocs(String externalId, RegisterUserRequest request, Map<String, String> opaqueData,
                                                                         List<Document> additionalDocuments, String customerId, GetCustomerResponse currentCustomerDetailsDaoResponse){


        String encryptedMsisdn = encryptionUtil.encrypt(request.getRequestInformation().get("msisdn"));
        


        List<Document> uploadedDocuments = null;

        boolean simActivationRequestSent = true;
        boolean isUploadDocumentsSuccessful = true;

        SimActivationUtil.SimActivateDetails simActivateDetails = getSimActivateDetails(externalId, request, opaqueData);
        RegistrationEventDaoRequest daoRequest = simActivationUtil.getRegistrationEventDaoRequest(simActivateDetails);
        RegistrationEventResponse registrationEventDaoResponse = registerEventDao.registerSim(daoRequest);

        if(uploadedDocuments.stream().anyMatch(additionalDocument -> Boolean.FALSE.equals(additionalDocument.isUploadedSuccessfully()))){
            isUploadDocumentsSuccessful = false;
        }

        return new SimActivationAndDocumentUploadResult(simActivationRequestSent, uploadedDocuments, isUploadDocumentsSuccessful);
    }

    private SimActivationUtil.SimActivateDetails getSimActivateDetails(String externalId, RegisterUserRequest request, Map<String, String> opaqueData) {
        SimActivationUtil.SimActivateDetails simActivateDetails = new SimActivationUtil.SimActivateDetails();
        simActivateDetails.setAccountType(request.getSelectedAccountType());
        simActivateDetails.setMsisdn(request.getRequestInformation().get("msisdn"));
        simActivateDetails.setChannelId(opaqueData.getOrDefault("channelId", "C01"));
        simActivateDetails.setExternalId(externalId);
        String brand = opaqueData.get("brand");

        simActivateDetails.setBrand(brand);
        String simType = opaqueData.getOrDefault("simType", "PHYSICAL");

        if(simType.equals("Physical")){
            simType = "PHYSICAL";
        }else if(simType.equalsIgnoreCase("esim")){
            simType = "eSIM";
        }

        simActivateDetails.setSimType(simType);

        return simActivateDetails;
    }

    private Document getSelfie(RegisterUserRequest request, String image){
        Document additionalDocument = new Document();
        additionalDocument.setName("selfie");
        additionalDocument.setType("selfie");
        additionalDocument.setImage(image);
        return additionalDocument;
    }

    private Document getIdDocument(RegisterUserRequest request, String image){
        Document additionalDocument = new Document();
        additionalDocument.setName("idCard");
        additionalDocument.setType("idCard");
        additionalDocument.setImage(image);
        return additionalDocument;
    }

    public boolean updateCustomAttributesForError(RegisterUserRequest request,
                                                  String externalId, GetCustomerDetailsDaoResponse daoResponse, GetCustomerResponse customerInfo, String errorInfo){

        return updateCustomAttributesUtil.updateCustomAttributes(request,externalId,daoResponse,empty, new StatusHolder(externalId, DECLINED), customerInfo, errorInfo);
    }
    public boolean updateCustomAttributes(RegisterUserRequest request,
                                          String externalId, GetCustomerDetailsDaoResponse daoResponse,
                                          List<Document> uploadedDocs, StatusHolder statusHolder, GetCustomerResponse customerInfo){
        return updateCustomAttributesUtil.updateCustomAttributes(request,externalId,daoResponse,uploadedDocs,statusHolder,customerInfo, "");
    }

    public StatusHolder checkInReviewOnlyForDocumentRecognized( GetCustomerDetailsDaoResponse daoResponse, Map<String, String> topLevelOpaqueData){

        List<TrustFactor> trustFactorsWithRejectStatus = daoResponse.getTrustFactors().stream()
                .filter(tf -> REJECT.equalsIgnoreCase(tf.getResult()) && !UNIQUENESS.equalsIgnoreCase(tf.getType()))
                .collect(Collectors.toList());

        //rejected for other type than uniqueness

        if(CollectionUtils.isNotEmpty(trustFactorsWithRejectStatus)){

            String logMessage = String.format("Rejecting the record as there are rejections apart from uniqueness %s",
                    trustFactorsWithRejectStatus.stream()
                            .map(trustFactor -> trustFactor.getType() + ":" + trustFactor.getResult())
                            .collect(Collectors.toList()));


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

            return new StatusHolder("", DECLINED, true);
        }

        return new StatusHolder(daoResponse.getExternalId(),MASTER);
    }

    public StatusHolder checkDeclinedOnlyForUniqueness(RegisterUserRequest request, List<ExtractedData> updatedValues, GetCustomerDetailsDaoResponse daoResponse, Map<String, String> topLevelOpaqueData){


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
            
            return new StatusHolder("", DECLINED, true);
        }

        List<String> externalIds = daoResponse.getIdentifyCandidates().stream()
                        .map(IdentifyCandidate::getCandidateExternalId)
                        .collect(Collectors.toList());


        List<RegistrationStatus> registrationStatuses = registrationStatusUtil.getByExternalIds(externalIds, request).stream()
                .filter(Objects::nonNull).collect(Collectors.toList());
        
		String statusMessage = String.format("registrationStatuses %s",
				registrationStatuses.stream().map(RegistrationStatus::getExternalId).collect(Collectors.toList()));
        
        if(CollectionUtils.isNotEmpty(registrationStatuses)){

            registrationStatuses = registrationStatuses.stream()
                    .filter(registrationStatus -> registrationStatus.getStatus().equals("ACCEPTED"))
                    .collect(Collectors.toList());
            registrationStatuses.sort(Comparator.comparing(RegistrationStatus::getLastUpdateDateTime).reversed());
           
            String masterExternalId = registrationStatuses.get(0).getExternalId();
            

            GetCustomerDetailsDaoResponse getCustomerDetailsDaoResponse =
                    getCustomerDetailsDao.queryByExternalId(masterExternalId, true);

            //Only do fuzzy match on name for now. in Next phase we will handle dob match
           /* if(daoResponse.getCustomDetails().getDateOfBirth() != null &&
                    getCustomerDetailsDaoResponse.getCustomDetails().getDateOfBirth() != null &&
                    !daoResponse.getCustomDetails().getDateOfBirth().equals(getCustomerDetailsDaoResponse.getCustomDetails().getDateOfBirth())){
                
				daoValidationAndLoggingUtil.addSimpleLog(topLevelOpaqueData,
						"declining because date of birth does not match for external Id and master record : "
								+ masterExternalId);
                
                return new StatusHolder(masterExternalId, DECLINED);
            }*/

            String currentFullName = getFullNameFromUpdatedValue(updatedValues);
            String fullNameInMaster = getCustomerDetailsDaoResponse.getCustomDetails().getFullName();
            String phoneNo = getCustomerDetailsDaoResponse.getCustomDetails().getPhoneNumber();


            //checking phone number to handle partial updates

            if(phoneNo != null && fullNameInMaster != null) {
                if (utils.doFuzzyMatch(currentFullName, fullNameInMaster, request.getRequestInformation())) {

                    //Handling for existing master will not have master external ID set and hence checking for empty.
                    String finalMasterExternalId = StringUtils.isNotEmpty(getCustomerDetailsDaoResponse.getCustomDetails().getPersonalNumber()) ?
                            getCustomerDetailsDaoResponse.getCustomDetails().getPersonalNumber() : masterExternalId;

                    return new StatusHolder(finalMasterExternalId, MASTER);
                } else {

                    return new StatusHolder(masterExternalId, DECLINED);
                }
            }
        }


        //As TP declines second onboarding by uniqueness if the face already present and hence need to consider this onboarding as master record
        return new StatusHolder(daoResponse.getExternalId(), MASTER);
    }

    private String getFullNameFromUpdatedValue(List<ExtractedData> updatedValues) {
        return "";
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
        private final List<Document> uploadedDocuments;

        private final boolean isUploadDocumentSuccessful;

        public SimActivationAndDocumentUploadResult(boolean isSimActivationRequestSent, List<Document> uploadedDocuments, boolean isUploadDocumentSuccessful) {
            this.isSimActivationRequestSent = isSimActivationRequestSent;
            this.uploadedDocuments = uploadedDocuments;
            this.isUploadDocumentSuccessful = isUploadDocumentSuccessful;
        }

        public boolean isSimActivationRequestSent() {
            return isSimActivationRequestSent;
        }

        public List<Document> getUploadedDocuments() {
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
