package org.techdisqus.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovatrics.dot.integrationsamples.disapi.model.DocumentType;
import com.innovatrics.dot.integrationsamples.disapi.model.GetCustomerResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.UpdateApplicantCustomDetailsDao;
import org.techdisqus.dao.UpdateApplicantGalleryDao;
import org.techdisqus.dao.UpdateApplicantStatusDao;
import org.techdisqus.dao.UpdateCustomAttributesDao;
import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.custom.attributes.*;
import org.techdisqus.dao.response.gallery.GalleryUpdateDaoResponse;
import org.techdisqus.dao.response.status.update.StatusUpdateDaoResponse;
import org.techdisqus.request.AccountType;
import org.techdisqus.request.Address;
import org.techdisqus.request.Document;
import org.techdisqus.request.RegisterUserRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.service.utils.ConfigCacheManager;
import org.techdisqus.service.utils.DateUtils;
import org.techdisqus.service.utils.FieldTransformer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.techdisqus.service.utils.DateUtils.isValidDateFormat;
import static org.techdisqus.service.utils.DocumentUtils.*;


@Component
public class UpdateCustomAttributesUtil extends KycBaseService {


    @Autowired
    private UpdateApplicantGalleryDao updateApplicantGalleryDao;

    @Autowired
    private UpdateApplicantStatusDao updateApplicantStatusDao;

    @Autowired
    private UpdateApplicantCustomDetailsDao updateApplicantCustomDetailsDao;

    @Autowired
    private UpdateCustomAttributesDao updateCustomAttributesDao;


    @Autowired
    private ConfigCacheManager cacheManager;

    private final boolean useGraphQL = true;

    private static final Logger logger = LoggerFactory.getLogger(UpdateCustomAttributesUtil.class);

    public boolean updateCustomAttributes(RegisterUserRequest request,
                                          String externalId, GetCustomerDetailsDaoResponse daoResponse,
                                          List<Document> uploadedDocs, RegistrationUtil.StatusHolder statusHolder,
                                          GetCustomerResponse customerInfo, String errorInfo) {

        Map<String, String> reqInfo = request.getRequestInformation();

        String msisdn = reqInfo.get("msisdn");
        String encryptedMsisdn = encryptionUtil.encrypt(msisdn);

        logger.info("updating custom attributes for externalId {} encryptedMsisdn {} ", externalId, encryptedMsisdn);

        List<ExtractedData> derivedValues = request.getExtractedDataList().stream()
                .filter(derivedValue -> derivedValue.getValue() != null).collect(Collectors.toList());
        List<ExtractedData> updatedValues = request.getUpdatedValues().stream()
                .filter(derivedValue -> derivedValue.getValue() != null).collect(Collectors.toList());

        AccountType accountType = request.getSelectedAccountType();
        Address personalAddress = request.getAddresses().stream()
                .filter(address -> address.getType().equalsIgnoreCase("personal"))
                .findFirst().orElse(new Address());

        String companyName = reqInfo.get("companyName");

        Map<String, String> derivedValueMap = derivedValues.stream().collect(
                Collectors.toMap(ExtractedData::getKey, ExtractedData::getValue));

        Map<String, String> updatedValuesMap = updatedValues.stream().collect(
                Collectors.toMap(ExtractedData::getKey, ExtractedData::getValue));

        String fullName = getFullName(derivedValueMap);
        String[] namesTokens = fullName.split(" ");

        String dateTime = DateUtils.getDateTime();

        if(logger.isInfoEnabled()) {
            /*daoValidationAndLoggingUtil.addSimpleLog(opqData, "uploaded docs are " +
                    uploadedDocs.stream().map(doc -> doc.getType() + ":" + doc.getLocation() + ":" + doc.getUploadedSuccessfully()).collect(Collectors.toList()));*/
        }

        Map<String, String> documentsMap = uploadedDocs.stream()
                .filter(doc -> Boolean.TRUE.equals(doc.isUploadedSuccessfully()) && doc.getLocation() != null && doc.getType() != null)
                .collect(Collectors.toMap(Document::getType, Document::getLocation));

        String status = statusHolder != null ? statusHolder.getStatus() : MASTER;

        String documentType = getDocumentType(customerInfo, reqInfo);



        CustomDetails customDetails = new CustomDetails()
                .withPhoneNumber(msisdn)
                .withRegistrationNumber(externalId)
                .withTransactionNumber(reqInfo.get("referenceId"))
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

                .withPlaceOfIssue(derivedValueMap.get(PLACE_OF_ISSUE))
                .withIssuingAuthority(derivedValueMap.get(ISSUING_AUTHORITY))
                .withSexNationalLanguage(updatedValuesMap.get(GENDER))
                .withDateOfBirthNationalLanguage(updatedValuesMap.get(DATE_OF_BIRTH))
                .withDocumentTypeNationalLanguage(documentType);


        if(StringUtils.isNotEmpty(derivedValueMap.get(DATE_OF_ISSUE)) && isValidDateFormat(derivedValueMap.get(DATE_OF_ISSUE))){
            customDetails.setDateOfIssue(derivedValueMap.get(DATE_OF_ISSUE));
        } else {
        }

        setCompanyAddress(request.getAddresses(), customDetails, companyName);

        customDetails.withVotingCountryCode("PHL")
                .withVotingCentreName(personalAddress.getAddressLine1() + " " + personalAddress.getAddressLine2())
                .withVotingConstituencyName(personalAddress.getCity())
                .withProvince(personalAddress.getState())
                .withWorkPermitNumber(personalAddress.getPostalCode())
                .withEmployer(reqInfo.get("brand"))
                .withTransactionType("NEW")
                .withUpdateType("ACTIVE")
                .withProcedure("REALTIME")
                .withSourceSystem("PHYSICAL")
                .withRegistrationType(accountType.getKey())
                .withLocation(reqInfo.getOrDefault("channelId","C01"))
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
                String rejectReasons = getRejectReasons(daoResponse, reqInfo);

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

                if (CollectionUtils.isNotEmpty(customAttributesUpdateGrpahQlDaoResponse.getErrors())) {
/*
                    daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateApplicantCustomDetailsDao.getClass(), opqData,
                            "There are errors while updating custom attributes using graphQL interface and hence returning error and errors are "
                                    + customAttributesUpdateGrpahQlDaoResponse.getErrors().stream().map(GraphQlError::getMessage).collect(Collectors.joining()));
*/

                return false;
            }

        }else {
            //using REST API
            CustomDetailsDaoRequest daoRequest = new CustomDetailsDaoRequest();
            daoRequest.setCustomDetails(customDetails);
            CustomAttributeUpdateDaoResponse customAttributeUpdateDaoResponse = updateCustomAttributesDao.updateCustomAttributes(externalId, daoRequest);

            if(customAttributeUpdateDaoResponse.getErrorCode() != null) {
                //customAttributeUpdateDaoResponse.getErrorCode() != null
                /*daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateCustomAttributesDao.getClass(), opqData,
                        "Error while updating custom attributes using fields API and hence returning error and "
                                + " errorCode: " + customAttributeUpdateDaoResponse.getErrorCode()
                                + " errorMessage: " + customAttributeUpdateDaoResponse.getErrorMessage());*/

                return false;
            }
        }

        if(!daoResponse.getStatus().equalsIgnoreCase(status)) {

            //update status
            Map<String, Object> variablesForStatusUpdate = new HashMap<>();
            LocalDateTime startTime = LocalDateTime.now();
//            daoValidationAndLoggingUtil.addSimpleLog(opqData, String.format("Updating status for applicant %s to %s", externalId, status));

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
                return false;
            }

            LocalDateTime endTime = LocalDateTime.now();

            //update gallery
            logger.info("Updating status for applicant {} to {}", externalId, status);

            //updating gallery
            GalleryUpdateDaoResponse galleryUpdateDaoResponse = updateApplicantGalleryDao.updateGallery(externalId, status);

            /*if(!daoValidationAndLoggingUtil.validateDotResponse("/abis/v3/applicants/" + externalId + "/fields", UpdateApplicantGalleryDao.class, galleryUpdateDaoResponse, opqData)) {
                daoValidationAndLoggingUtil.addSimpleDaoRelatedError(updateApplicantGalleryDao.getClass(), opqData,
                        "Error while update gallery to " + status
                                + " errorCode: " + galleryUpdateDaoResponse.getErrorCode()
                                + " errorMessage: " + galleryUpdateDaoResponse.getErrorMessage());
                return false;
            }*/
        }

        return true;

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


        return allTrustFactors.stream()
                .filter(trustFactor -> trustFactor.getResult().equalsIgnoreCase(REJECT))
                .map(TrustFactor::getType)
                .collect(Collectors.joining("|"));
    }

    private String getDocumentType(GetCustomerResponse customerInfo, Map<String, String> reqInfo){

        DocumentType type = customerInfo.getCustomer().getDocument().getType();

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
            //daoValidationAndLoggingUtil.addSimpleLog(opaqueData, "type is NULL and hence returning document type as empty");
        }

        //daoValidationAndLoggingUtil.addSimpleLog(opaqueData,  " supportLevel: "+ supportLevel + " edition: " + edition + " documentType: " + derivedDocumentType);

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
                return key;
        }
    }

    private void setCompanyAddress(List<Address> addresses, CustomDetails customDetails, String companyName) {
        Optional<Address> companyAddressOptional = addresses.stream()
                .filter(address -> address.getType().equalsIgnoreCase("company"))
                .findFirst();

        companyAddressOptional.ifPresent(companyAddress -> customDetails.withNotes(companyName)
                .withRegistrationCountryCode("PHL")
                .withRegistrationCentreName(companyAddress.getAddressLine1() + " " + companyAddress.getAddressLine1())
                .withRegistrationConstituencyName(companyAddress.getCity())
                .withRegion(companyAddress.getState())
                .withRegistrationWardName(companyAddress.getArea())
                .withSection(companyAddress.getPostalCode()));
    }


    private String getFullName(Map<String, String> derivedValueMap) {
        return derivedValueMap.get("fullName");
    }


}
