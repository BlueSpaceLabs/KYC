package org.techdisqus.service.utils;

import com.innovatrics.dot.integrationsamples.disapi.model.BiometricMultiValueAttribute;
import com.innovatrics.dot.integrationsamples.disapi.model.Customer;
import com.innovatrics.dot.integrationsamples.disapi.model.CustomerDocument;
import com.innovatrics.dot.integrationsamples.disapi.model.MultiValueAttribute;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Slf4j
public class DocumentUtils {

    public static final String DATE_OF_BIRTH = "dateOfBirth";
    public static final String DOC_NO = "documentNumber";

    public static final String DATE_OF_ISSUE = "dateOfIssue";
    public static final String PLACE_OF_ISSUE = "placeOfIssue";
    public static final String DATE_OF_EXPIRY = "dateOfExpiry";
    public static final String GENDER = "gender";
    public static final String DOCUMENT_CODE = "documentCode";
    public static final String DOCUMENT_TYPE = "documentType";
    public static final String NATIONALITY = "nationality";
    public static final String GIVEN_NAMES = "givenNames";
    public static final String ISSUING_AUTHORITY = "issuingAuthority";
    public static final String SECOND_LINE = "secondLine";
    public static final String FIRST_LINE = "firstLine";
    public static final String SURNAME = "surname";
    public static final String LABEL_NATIONALITY = "label.nationality";
    public static final String LABEL_DOB = "label.dateOfBirth";
    public static final String LABEL_GENDER= "label.gender";
    public static final String LABEL_ISSUING_AUTHORITY = "label.issuingAuthority";
    public static final String LABEL_DOC_NO = "label.docNo";
    public static final String LABEL_DATE_OF_EXPIRY ="label.dateOfExpiry";
    public static final String LABEL_DOC_CODE = "label.documentCode";
    public static final String LABEL_SURNAME = "label.surname";
    public static final String LABEL_GIVEN_NAMES = "label.givenNames";
    public static final String LABEL_DATE_OF_BIRTH = "label.dateOfBirth";
    public static final String LABEL_FIRST_LINE = "label.firstLine";
    public static final String LABEL_SECOND_LINE = "label.secondLine";

    public static final String LABEL_DATE_OF_ISSUE = "label.dateOfIssue";
    public static final String VISUAL_ZONE = "visualZone";
    public static final String FULL_NAME = "fullName";
    public static final String AGE = "age";

    public static final String visualZone = "visualZone";
    public static final String mrz = "mrz";
    public static final String fullNameViz = "fullNameViz";
    public static final String fullNameMrz = "fullNameMrz";
    public static final String givenNameViz = "givenNameViz";
    public static final String givenNameMrz = "givenNameMrz";
    public static final String lastNameViz = "lastNameViz";
    public static final String lastNameMrz = "lastNameMrz";
    public static final String middleNameViz = "middleNameViz";


    public static final String NATIONALITY_PHL = "PHL";

    public static final String NATIONALITY_FILIPINO = "FILIPINO";


    public static String getDateOfBirthStr(ContextHolder contextHolder, String source) {
        Customer customer = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getDateOfBirth(), mrz);
        }
        return extractData(customer.getDateOfBirth(), visualZone);
    }

    public static String getFullName(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();
        if (source.equals(mrz)) {
            return extractData(customer.getFullName(), mrz);
        }
        return extractData(customer.getFullName(), visualZone);
    }

    public static String getFirstName(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getGivenNames(), mrz);
        }
        return extractData(customer.getGivenNames(), visualZone);

    }


    public static String getMiddleNameViz(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if(customer.getDocument() != null && customer.getDocument().getAdditionalTexts() != null &&
                customer.getDocument().getAdditionalTexts().get("middleName") != null) {
            return customer.getDocument().getAdditionalTexts().get("middleName").getVisualZone();
        }

        return "";
    }


    public static String getLastName(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getSurname(), mrz);
        }
        return extractData(customer.getSurname(), visualZone);
    }

    public static String getGender(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getGender(), mrz);
        }

        return extractData(customer.getGender(), visualZone);
    }

    public static String getCitizenship(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getCitizenship(), mrz);
        }
        return extractData(customer.getCitizenship(), visualZone);
    }

    public static String getNationality(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getNationality(), mrz);
        }
        return extractData(customer.getNationality(), visualZone);
    }

    public static String getPersonalNumber(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if (source.equals(mrz)) {
            return extractData(customer.getPersonalNumber(), mrz);
        }
        return extractData(customer.getPersonalNumber(), visualZone);
    }

    public static String getDocumentNumber(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if(customer.getDocument() != null) {
            if (source.equals(mrz)) {
                return extractData(customer.getDocument().getDocumentNumber(), mrz);
            }
            return extractData(customer.getDocument().getDocumentNumber(), visualZone);
        }

        return "";
    }

    public static String getDateOfExpiry(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if(customer.getDocument() != null) {
            if (source.equals(mrz)) {
                return extractData(customer.getDocument().getDateOfExpiry(), mrz);
            }
            return extractData(customer.getDocument().getDateOfExpiry(), visualZone);
        }

        return "";
    }

    public static String getEdition(ContextHolder contextHolder) {
        assert contextHolder.customer().getDocument() != null;
        assert contextHolder.customer().getDocument().getType() != null;
        return contextHolder.customer().getDocument().getType().getEdition();
    }

    public static String getCountry(ContextHolder contextHolder) {
        assert contextHolder.customer().getDocument() != null;
        assert contextHolder.customer().getDocument().getType() != null;
        return contextHolder.customer().getDocument().getType().getCountry();
    }
    public static String getIssuingAuthority(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if(customer.getDocument() != null) {
            if (source.equals(mrz)) {
                return extractData(customer.getDocument().getIssuingAuthority(), mrz);
            }
            return extractData(customer.getDocument().getIssuingAuthority(), visualZone);
        }

        return "";
    }

    public static String getAge(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();


        if(customer.getAge() != null) {
            if (source.equals(visualZone)) {
                return customer.getAge().getVisualZone();
            }else {
                return customer.getAge().getMrz();
            }
        }

        return "";
    }

    public static String getDateOfIssue(ContextHolder contextHolder, String source) {
        Customer customer  = contextHolder.customer();

        if(customer.getDocument() != null) {
            if (source.equals(mrz)) {
                return extractData(customer.getDocument().getDateOfIssue(), mrz);
            }
            return extractData(customer.getDocument().getDateOfIssue(), visualZone);
        }

        return "";
    }



    public static String extractData(MultiValueAttribute multiValueAttribute, String source){

        if(multiValueAttribute != null) {
            if (source.equals(mrz)) {
                return multiValueAttribute.getMrz();
            }
            return multiValueAttribute.getVisualZone();
        }
        return "";
    }

    public static String extractData(BiometricMultiValueAttribute multiValueAttribute, String source){

        if (source.equals(mrz)) {
            return multiValueAttribute.getMrz();
        }
        return multiValueAttribute.getVisualZone();
    }

    public static String getDocumentCode(CustomerDocument customerDocument){

        assert customerDocument.getType() != null;
        String machineReadableTravelDocumentType = customerDocument.getType().getMachineReadableTravelDocument();
        Object obj = null;

        assert customerDocument.getMrz() != null;
        if("td1".equalsIgnoreCase(machineReadableTravelDocumentType)) {
            obj = customerDocument.getMrz().getTd1();
        } else if ("td2".equalsIgnoreCase(machineReadableTravelDocumentType)) {
            obj = customerDocument.getMrz().getTd2();
        }else if("td3".equalsIgnoreCase(machineReadableTravelDocumentType)) {
            obj = customerDocument.getMrz().getTd3();
        }

        if(obj != null) {
            try {
                Object returnVal = ReflectionUtils.invokeMethod(obj.getClass().getMethod("getDocumentCode"), obj);
                return returnVal != null ? returnVal.toString() : "";
            } catch (NoSuchMethodException e) {
                log.error("Error while getting the document code ", e);
            }
        }

        return "";
    }

    public record ContextHolder(Customer customer) {

    }

    public static Name getName(Customer customer, boolean isMrzChecksumValid) {

        String lastName = "";
        String middleName = "";
        String firstName = "";

        boolean isPhilipinesCitizen = false;

        if(customer.getNationality() != null){
            if(isMrzChecksumValid && customer.getNationality().getMrz() != null
                    && isNotEmpty(customer.getNationality().getMrz()) && (customer.getNationality().getMrz().equals(NATIONALITY_PHL) || customer.getNationality().getMrz().equals(NATIONALITY_FILIPINO))){
                isPhilipinesCitizen = true;
            }else if(customer.getNationality().getVisualZone() != null
                    && isNotEmpty(customer.getNationality().getVisualZone()) && (customer.getNationality().getVisualZone().equals(NATIONALITY_PHL) || customer.getNationality().getVisualZone().equals(NATIONALITY_FILIPINO))){
                isPhilipinesCitizen = true;
            }
        }

        //Added specifically for BIR ID as customer.getNationality() is null and hence checking the type and edition
        if(!isPhilipinesCitizen) {
            assert customer.getDocument() != null;
            if (customer.getDocument().getType() != null
                    && "identity-card".equalsIgnoreCase(customer.getDocument().getType().getType()) &&
                    "1991-01-01".equals(customer.getDocument().getType().getEdition())) {
                isPhilipinesCitizen = NATIONALITY_PHL.equals(customer.getDocument().getType().getCountry()) ||
                        NATIONALITY_FILIPINO.equals(customer.getDocument().getType().getCountry());
            }
        }

        if(isPhilipinesCitizen){
            assert customer.getDocument() != null;
            if(customer.getDocument().getType() != null
                    && ("drivers-licence".equalsIgnoreCase(customer.getDocument().getType().getType())
                    || ("identity-card".equalsIgnoreCase(customer.getDocument().getType().getType()) &&
                    "1991-01-01".equals(customer.getDocument().getType().getEdition())))){
                assert customer.getFullName() != null;
                String fullName = customer.getFullName().getVisualZone();
                //Last Name, First Name Middle Name
                //,JUMIO, MARIE for non professional DL
                //CEDILLA, MIGUEL EDOUARDO AUSTRIACO

                //CEDILLA MIGUEL EDOUARDO AUSTRIACO
                //fname: CEDILLA
                //middle name: MIGUEL
                //last name: EDOUARDO AUSTRIACO

                assert fullName != null;
                String[] tokens = fullName.split(",");
                if(tokens.length > 0 ){
                    List<String> names = Arrays.stream(tokens).filter(StringUtils::isNotEmpty).toList();
                    lastName = names.get(0);
                    if(names.size() == 3){
                        middleName = names.get(2);
                        firstName = names.get(1);
                    } else if(names.size() == 2) {
                        if(names.get(1).contains(" ")){
                            String[] remainingNames = names.get(1).split(" ");
                            if(remainingNames.length == 1){
                                firstName = remainingNames[0];
                            }else{
                                middleName = remainingNames[remainingNames.length - 1];
                                StringBuilder sb = new StringBuilder();
                                for(int i = 0 ; i < remainingNames.length - 1; i++){
                                    sb.append(remainingNames[i]).append(" ");
                                }
                                firstName = sb.toString().trim();
                            }
                        }else{
                            firstName = names.get(1);
                        }
                    }
                }
            }else if(customer.getDocument().getType() != null &&
                    ("identity-card".equalsIgnoreCase(customer.getDocument().getType().getType()) ||
                            "profession-card".equalsIgnoreCase(customer.getDocument().getType().getType()))){

                CustomerDocument document = customer.getDocument();

                if(document.getAdditionalTexts() != null){
                    middleName = getAdditionalPropertyVal(document, "middleName");
                }

                firstName = customer.getGivenNames() != null ?  customer.getGivenNames().getVisualZone() : "";
                lastName = customer.getSurname() != null ? customer.getSurname().getVisualZone() : "";

            }else {
                CustomerDocument document = customer.getDocument();
                if(document.getMrz() != null &&  document.getMrz().getTd3() != null && isNotEmpty(document.getMrz().getTd3().getDocumentCode()) ){
                    //for passport
                    assert document.getType() != null;
                    String machineReadableTravelDocumentType = document.getType().getMachineReadableTravelDocument();
                    String documentCode = document.getMrz().getTd3().getDocumentCode();

                    if(isMrzChecksumValid) {
                        if ("td3".equals(machineReadableTravelDocumentType) && documentCode.startsWith("P")) {
                            assert customer.getDocument().getMrz() != null;
                            assert customer.getDocument().getMrz().getTd3() != null;
                            firstName = customer.getDocument().getMrz().getTd3().getGivenNames();

                            if (document.getAdditionalTexts() != null ) {
                                middleName = getAdditionalPropertyVal(document, "middleName");
                            }

                            lastName = customer.getDocument().getMrz().getTd3().getSurname();

                        }
                    }else{
                        assert customer.getGivenNames() != null;
                        if(isNotEmpty(customer.getGivenNames().getVisualZone())) {
                            firstName = customer.getGivenNames().getVisualZone();
                        }

                        if (document.getAdditionalTexts() != null ) {
                            middleName = getAdditionalPropertyVal(document, "middleName");
                        }

                        assert customer.getSurname() != null;
                        if(isNotEmpty(customer.getSurname().getVisualZone())) {
                            lastName = customer.getSurname().getVisualZone();
                        }

                    }
                }else {
                    return populateNameWithDefaults(customer, isMrzChecksumValid);
                }
            }
        }else{
            //this is for non PHL citizens
            return populateNameWithDefaults(customer, isMrzChecksumValid);
        }

        return new Name(firstName, middleName, lastName);

    }

    private static Name populateNameWithDefaults(Customer customer, boolean isMrzChecksumValid){
        String lastName = "";
        String middleName = "";
        String firstName = "";
        String fullName;

        if(customer.getGivenNames() != null){

            CustomerDocument document = customer.getDocument();

            if(customer.getGivenNames() != null){
                if(isMrzChecksumValid && isNotEmpty(customer.getGivenNames().getMrz())){
                    firstName = customer.getGivenNames().getMrz();
                } else if (isNotEmpty(customer.getGivenNames().getVisualZone())) {
                    firstName = customer.getGivenNames().getVisualZone();
                }
            }

            assert document != null;
            if(document.getAdditionalTexts() != null ){
                middleName = getAdditionalPropertyVal(document, "middleName");
            }

            if(customer.getSurname() != null){
                if(isMrzChecksumValid && isNotEmpty(customer.getSurname().getMrz())){
                    lastName = customer.getSurname().getMrz();
                } else if (isNotEmpty(customer.getSurname().getVisualZone())) {
                    lastName = customer.getSurname().getVisualZone();
                }
            }
        }else if (customer.getFullName() != null) {

            if(isMrzChecksumValid && isNotEmpty(customer.getFullName().getMrz())) {
                fullName = customer.getFullName().getMrz();
            }else {
                fullName = isNotEmpty(customer.getFullName().getVisualZone()) ? customer.getFullName().getVisualZone() : "";
            }

            String[] tokens = fullName.split(" ");
            if (tokens.length > 0) {
                List<String> names = Arrays.stream(tokens).filter(StringUtils::isNotEmpty).toList();
                firstName = names.get(0);
                if (names.size() == 3) {
                    middleName = names.get(1);
                    lastName = names.get(2);
                } else if (names.size() == 2) {
                    lastName = names.get(1);
                } else if (names.size() > 3) {
                    middleName = names.get(1);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 2; i < names.size(); i++) {
                        sb.append(names.get(i)).append(" ");
                    }

                    lastName = sb.toString().trim();
                }
            }
        }else {
            CustomerDocument document = customer.getDocument();

            if(document != null && document.getMrz() != null && document.getMrz().getTd3() != null) {
                firstName = isNotEmpty(document.getMrz().getTd3().getGivenNames()) ? document.getMrz().getTd3().getGivenNames() : "";
                lastName = isNotEmpty(document.getMrz().getTd3().getSurname()) ? document.getMrz().getTd3().getSurname() : "";
            }
        }

        return new Name(firstName, middleName, lastName);
    }

    private static String getAdditionalPropertyVal(CustomerDocument document, String key){

        String val = "";

        if(document.getAdditionalTexts() != null && document.getAdditionalTexts().containsKey(key)) {
            val = document.getAdditionalTexts().get(key).getVisualZone();
        }

        return val;
    }



    public record Name(String firstName, String middleName, String lastName) {
        public String getFullName() {
            StringBuilder sb = new StringBuilder();

            if (StringUtils.isNotEmpty(firstName)) {
                sb.append(firstName);
            }

            if (StringUtils.isNotEmpty(middleName)) {
                sb.append(middleName);
            }

            if (StringUtils.isNotEmpty(lastName)) {
                sb.append(lastName);
            }

            return sb.toString();
        }
    }
}
