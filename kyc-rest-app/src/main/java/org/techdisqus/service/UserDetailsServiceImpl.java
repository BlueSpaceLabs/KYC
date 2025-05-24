package org.techdisqus.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UserDetailsRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.response.UserDetailsResponse;
import org.springframework.stereotype.Component;
import org.techdisqus.service.utils.DateUtils;
import org.techdisqus.service.utils.DistributedULIDGenerator;
import org.techdisqus.service.utils.DocumentUtils;
import org.techdisqus.service.utils.Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserDetailsServiceImpl extends KycBaseService implements UserDetailsService {

    @Autowired
    private Utils utils;

    @Override
    public UserDetailsResponse submitPersonalDetails(UserDetailsRequest request, KycRequestHeaders kycRequestHeaders) {

        log.info("user details submit started");
        UserDetailsResponse userDetailsResponse = UserDetailsResponse.builder().build();

        if(!validateDateOfBirthFormat(request, userDetailsResponse)) {
            return userDetailsResponse;
        }

        if(!validateGender(request, userDetailsResponse)) {
            return userDetailsResponse;
        }

        if(!isAgeValid(request, userDetailsResponse)) {
            return userDetailsResponse;
        }

        Map<String, String> reqInfo = request.getRequestInformation();

        if(!utils.doFuzzyMatch(new DocumentUtils.Name(request.getFirstName(), request.getMiddleName(), request.getLastName()).getFullName(),
                reqInfo.get("name"),reqInfo)){
            userDetailsResponse.setErrorDetails("Incorrect name");
            userDetailsResponse.setErrorCode("PERSONAL-001");
        }
        reqInfo.put("externalId", DistributedULIDGenerator.generateULID());
        userDetailsResponse.setUserData(reqInfo);

        log.info("user details submit ended");

        return userDetailsResponse;
    }

    protected String getFullNameFromDerivedValues(List<ExtractedData> values) {
        Map<String, String> keyValMap = getUpdatedValues(values);
        return keyValMap.get("fullName");
    }

    private boolean validateDateOfBirthFormat(UserDetailsRequest request, UserDetailsResponse response){
        String dateOfBirth = request.getDateOfBirth();

        if("".equals(dateOfBirth)){
            response.setErrorCode("USER-002");
            response.setErrorDetails("Incorrect date of birth");
            log.info("date of birth is null");

            return false;
        }

        if(!DateUtils.isValidDateFormat(dateOfBirth)){
            response.setErrorCode("USER-003");
            response.setErrorDetails("Incorrect date of birth");
            log.info("date of birth is is not valid {}", dateOfBirth);

            return false;
        }

        return true;
    }

    private boolean validateGender(UserDetailsRequest request, UserDetailsResponse response){


        String gender = request.getGender();

        String message = messageProvider.getMessage("error.gender.missing.value", request.getLocale());

        if("".equals(gender)){
            response.setErrorCode("USER-003");
            response.setErrorDetails("Incorrect gender");
            log.info("Gender is null");
            return false;
        }

        if(!"M".equals(gender) && !"F".equals(gender)){
            response.setErrorCode("USER-004");
            response.setErrorDetails("Incorrect gender");
            log.info("Gender is not valid {} ", gender);

            return false;
        }

        return true;
    }

    private boolean isAgeValid(UserDetailsRequest request, UserDetailsResponse response){

        String dateOfBirthStr = request.getDateOfBirth();

        boolean isAgeValid = true;

        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int diffYears = Period.between(dateOfBirth, ZonedDateTime.now(ZoneId.of("Asia/Manila")).toLocalDate()).getYears();
        log.info("Age diff is  {} ", diffYears);
        if (diffYears < 18 ) {
            String message = messageProvider.getMessage("error.age.invalid", request.getLocale());
            response.setErrorCode("USER-005");
            response.setErrorDetails(message);
            isAgeValid = false;
            //Token is refreshed at the place where this method is used
        }

        if (diffYears > 120) {
            String message = messageProvider.getMessage("error.age.invalid.above.120", request.getLocale());
            response.setErrorCode("USER-006");
            response.setErrorDetails(message);
            isAgeValid = false;
            //Token is refreshed at the place where this method is used
        }

        return isAgeValid;
    }

    private static Map<String, String> getUpdatedValues(List<ExtractedData> request) {
        return request
                .stream()
                .filter(derivedValue -> derivedValue.getValue() != null)
                .collect(Collectors.toMap(ExtractedData::getKey, ExtractedData::getValue));
    }


}
