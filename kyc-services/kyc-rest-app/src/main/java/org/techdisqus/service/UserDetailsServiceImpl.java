package org.techdisqus.service;


import org.techdisqus.request.UserDetailsRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.response.UserDetailsResponse;
import org.springframework.stereotype.Component;
import org.techdisqus.service.utils.DateUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl extends KycBaseService implements UserDetailsService {

    @Override
    public UserDetailsResponse submitPersonalDetails(UserDetailsRequest request) {

        UserDetailsResponse userDetailsResponse = UserDetailsResponse.builder().build();

        return userDetailsResponse;
    }

    protected String getFullNameFromDerivedValues(List<ExtractedData> values) {
        Map<String, String> keyValMap = getUpdatedValues(values);
        return keyValMap.get("fullName");
    }

    private boolean validateDateOfBirthFormat(UserDetailsRequest request, UserDetailsResponse response){
        String dateOfBirth = request.getDateOfBirth();

        if("".equals(dateOfBirth)){
            return false;
        }

        if(!DateUtils.isValidDateFormat(dateOfBirth)){


            
            return false;
        }

        return true;
    }

    private boolean validateGender(UserDetailsRequest request, UserDetailsResponse response){


        String gender = request.getGender();

        String message = messageProvider.getMessage("error.gender.missing.value", request.getLocale());

        if("".equals(gender)){

            return false;
        }

        if(!"M".equals(gender) && !"F".equals(gender)){
            return false;
        }

        return true;
    }

    private boolean isAgeValid(UserDetailsRequest request, UserDetailsResponse response){

        String dateOfBirthStr = request.getDateOfBirth();

        boolean isAgeValid = true;

        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int diffYears = Period.between(dateOfBirth, ZonedDateTime.now(ZoneId.of("Asia/Manila")).toLocalDate()).getYears();
        
        if (diffYears < 18 ) {
            String message = messageProvider.getMessage("error.age.invalid", request.getLocale());

            isAgeValid = false;
            //Token is refreshed at the place where this method is used
        }

        if (diffYears > 120) {
            String message = messageProvider.getMessage("error.age.invalid.above.120", request.getLocale());
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
