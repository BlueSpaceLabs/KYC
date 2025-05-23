package org.techdisqus.service.validators;

import com.innovatrics.dot.integrationsamples.disapi.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.techdisqus.exception.BadRequestException;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.service.utils.DateUtils;
import org.techdisqus.service.utils.DocumentUtils;
import org.techdisqus.util.Result;

import java.util.*;

import static org.techdisqus.service.utils.DocumentUtils.*;

public class DocumentValidators {

    private static final List<ValidationContext<GetCustomerResponse>> customerInfoValidators = new ArrayList<>();
    private static final List<ValidationContext<GetCustomerResponse>> documentInspectValidators = new ArrayList<>();
    private static final List<ValidationContext<GetCustomerResponse>> customerInspectValidators = new ArrayList<>();

    private static final Set<String> isoCountries = Set.of(Locale.getISOCountries());

    @Component
   public static class CustomerDateOfBirthValidator extends BaseValidator implements Validator<ValidationContext<GetCustomerResponse>> {

        @Override
        public Result<Boolean> validate(ValidationContext<GetCustomerResponse> validationContext) {

            if(!isCustomerNull(validationContext.obj()) && validationContext.obj().getCustomer() != null ) {
                String dateOfBirthStr =
                        DocumentUtils.getDateOfBirthStr(new DocumentUtils.ContextHolder(validationContext.obj().getCustomer()),validationContext.source());

                return (StringUtils.isNotEmpty(dateOfBirthStr) ?
                new Result<>(DateUtils.isValidDateFormat(dateOfBirthStr), true) : new Result<>(true, true));
            }

            return new Result<>(null, false);
        }

    }

    @Component
    public static class SupportedDocumentTypeValidator extends BaseValidator implements Validator<ValidationContext<GetCustomerResponse>>{

        @Override
        public Result<Boolean> validate(ValidationContext<GetCustomerResponse> validationContext) {

            if(!isCustomerNull(validationContext.obj()) && validationContext.obj().getCustomer() != null &&
                    validationContext.obj().getCustomer().getDocument() != null) {

                CustomerDocument customerDocument = validationContext.obj().getCustomer().getDocument();
                DocumentType documentType = customerDocument.getType();
                if(documentType != null && StringUtils.isNoneEmpty(documentType.getType())) {
                    if(documentType.getType().equalsIgnoreCase("NOT_SUPPORTED")) {
                        return new Result<>(false,false);
                    }
                }else {
                    return new Result<>(false,false);
                }
            }

            return new Result<>(null, false);
        }
    }

    @Component
    public static class NationalityValidator extends BaseValidator implements Validator<ValidationContext<GetCustomerResponse>>{

        @Override
        public Result<Boolean> validate(ValidationContext<GetCustomerResponse> validationContext) {

            if(!isCustomerNull(validationContext.obj()) && validationContext.obj().getCustomer() != null &&
                    validationContext.obj().getCustomer().getDocument() != null) {

                Customer customer = validationContext.obj().getCustomer();

                String nationality = "";
                ContextHolder contextHolder = new DocumentUtils.ContextHolder(customer);
                nationality = getCountry(contextHolder);
                if(StringUtils.isEmpty(nationality)) {
                    if (validationContext.isPassport()) {
                        DocumentUtils.getNationality(contextHolder, mrz);
                    }
                    if (StringUtils.isEmpty(nationality)) {
                        DocumentUtils.getNationality(contextHolder, visualZone);
                    }
                }

                if(StringUtils.isEmpty(nationality)) {
                    throw new BadRequestException("Cound not get the natioanlity", "Cound not get the natioanlity",
                            "nationality.is.missing", validationContext.request());
                }

                if(nationality.length() == 3 && !isoCountries.contains(nationality)) {
                    throw new BadRequestException("Invalid nationality", "Invalid nationality",
                            "nationality.is.invalid", validationContext.request());
                }

            }

            return new Result<>(null, false);
        }
    }

    @Component
    public static class DocumentExpiryValidator extends BaseValidator implements Validator<ValidationContext<DocumentInspectResponse>>{

        @Override
        public Result<Boolean> validate(ValidationContext<DocumentInspectResponse> validationContext) {

            if(validationContext.obj() != null) {

                DocumentInspectResponse documentInspectResponse = validationContext.obj();
                Boolean isExpired = documentInspectResponse.getExpired();
                if(isExpired != null && isExpired) {
                    return new Result<>(true, true);
                }
            }

            return new Result<>(false, false);
        }
    }

    @Component
    public static class LowOcrConfidenceTextsValidator extends BaseValidator implements Validator<ValidationContext<DocumentInspectResponse>>{

        private static final Set<String> REQUIRED_FIELDS = Set.of("surname", "fullName", "givenNames", "middleName", "dateOfBirth", "dateOfExpiry", "nationality");//"issuingAuthority"

        @Override
        public Result<Boolean> validate(ValidationContext<DocumentInspectResponse> validationContext) {

            if(validationContext.obj() != null) {

                DocumentInspectResponse documentInspectResponse = validationContext.obj();
                List<String> lowOcrConfidenceTexts = documentInspectResponse.getVisualZoneInspection().getOcrConfidence().getLowOcrConfidenceTexts();
                if(validationContext.isPassport){
                    if(lowOcrConfidenceTexts.contains("middleName")){
                        return new Result<>(false, true);
                    }
                }else {
                    if (lowOcrConfidenceTexts.stream().anyMatch(REQUIRED_FIELDS::contains)) {
                        return new Result<>(false, true);
                    }
                }
            }

            return new Result<>(true, true);
        }
    }

    @Component
    public static class MrzValidator extends BaseValidator implements Validator<ValidationContext<DocumentInspectResponse>>{

        @Override
        public Result<Boolean> validate(ValidationContext<DocumentInspectResponse> validationContext) {

            if(validationContext.obj() != null) {

                DocumentInspectResponse documentInspectResponse = validationContext.obj();
                if (documentInspectResponse.getMrzInspection() != null){
                    if (!documentInspectResponse.getMrzInspection().getValid()) {
                        return new Result<>(false, true);
                    }
                }
            }

            return new Result<>(true, true);
        }
    }

    public record ValidationContext<T>(T obj, String source, boolean isPassport, AbstractRequest request) {
    }
}
