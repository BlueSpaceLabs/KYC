package org.techdisqus.service;

import com.innovatrics.dot.integrationsamples.disapi.model.*;

import com.innovatrics.dot.integrationsamples.disapi.model.CreateDocumentRequest.SourcesEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.techdisqus.exception.ApiExecutionException;
import org.techdisqus.exception.InvalidDocumentException;
import org.techdisqus.request.DocumentScanRequest;
import org.techdisqus.response.DocumentScanResponse;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.service.util.ApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.service.utils.DocumentUtils;
import org.techdisqus.service.validators.DocumentValidators.*;
import org.techdisqus.util.Result;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.innovatrics.dot.integrationsamples.disapi.model.CreateDocumentRequest.SourcesEnum.DOCUMENT_PORTRAIT;
import static com.innovatrics.dot.integrationsamples.disapi.model.CreateDocumentRequest.SourcesEnum.MRZ;
import static org.techdisqus.service.utils.DocumentUtils.mrz;
import static org.techdisqus.service.utils.DocumentUtils.visualZone;


@Component
@Slf4j
public class DocumentScanServiceImpl extends KycBaseService implements DocumentScanService{


    @Autowired
    private CustomerOnboardingApi customerOnboardingApi;

    @Autowired
    private CustomerDateOfBirthValidator customerDateOfBirthValidator;

    @Autowired
    private SupportedDocumentTypeValidator supportedDocumentTypeValidator;

    @Autowired
    private DocumentExpiryValidator documentExpiryValidator;

    @Autowired
    private LowOcrConfidenceTextsValidator lowOcrConfidenceTextsValidator;

    @Autowired
    private MrzValidator mrzValidator;

    @Override
    public DocumentScanResponse scanDocument(DocumentScanRequest request) {

        DocumentScanResponse response =  DocumentScanResponse.builder().build();
        response.setRequestId(getRequestId());
        Map<String, String> reqInfo = request.getRequestInformation();
        response.setSpanId(reqInfo.get("spanId"));

        try {
            final CreateCustomerResponse customerResponse = customerOnboardingApi.createCustomer();
            String customerId = customerResponse.getId();
            log.info("Customer created with id: {}", customerId);

            customerOnboardingApi.createDocument(customerId, new CreateDocumentRequest().advice(new DocumentAdvice()
                    .classification(new DocumentClassificationAdvice())).sources(getSources()));
            CreateDocumentPageResponse createDocumentResponseFront = customerOnboardingApi.createDocumentPage1(customerId, new CreateDocumentPageRequest().image(new Image().data(Base64.getDecoder().decode(request.getImage()))));

            CreateDocumentPageResponse.ErrorCodeEnum documentFrontError = createDocumentResponseFront.getErrorCode();

            if (documentFrontError != null) {
                log.error(documentFrontError.getValue());
            }

            DocumentType documentType = createDocumentResponseFront.getDocumentType();

            if(documentType == null || "NOT_SUPPORTED".equalsIgnoreCase(documentType.getSupportLevel())) {
                throw new InvalidDocumentException("Document is not supported", "Document is not supported", "doc.is.not.supported", request);
            }

            String type = (documentType.getType() != null) ?  documentType.getType() : "";

            AtomicBoolean isPassport =
                    new AtomicBoolean(type.equalsIgnoreCase("passport") || StringUtils.isNoneEmpty(documentType.getMachineReadableTravelDocument()));

            if(isPassport.get() && request.getSelectedAccountType().getKey().toLowerCase().contains("foreign")) {
                return setAndReturnErrorResponse("invalid.acct.selection", "Invalid document, foreigners must use  passport", response);
            }

            if(!request.getSelectedAccountType().getKey().toLowerCase().contains("foreign") && !isLocalCitizen(documentType.getCountry())) {
                return setAndReturnErrorResponse("invalid.acct.selection", "Incorrect document used for onboarding", response);
            }


            CompletableFuture<GetCustomerResponse> customerResponseCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.getCustomerAsync(customerId, callback), request);

            CompletableFuture<DocumentInspectResponse> documentInspectResponseCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.documentInspectAsync(customerId, callback), request);

            CompletableFuture<DocumentInspectDiscloseResponse> documentInspectDiscloseResponseCompletableFuture =
                    ApiHelper.execute(callback -> customerOnboardingApi.documentInspectDiscloseAsync(customerId, callback), request);

            CompletableFuture.allOf(customerResponseCompletableFuture, documentInspectResponseCompletableFuture, documentInspectDiscloseResponseCompletableFuture).thenApply(unused -> {
                try {

                    DocumentInspectDiscloseResponse documentInspectDiscloseResponse = documentInspectDiscloseResponseCompletableFuture.get();
                    documentInspectDiscloseResponse.getPageTampering().forEach((key, pageTamperingInspectionDisclose) -> {
                        if(pageTamperingInspectionDisclose.getDocumentPortraitGenuine() != null) {
                            log.info("key {} and score is {} ", key, pageTamperingInspectionDisclose.getDocumentPortraitGenuine().getScore());
                        }
                    });

                    GetCustomerResponse getCustomerResponse = customerResponseCompletableFuture.get();

                    Result<Boolean> result = customerDateOfBirthValidator.validate(new ValidationContext<>(getCustomerResponse, mrz, isPassport.get(), request));

                    if(!result.getResponse()) {
                        return setAndReturnErrorResponse("invalid.dob", "Invalid date of birth", response);
                    }

                    DocumentUtils.ContextHolder contextHolder = new DocumentUtils.ContextHolder(getCustomerResponse.getCustomer());

                    String nationality;

                    if(isPassport.get()){
                        nationality = DocumentUtils.getNationality(contextHolder, mrz);
                    }else {
                        nationality = DocumentUtils.getNationality(contextHolder, visualZone);
                    }

                    if(StringUtils.isEmpty(nationality)) {
                        nationality = documentType.getCountry();
                    }

                    if(!request.getSelectedAccountType().getKey().toLowerCase().contains("foreign") && !isLocalCitizen(nationality)) {
                        return setAndReturnErrorResponse("invalid.acct.selection", "Incorrect document used for onboarding", response);
                    }

                    assert getCustomerResponse.getCustomer() != null;
                    CustomerDocument customerDocument = getCustomerResponse.getCustomer().getDocument();

                    if(!isPassport.get() && customerDocument != null) {
                        assert getCustomerResponse.getCustomer().getDocument() != null;
                        if (getCustomerResponse.getCustomer().getDocument().getMrz() != null &&
                                getCustomerResponse.getCustomer().getDocument().getMrz().getTd3() != null) {
                            if (getCustomerResponse.getCustomer().getDocument().getMrz().getTd3().getDocumentCode().startsWith("P")) {
                                isPassport.set(true);
                            }
                        }
                    }

                    DocumentInspectResponse documentInspectResponse = documentInspectResponseCompletableFuture.get();

                    ValidationContext<DocumentInspectResponse> validationContext =
                            new ValidationContext<>(documentInspectResponse, mrz, isPassport.get(), request);
                    if(documentExpiryValidator.validate(validationContext).getResponse()) {
                        setAndReturnErrorResponse("invalid.doc.expired", "Document is expired", response);
                    }

                    if(!lowOcrConfidenceTextsValidator.validate(validationContext).getResponse()) {
                        return setAndReturnErrorResponse("low.ocr.confidence.text","Low OCR confidence texts", response);
                    }

                    if(isPassport.get()) {
                        if(!mrzValidator.validate(validationContext).getResponse()) {
                            return setAndReturnErrorResponse("mrz.checksum.invalid","MRZ checksum is not valid", response);
                        }
                    }

                    String source = visualZone;

                    if(isPassport.get()){
                        source = mrz;
                    }

                    List<ExtractedData> extractedDataList = List.of(new ExtractedData("dob",DocumentUtils.getDateOfBirthStr(contextHolder, source), "Date of birth"),
                            new ExtractedData("gender",DocumentUtils.getGender(contextHolder, source), "Gender"),
                            new ExtractedData("firstName",DocumentUtils.getFirstName(contextHolder, source), "FirstName"),
                            new ExtractedData("middleName",DocumentUtils.getMiddleNameViz(contextHolder, source), "Middle name"),
                            new ExtractedData("lastName",DocumentUtils.getLastName(contextHolder, source), "Last name"),
                            new ExtractedData("dateOfExpiry",DocumentUtils.getDateOfExpiry(contextHolder, source), "Date of expiry"),
                            new ExtractedData("issuingAuthority",DocumentUtils.getIssuingAuthority(contextHolder, source), "Issuing Authority"),
                            new ExtractedData("edition",DocumentUtils.getEdition(contextHolder), "Edition"),
                            new ExtractedData("nationality",DocumentUtils.getNationality(contextHolder, source), "Nationality"),
                            new ExtractedData("name",DocumentUtils.getName(getCustomerResponse.getCustomer(), isPassport.get()).getFullName(), "Name"));

                    reqInfo.put("name", DocumentUtils.getName(getCustomerResponse.getCustomer(), isPassport.get()).getFullName());
                    response.setUserData(reqInfo);
                    response.setExtractedDataList(extractedDataList);


                    return unused;
                } catch (InterruptedException e) {
                    log.error("Execution is interrupted ", e);
                    throw new ApiExecutionException(e,request);
                } catch (ExecutionException e) {
                    log.error("Execution is failed ", e);
                    throw new ApiExecutionException(e,request);
                }
            });

            //ImageCrop documentPortrait = customerOnboardingApi.documentPortrait(customerId, null, null);
            ImageCrop frontPage = customerOnboardingApi.documentPageCrop(customerId, "front", null, null);

            response.setImage(new String(frontPage.getData()));

            return response;
        }catch (Exception e) {
            log.error("Error while document scan ", e);
        }

        return null;
    }

    public List<SourcesEnum> getSources(){
        return Arrays.asList(SourcesEnum.VIZ, MRZ, DOCUMENT_PORTRAIT);
    }
}
