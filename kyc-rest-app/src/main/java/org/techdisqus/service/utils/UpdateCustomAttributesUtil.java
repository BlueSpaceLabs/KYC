/*
package org.example.service.utils;

import com.awarex.security.AuthToken;
import com.awarex.umw.exception.service.CustomerServiceException;
import com.awarex.umw.impl.globe.dao.dot.GetImageDao;
import com.awarex.umw.impl.globe.dao.dot.UpdateApplicantCustomDetailsDao;
import com.awarex.umw.impl.globe.dao.dot.UpdateApplicantGalleryDao;
import com.awarex.umw.impl.globe.dao.dot.UpdateApplicantStatusDao;
import com.awarex.umw.impl.globe.dao.dot.UpdateCustomAttributesDao;
import com.awarex.umw.impl.globe.dao.request.custom.attributes.CustomAttributeUpdateDaoRequest;
import com.awarex.umw.impl.globe.dao.request.dot.graphql.QueryDaoRequest;
import com.awarex.umw.impl.globe.dao.response.GraphQlError;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.CustomAttributeUpdateDaoResponse;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.CustomAttributesUpdateGrpahQlDaoResponse;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.CustomDetails;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.CustomDetailsDaoRequest;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.DocumentPage;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.Image;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.LivenessPhoto;
import com.awarex.umw.impl.globe.dao.response.custom.attributes.TrustFactor;
import com.awarex.umw.impl.globe.dao.response.dot.document.CustomerInfoDaoResponse;
import com.awarex.umw.impl.globe.dao.response.dot.document.Type;
import com.awarex.umw.impl.globe.dao.response.dot.gallery.GalleryUpdateDaoResponse;
import com.awarex.umw.impl.globe.dao.response.dot.status.update.StatusUpdateDaoResponse;
import com.awarex.umw.impl.globe.services.GlobeBaseService;
import com.awarex.umw.impl.globe.services.utils.GlobeDigitalOnboardingRegistrationUtil.StatusHolder;
import com.awarex.umw.model.AccountType;
import com.awarex.umw.model.AdditionalDocument;
import com.awarex.umw.model.Address;
import com.awarex.umw.model.DerivedValue;
import com.awarex.umw.model.DigitalOnboardingConfig;
import com.awarex.umw.request.RegisterDigitalOnboardingUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.awarex.umw.impl.globe.services.utils.DigitalOnboardingUtils.DATE_OF_BIRTH;
import static com.awarex.umw.impl.globe.services.utils.DigitalOnboardingUtils.DATE_OF_ISSUE;
import static com.awarex.umw.impl.globe.services.utils.DigitalOnboardingUtils.GENDER;
import static com.awarex.umw.impl.globe.services.utils.DigitalOnboardingUtils.ISSUING_AUTHORITY;
import static com.awarex.umw.impl.globe.services.utils.DigitalOnboardingUtils.PLACE_OF_ISSUE;

@Component
public class UpdateCustomAttributesUtil extends GlobeBaseService {

    @Autowired
    private GetImageDao getImageDao;

    @Autowired
    private UpdateApplicantGalleryDao updateApplicantGalleryDao;

    @Autowired
    private UpdateApplicantStatusDao updateApplicantStatusDao;

    @Autowired
    private UpdateApplicantCustomDetailsDao updateApplicantCustomDetailsDao;

    @Autowired
    private UpdateCustomAttributesDao updateCustomAttributesDao;


    @Autowired
    private CacheManager cacheManager;

    private final boolean useGraphQL = true;

    private static final Logger logger = LoggerFactory.getLogger(UpdateCustomAttributesUtil.class);

    public boolean updateCustomAttributes(RegisterDigitalOnboardingUserRequest request,
                                          String externalId, GetCustomerDetailsDaoResponse daoResponse,
                                          List<AdditionalDocument> uploadedDocs, StatusHolder statusHolder,
                                          CustomerInfoDaoResponse customerInfo, String errorInfo) {

        DigitalOnboardingConfig config = request.getDigitalOnboardingConfig();
        String encryptedMsisdn = encryptionUtil.encrypt(config.getPhoneNumber());

        logger.info("updating custom attributes for externalId {} encryptedMsisdn {} ", externalId, encryptedMsisdn);


        Map<String, String> opqData = request.getOpaqueData();
        opqData.put("externalId", externalId);

        List<DerivedValue> derivedValues = config.getDocumentInformation().getDerivedValues().stream()
                .filter(derivedValue -> derivedValue.getValue() != null).collect(Collectors.toList());
        List<DerivedValue> updatedValues = config.getDocumentInformation().getUpdatedValues().stream()
                .filter(derivedValue -> derivedValue.getValue() != null).collect(Collectors.toList());

        AccountType accountType = config.getAccountType();
        Address personalAddress = config.getAddresses().stream()
                .filter(address -> address.getTypeKey().equalsIgnoreCase("personal"))
                .findFirst().orElse(new Address());

        String companyName = config.getCompanyName();

        Map<String, String> derivedValueMap = derivedValues.stream().collect(
                Collectors.toMap(DerivedValue::getKey, DerivedValue::getValue));

        Map<String, String> updatedValuesMap = updatedValues.stream().collect(
                Collectors.toMap(DerivedValue::getKey, DerivedValue::getValue));

        String fullName = getFullName(derivedValueMap);
        String[] namesTokens = fullName.split(" ");

        String dateTime = getDateTime();

        if(logger.isInfoEnabled()) {
            daoValidationAndLoggingUtil.addSimpleLog(opqData, "uploaded docs are " +
                    uploadedDocs.stream().map(doc -> doc.getType() + ":" + doc.getLocation() + ":" + doc.getUploadedSuccessfully()).collect(Collectors.toList()));
        }

        Map<String, String> documentsMap = uploadedDocs.stream()
                .filter(doc -> Boolean.TRUE.equals(doc.getUploadedSuccessfully()) && doc.getLocation() != null && doc.getType() != null)
                .collect(Collectors.toMap(AdditionalDocument::getType, AdditionalDocument::getLocation));

        String status = statusHolder != null ? statusHolder.getStatus() : MASTER;

        String documentType = getDocumentType(customerInfo, opqData);



        CustomDetails customDetails = new CustomDetails()
                .withPhoneNumber(config.getPhoneNumber())
                .withRegistrationNumber(externalId)
                .withTransactionNumber(opqData.get("referenceId"))
                .withFullName(fullName)
                .withGivenNames(namesTokens[0])
                .withMiddleName(namesTokens.length == 2 ? namesTokens[1] : "")
                .withSurname(namesTokens.length == 3 ? namesTokens[2] : "")
                .withTitle(namesTokens.length == 4 ? namesTokens[3] : "")
                .withAddress(derivedValueMap.get("address"))
                .withGivenNamesNationalLanguage(updatedValuesMap.get("firstName"))
                .withMothersNameNationalLanguage(updatedValuesMap.get("middleName"))
                .withSurnameNationalLanguage(updatedValuesMap.get("lastName"))
                .withAddressCountry("PHL")
                .withPlaceOfBirth(derivedValueMap.get("placeOfBirth"))
                //.withNationality(derivedValueMap.get(NATIONALITY))
                //.withSex(derivedValueMap.get(GENDER))
                //.withDocumentType(derivedValueMap.get(DOCUMENT_TYPE))
                //.withDocumentNumber(derivedValueMap.get(DOC_NO))
                //.withDateOfExpiry(derivedValueMap.get(DATE_OF_EXPIRY))
                .withPlaceOfIssue(derivedValueMap.get(PLACE_OF_ISSUE))
                .withIssuingAuthority(derivedValueMap.get(ISSUING_AUTHORITY))
                .withSexNationalLanguage(updatedValuesMap.get(GENDER))
                .withDateOfBirthNationalLanguage(updatedValuesMap.get(DATE_OF_BIRTH))
                .withDocumentTypeNationalLanguage(documentType);


        if(StringUtils.isNotEmpty(derivedValueMap.get(DATE_OF_ISSUE)) && isValidDateFormat(derivedValueMap.get(DATE_OF_ISSUE))){
            customDetails.setDateOfIssue(derivedValueMap.get(DATE_OF_ISSUE));
        } else {
            daoValidationAndLoggingUtil.addSimpleLog(opqData, "Ignore dateOfIssue as it is not in valid format, value is " + derivedValueMap.get(DATE_OF_ISSUE));
        }

        setCompanyAddress(config.getAddresses(), customDetails, companyName);

        customDetails.withVotingCountryCode("PHL")
                .withVotingCentreName(personalAddress.getAddress1() + " " + personalAddress.getAddress2())
                .withVotingCountyName(personalAddress.getAddress3())
                .withVotingConstituencyName(personalAddress.getCity())
                .withProvince(personalAddress.getState())
                .withVotingWardName(personalAddress.getLocality())
                .withWorkPermitNumber(personalAddress.getPostalCode())
                .withEmployer(opqData.get("brand"))
                .withTransactionType("NEW")
                .withUpdateType("ACTIVE")
                .withProcedure("REALTIME")
                .withSourceSystem("PHYSICAL")
                .withRegistrationType(accountType.getTypeKey())
                .withLocation(opqData.getOrDefault("channelId","C01"))
                .withDateOfRegistration(dateTime)
                .withDateOfModification(dateTime)
                .withRecordedAt(dateTime)
                .withModification(dateTime)
                .withRecordedBy("System")
                .withLiterate("TRUE")
                .withEstimatedDate("TRUE")
                .withCan(documentsMap.get("idCard"))
                .withOtherFeatures(documentsMap.get("selfie"))
                .withChairman(documentsMap.get("Visa"))
                .withCorpulence(documentsMap.get("OtherDocument"));

        if(status.equalsIgnoreCase(MASTER)) {
            customDetails.withObservations("ACCEPT");
            customDetails.withRemarks("OK");
        }else {
            customDetails.withObservations("REJECT");

            if(StringUtils.isNotEmpty(errorInfo)) {
                customDetails.withRemarks(errorInfo);
            } else {
                String rejectReasons = getRejectReasons(daoResponse, opqData);

                //corner case handling
                if (rejectReasons.length() == 255) {
                    customDetails.withRemarks(rejectReasons.substring(0, 255));
                } else {
                    customDetails.withRemarks(rejectReasons);
                }
            }

        }


        if (statusHolder != null && StringUtils.isNotEmpty(statusHolder.getExternalId())) {
            customDetails.setPersonalNumber(statusHolder.getExternalId());
        }

        QueryDaoRequest queryDaoRequest = new QueryDaoRequest();

        Map<String, Object> variables = new HashMap<>();


        if(useGraphQL) {
            //using graphQL API
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> customDetailsMap = objectMapper.convertValue(customDetails, Map.class);

            Map<String, Object> untransformedDetails = new HashMap<>();
            customDetailsMap.forEach((key, value) -> {
                // Check if this is a code field that needs value transformation
                String normalizedKey = key.toUpperCase().replace("_", "");
                if (cacheManager.getFieldNameToCodeDefId().containsKey(normalizedKey)) {
                    // For code fields, normalize the key
                    String originalKey = key;
                    // Remove ctv prefix if present
                    if (originalKey.startsWith("ctv")) {
                        originalKey = originalKey.substring(3);
                    }
                    untransformedDetails.put(originalKey.toLowerCase(), value);
                    logger.debug("Code field prepared for value transformation: '{}' -> '{}'", key, originalKey.toLowerCase());
                } else {
                    // For non-code fields, keep the original case
                    untransformedDetails.put(key, value);
                }
            });

            // Transform values (convert codes to IDs)
            Map<String, Object> processedDetails = cacheManager.getValueTransformer().transformValues(untransformedDetails);

            // Transform field names for InternalApi API
            Map<String, Object> transformedDetails = FieldTransformer.transformFields(processedDetails);

            daoValidationAndLoggingUtil.addSimpleLog(opqData, "account type is {} "
                    + accountType.getTypeKey() + " and corresponding value is " + transformedDetails.get("ctvRegistrationType"));
            // Define the operation
            String mutation = "mutation UpdateApplicantCustomDetails($externalId: String!, $customDetailsSetInput: ApplicantCustomDetailSetInput!) {" +
                    "  updateApplicantCustomDetails(" +
                    "    _set: $customDetailsSetInput" +
                    "    where: { applicants: { externalId: { _eq: $externalId } } }" +
                    "  ) {" +
                    "    affectedRows" +
                    "  }" +
                    "}";

            // Prepare variables

            variables.put("externalId", externalId);
            variables.put("customDetailsSetInput", transformedDetails);
            queryDaoRequest.setQuery(mutation);
            queryDaoRequest.setVariables(variables);

            LocalDateTime startTime = LocalDateTime.now();
                CustomAttributesUpdateGrpahQlDaoResponse customAttributesUpdateGrpahQlDaoResponse =
                        updateApplicantCustomDetailsDao.updateCustomAttributes(queryDaoRequest);

                LocalDateTime endTime = LocalDateTime.now();

                daoValidationAndLoggingUtil.addSimpleDaoRelated(updateApplicantCustomDetailsDao.getClass(), opqData,
                        "Time taken for custom attributes update using graphQL is " + (Duration.between(startTime, endTime).toMillis()));

                if (CollectionUtils.isNotEmpty(customAttributesUpdateGrpahQlDaoResponse.getErrors())) {
                    daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateApplicantCustomDetailsDao.getClass(), opqData,
                            "There are errors while updating custom attributes using graphQL interface and hence returning error and errors are "
                                    + customAttributesUpdateGrpahQlDaoResponse.getErrors().stream().map(GraphQlError::getMessage).collect(Collectors.joining()));

                return false;
            }

        }else {
            //using REST API
            CustomDetailsDaoRequest  daoRequest = new CustomDetailsDaoRequest();
            daoRequest.setCustomDetails(customDetails);
            CustomAttributeUpdateDaoResponse customAttributeUpdateDaoResponse = updateCustomAttributesDao.updateCustomAttributes(externalId, daoRequest);

            if(!daoValidationAndLoggingUtil.validateDotResponse("/abis/v3/applicants/" + externalId + "/fields", UpdateCustomAttributesDao.class, customAttributeUpdateDaoResponse, opqData)) {
                //customAttributeUpdateDaoResponse.getErrorCode() != null
                daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateCustomAttributesDao.getClass(), opqData,
                        "Error while updating custom attributes using fields API and hence returning error and "
                                + " errorCode: " + customAttributeUpdateDaoResponse.getErrorCode()
                                + " errorMessage: " + customAttributeUpdateDaoResponse.getErrorMessage());

                return false;
            }
        }

        if(!daoResponse.getStatus().equalsIgnoreCase(status)) {

            //update status
            Map<String, Object> variablesForStatusUpdate = new HashMap<>();
            LocalDateTime startTime = LocalDateTime.now();
            daoValidationAndLoggingUtil.addSimpleLog(opqData, String.format("Updating status for applicant %s to %s", externalId, status));

            variablesForStatusUpdate.put("externalId", externalId);
            variablesForStatusUpdate.put("status", status);

            queryDaoRequest = new QueryDaoRequest();
            queryDaoRequest.setVariables(variablesForStatusUpdate);
            queryDaoRequest.setQuery("mutation UpdateApplicantStatus($externalId: String!, $status: String!) {\n" +
                    "  updateApplicants(_set: { status: $status }, where: { externalId: { _eq: $externalId } }) {\n" +
                    "    affectedRows\n" +
                    "  }\n" +
                    "}");


                StatusUpdateDaoResponse statusUpdateDaoResponse = updateApplicantStatusDao.updateStatus(queryDaoRequest);

                if (CollectionUtils.isNotEmpty(statusUpdateDaoResponse.getErrors())) {
                    daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateApplicantStatusDao.getClass(), opqData,
                            "There are errors while updating status using graphQL interface and hence returning error and errors are "
                                    + statusUpdateDaoResponse.getErrors().stream().map(GraphQlError::getMessage).collect(Collectors.joining()));

                return false;
            }

            LocalDateTime endTime = LocalDateTime.now();
            daoValidationAndLoggingUtil.addSimpleLog(opqData,"Time taken for status update time taken is  " +  (Duration.between(startTime, endTime).toMillis()));

            //update gallery
            logger.info("Updating status for applicant {} to {}", externalId, status);

            //updating gallery
            GalleryUpdateDaoResponse galleryUpdateDaoResponse = updateApplicantGalleryDao.updateGallery(externalId, status);

            if(!daoValidationAndLoggingUtil.validateDotResponse("/abis/v3/applicants/" + externalId + "/fields", UpdateApplicantGalleryDao.class, galleryUpdateDaoResponse, opqData)) {
                daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateApplicantGalleryDao.getClass(), opqData,
                        "Error while update gallery to " + status
                                + " errorCode: " + galleryUpdateDaoResponse.getErrorCode()
                                + " errorMessage: " + galleryUpdateDaoResponse.getErrorMessage());
                return false;
            }
        }

        return true;

    }

    public boolean updateCustomAttributesUsingEnroll(RegisterDigitalOnboardingUserRequest request,
                                          String externalId, GetCustomerDetailsDaoResponse daoResponse,
                                          List<AdditionalDocument> uploadedDocs, StatusHolder statusHolder,
                                          CustomerInfoDaoResponse customerInfo, String errorInfo) {

        DigitalOnboardingConfig config = request.getDigitalOnboardingConfig();
        String encryptedMsisdn = encryptionUtil.encrypt(config.getPhoneNumber());

        logger.info("updating custom attributes for externalId {} encryptedMsisdn {} ", externalId, encryptedMsisdn);

        ObjectMapper om = new ObjectMapper();
        CustomAttributeUpdateDaoRequest daoRequest;
        daoResponse.setWarnings(null);
        try{
            daoRequest = om.readValue(om.writeValueAsString(daoResponse), CustomAttributeUpdateDaoRequest.class);
        }catch (IOException e){

            AuthToken authToken = new AuthToken(request.getAuthToken());
            throw new CustomerServiceException(e, authToken);
        }

        Map<String, String> opqData = request.getOpaqueData();
        opqData.put("externalId", externalId);

        List<DerivedValue> derivedValues = config.getDocumentInformation().getDerivedValues().stream()
                .filter(derivedValue -> derivedValue.getValue() != null).collect(Collectors.toList());
        List<DerivedValue> updatedValues = config.getDocumentInformation().getUpdatedValues().stream()
                .filter(derivedValue -> derivedValue.getValue() != null).collect(Collectors.toList());

        AccountType accountType = config.getAccountType();
        Address personalAddress = config.getAddresses().stream()
                .filter(address -> address.getTypeKey().equalsIgnoreCase("personal"))
                .findFirst().orElse(new Address());

        LivenessPhoto livenessPhotoNeutral;
        LivenessPhoto livenessPhotoSmile;

        if (daoRequest.getLivenessPhotos().get(0).getAssertion().equals("SMILE")) {
            livenessPhotoSmile = daoRequest.getLivenessPhotos().get(0);
            livenessPhotoNeutral = daoRequest.getLivenessPhotos().get(1);
        } else {
            livenessPhotoNeutral = daoRequest.getLivenessPhotos().get(0);
            livenessPhotoSmile = daoRequest.getLivenessPhotos().get(1);
        }

        DocumentPage documentPage = daoRequest.getDocuments().get(0).getDocumentPages().get(0);
        Future<byte[]> smileImageFuture = getImageDao.getImageAsync(livenessPhotoSmile.getDataUrl().substring(livenessPhotoSmile.getDataUrl().indexOf("/", 8)));
        Future<byte[]> neutralImageFuture = getImageDao.getImageAsync(livenessPhotoNeutral.getDataUrl().substring(livenessPhotoNeutral.getDataUrl().indexOf("/", 8)));
        Future<byte[]> documentPageFuture = getImageDao.getImageAsync(documentPage.getDataUrl().substring(documentPage.getDataUrl().indexOf("/", 8)));

        byte[] selfyImage = getImageDao.getImage(daoRequest.getSelfies().get(0).getImage().getDataUrl().substring(daoRequest.getSelfies().get(0).getImage().getDataUrl().indexOf("/", 8)));
        Image image = new Image();
        image.setDataBytes(Base64.getEncoder().encodeToString(selfyImage));
        daoRequest.getSelfies().get(0).setImage(image);

        if (setImages(externalId, livenessPhotoNeutral, neutralImageFuture, livenessPhotoSmile, smileImageFuture, documentPage, documentPageFuture))
            return false;

        String companyName = config.getCompanyName();

        Map<String, String> derivedValueMap = derivedValues.stream().collect(
                Collectors.toMap(DerivedValue::getKey, DerivedValue::getValue));

        Map<String, String> updatedValuesMap = updatedValues.stream().collect(
                Collectors.toMap(DerivedValue::getKey, DerivedValue::getValue));

        String fullName = getFullName(derivedValueMap);
        String[] namesTokens = fullName.split(" ");

        String dateTime = getDateTime();

        if(logger.isInfoEnabled()) {
            logger.info("externalId {} encryptedMsisdn {} uploadedDocs {} ", externalId, encryptedMsisdn, uploadedDocs.stream().map(doc -> doc.getType() + ":" + doc.getLocation() + ":" + doc.getUploadedSuccessfully()).collect(Collectors.toList()));
        }

        Map<String, String> documentsMap = uploadedDocs.stream()
                .filter(doc -> Boolean.TRUE.equals(doc.getUploadedSuccessfully()) && doc.getLocation() != null && doc.getType() != null)
                .collect(Collectors.toMap(AdditionalDocument::getType, AdditionalDocument::getLocation));

        String status = statusHolder != null ? statusHolder.getStatus() : MASTER;

        String documentType = getDocumentType(customerInfo, opqData);

        daoRequest.setStatus(status);
        daoRequest.setGallery(status);
        CustomDetails customDetails = daoRequest
                .getCustomDetails()
                //.withAge(derivedValueMap.get(AGE))
                .withPhoneNumber(config.getPhoneNumber())
                .withRegistrationNumber(externalId)
                .withTransactionNumber(opqData.get("referenceId"))
                .withFullName(fullName)
                .withGivenNames(namesTokens[0])
                .withMiddleName(namesTokens.length == 2 ? namesTokens[1] : "")
                .withSurname(namesTokens.length == 3 ? namesTokens[2] : "")
                .withTitle(namesTokens.length == 4 ? namesTokens[3] : "")
                .withAddress(derivedValueMap.get("address"))
                .withGivenNamesNationalLanguage(updatedValuesMap.get("firstName"))
                .withMothersNameNationalLanguage(updatedValuesMap.get("middleName"))
                .withSurnameNationalLanguage(updatedValuesMap.get("lastName"))
                .withAddressCountry("PHL")
                .withPlaceOfBirth(derivedValueMap.get("placeOfBirth"))
                //.withNationality(derivedValueMap.get(NATIONALITY))
                //.withSex(derivedValueMap.get(GENDER))
                //.withDocumentType(derivedValueMap.get(DOCUMENT_TYPE))
                //.withDocumentNumber(derivedValueMap.get(DOC_NO))
                //.withDateOfExpiry(derivedValueMap.get(DATE_OF_EXPIRY))
                .withPlaceOfIssue(derivedValueMap.get(PLACE_OF_ISSUE))
                .withIssuingAuthority(derivedValueMap.get(ISSUING_AUTHORITY))
                .withSexNationalLanguage(updatedValuesMap.get(GENDER))
                .withDateOfBirthNationalLanguage(updatedValuesMap.get(DATE_OF_BIRTH))
                .withDocumentTypeNationalLanguage(documentType);


        if(StringUtils.isNotEmpty(derivedValueMap.get(DATE_OF_ISSUE)) && isValidDateFormat(derivedValueMap.get(DATE_OF_ISSUE))){
            customDetails.setDateOfIssue(derivedValueMap.get(DATE_OF_ISSUE));
        } else {
            daoValidationAndLoggingUtil.addSimpleLog(opqData, "ignore dateOfIssue as it is not in valid format, value is " + derivedValueMap.get(DATE_OF_ISSUE));
        }

        setCompanyAddress(config.getAddresses(), customDetails, companyName);

        customDetails.withVotingCountryCode("PHL")
                .withVotingCentreName(personalAddress.getAddress1() + " " + personalAddress.getAddress2())
                .withVotingCountyName(personalAddress.getAddress3())
                .withVotingConstituencyName(personalAddress.getCity())
                .withProvince(personalAddress.getState())
                .withVotingWardName(personalAddress.getLocality())
                .withWorkPermitNumber(personalAddress.getPostalCode())
                .withEmployer(opqData.get("brand"))
                .withTransactionType("NEW")
                .withUpdateType("ACTIVE")
                .withProcedure("REALTIME")
                .withSourceSystem("PHYSICAL")
                .withRegistrationType(accountType.getTypeKey())
                .withLocation(opqData.getOrDefault("channelId","C01"))
                .withDateOfRegistration(dateTime)
                .withDateOfModification(dateTime)
                .withRecordedAt(dateTime)
                .withModification(dateTime)
                .withRecordedBy("System")
                .withLiterate("TRUE")
                .withEstimatedDate("TRUE")
                .withCan(documentsMap.get("idCard"))
                .withOtherFeatures(documentsMap.get("selfie"))
                .withChairman(documentsMap.get("Visa"))
                .withCorpulence(documentsMap.get("OtherDocument"));

        if(status.equalsIgnoreCase(MASTER)) {
            customDetails.withObservations("ACCEPT");
            customDetails.withRemarks("OK");
        }else {
            customDetails.withObservations("REJECT");

            if(StringUtils.isNotEmpty(errorInfo)) {
                customDetails.withRemarks(errorInfo);
            } else {
                String rejectReasons = getRejectReasons(daoResponse, opqData);

                //corner case handling
                if (rejectReasons.length() == 255) {
                    customDetails.withRemarks(rejectReasons.substring(0, 255));
                } else {
                    customDetails.withRemarks(rejectReasons);
                }
            }

        }
        //.withEyesColor(derivedValueMap.get("eyeColor"))//to be added
        //.withBloodType(derivedValueMap.get("bloodType"))//to be added
        //.withWeight(derivedValueMap.get("weight"))//to be added
        //.withHeight(derivedValueMap.get("height"));//to be added

        if (statusHolder != null && StringUtils.isNotEmpty(statusHolder.getExternalId())) {
            customDetails.setPersonalNumber(statusHolder.getExternalId());
        }

        daoRequest.getSelfies().forEach(selfy -> selfy.setTemplate(null));

        CustomAttributeUpdateDaoResponse customAttributeUpdateDaoResponse =
                updateCustomAttributesDao.updateCustomAttributes(externalId, daoRequest);

        logger.info("updating custom attributes completed for daoResponse : {} for externalId {} encryptedMsisdn {}", customAttributeUpdateDaoResponse, externalId, encryptedMsisdn);

        if(StringUtils.isNotEmpty(customAttributeUpdateDaoResponse.getErrorCode())) {
            daoValidationAndLoggingUtil.addSimpleLog(opqData, "errorCode: " + customAttributeUpdateDaoResponse.getErrorCode() + " errorMessage: "  + customAttributeUpdateDaoResponse.getErrorMessage());

        }


        return StringUtils.isEmpty(customAttributeUpdateDaoResponse.getErrorCode());
    }
    private String getRejectReasons(GetCustomerDetailsDaoResponse daoResponse, Map<String, String> opqData) {

        List<TrustFactor> allTrustFactors =
                Stream.concat(daoResponse.getDocuments().stream().flatMap(document -> document.getTrustFactors().stream()),
                        daoResponse.getTrustFactors().stream()).collect(Collectors.toList());

        String rejectReviewReasonsLog = allTrustFactors.stream()
                .filter(trustFactor -> !trustFactor.getResult().equalsIgnoreCase(ACCEPT))
                .map(trustFactor -> {
                    String type = trustFactor.getType();
                    String score = "NA";
                    if(trustFactor.getScore() != null) {
                        score = trustFactor.getScore();
                    }
                    return type + ":" + score;
                })
                .collect(Collectors.joining("|"));

        daoValidationAndLoggingUtil.addSimpleErrorLog(opqData, "Reject and review trust factors and it's corresponding scores are: " + rejectReviewReasonsLog);

        return allTrustFactors.stream()
                .filter(trustFactor -> trustFactor.getResult().equalsIgnoreCase(REJECT))
                .map(TrustFactor::getType)
                .collect(Collectors.joining("|"));
    }

    private String getDocumentType(CustomerInfoDaoResponse customerInfo, Map<String, String> opaqueData){

        Type type = customerInfo.getCustomer().getDocument().getType();

        String derivedDocumentType = "";

        String supportLevel = "";
        String edition = "";

        if(type != null) {
            String docType = type.getType();
            supportLevel = type.getSupportLevel();
            edition = type.getEdition();
            if ("mrz_extraction_only".equalsIgnoreCase(type.getSupportLevel())) {
                derivedDocumentType = "Passport";
            } else if ("identity-card".equalsIgnoreCase(docType)) {
                if(edition != null) {
                    derivedDocumentType = getIdentityCardType(edition);
                }
            } else  {
                if(docType != null) {
                    derivedDocumentType = getValueForType(docType);
                }
            }
        }else {
            daoValidationAndLoggingUtil.addSimpleLog(opaqueData, "type is NULL and hence returning document type as empty");
        }

        daoValidationAndLoggingUtil.addSimpleLog(opaqueData,  " supportLevel: "+ supportLevel + " edition: " + edition + " documentType: " + derivedDocumentType);

        return derivedDocumentType;
    }

    private String getIdentityCardType(String edition) {
        String derivedDocumentType;
        switch (edition) {
            case "2011-01-01":
            case "2016-06-01":
                derivedDocumentType = "UMID";
                break;
            case "2020-10-01":
                derivedDocumentType = "Philippine Identification (National ID)";
                break;
            case "1991-01-01":
                derivedDocumentType = "BIR ID";
                break;
            case "2022-10-21":
                derivedDocumentType = "ePhilID";
                break;
            default:
                derivedDocumentType = "identity-card";
        }

        return derivedDocumentType;
    }

    private String getValueForType(String key){

        switch (key) {
            case "driving-licence":
            case "drivers-licence":
                return "Driver's License";
            case "postal-id":
                return "PhilPost Postal ID";
            case "profession-card":
                return "PRC ID";
            case "social-security":
                return "SSS ID";
            case "voter-registration":
                return "Voter's ID";
            case "passport":
                return "Passport";
            default:
                return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, key);
        }
    }

    private void setCompanyAddress(List<Address> addresses, CustomDetails customDetails, String companyName) {
        Optional<Address> companyAddressOptional = addresses.stream()
                .filter(address -> address.getTypeKey().equalsIgnoreCase("company"))
                .findFirst();

        companyAddressOptional.ifPresent(companyAddress -> customDetails.withNotes(companyName)
                .withRegistrationCountryCode("PHL")
                .withRegistrationCentreName(companyAddress.getAddress1() + " " + companyAddress.getAddress2())
                .withRegistrationCountryCode(companyAddress.getAddress3())
                .withRegistrationConstituencyName(companyAddress.getCity())
                .withRegion(companyAddress.getState())
                .withRegistrationWardName(companyAddress.getLocality())
                .withSection(companyAddress.getPostalCode()));
    }

    private static boolean setImages(String externalId, LivenessPhoto livenessPhotoNeutral, Future<byte[]> neutralImageFuture, LivenessPhoto livenessPhotoSmile, Future<byte[]> smileImageFuture, DocumentPage documentPage, Future<byte[]> documentPageFuture) {
        try {
            livenessPhotoNeutral.setDataBytes(Base64.getEncoder().encodeToString(neutralImageFuture.get()));//what ever you got from API
            livenessPhotoSmile.setDataBytes(Base64.getEncoder().encodeToString(smileImageFuture.get()));//what ever you got from API
            documentPage.setDataBytes(Base64.getEncoder().encodeToString(documentPageFuture.get()));
        } catch (InterruptedException e) {
            logger.error("Error while getting images and hence returning for externalId {}", externalId, e);
            Thread.currentThread().interrupt();
            return true;
        } catch (ExecutionException e) {
            logger.error("ExecutionException: Error while getting images and hence returning for externalId {}", externalId, e);
            return true;
        }

        return false;
    }

    private String getFullName(Map<String, String> derivedValueMap) {
        return derivedValueMap.get("fullName");
    }


}
*/
