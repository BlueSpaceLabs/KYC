package org.techdisqus.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import com.innovatrics.dot.integrationsamples.disapi.model.GetCustomerResponse;
import com.innovatrics.dot.integrationsamples.disapi.model.ImageCrop;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UserSummaryRequest;
import org.techdisqus.response.ExtractedData;
import org.techdisqus.response.UploadDocumentsResponse;
import org.techdisqus.response.UserOnboardingDetails;
import org.techdisqus.response.UserSummaryResponse;
import org.techdisqus.service.utils.DocumentUtils;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class UserSummaryServiceImpl extends KycBaseService implements UserSummaryService {
    @SneakyThrows
    @Override
    public UserSummaryResponse getSummary(UserSummaryRequest request, KycRequestHeaders kycRequestHeaders) {

        log.info("getting summary");
        Map<String, String> map = request.getRequestInformation();
        String userDetails = map.get("userDetails");
        UserDetailsServiceImpl.UserDetailsHolder userDetailsHolder = new ObjectMapper().readValue(userDetails, UserDetailsServiceImpl.UserDetailsHolder.class);

        UserSummaryResponse userSummaryResponse = UserSummaryResponse.builder().build();
        UserOnboardingDetails userOnboardingDetails = UserOnboardingDetails.builder().
                dateOfBirth(userDetailsHolder.getDateOfBirth()).
                addresses(userDetailsHolder.getAddresses()).
                gender(userDetailsHolder.getGender()).
                firstName(userDetailsHolder.getFirstName()).
                middleName(userDetailsHolder.getMiddleName()).
                lastName(userDetailsHolder.getLastName()).build();

        userSummaryResponse.setUserOnboardingDetails(userOnboardingDetails);

        String source = DocumentUtils.visualZone;
        userSummaryResponse.setUserData(map);

        boolean isPassport = false;
        if (map.getOrDefault("isPassport", "false").equalsIgnoreCase("true")) {
            source = DocumentUtils.mrz;
            isPassport = true;
        }

        GetCustomerResponse getCustomerResponse = null;
        String customerId = map.get("customerId");
        try {
            getCustomerResponse = customerOnboardingApi.getCustomer(customerId);
        } catch (ApiException e) {
            log.error("Error while getting the customer ", e);
            userSummaryResponse.setErrorDetails(e.getCode() + "");
            userSummaryResponse.setErrorCode("SUMMARY-001");
            return userSummaryResponse;
        }
        DocumentUtils.ContextHolder contextHolder = new DocumentUtils.ContextHolder(getCustomerResponse.getCustomer());
        try {
            ImageCrop frontPage = customerOnboardingApi.documentPageCrop(customerId, "front", null, null);

            List<ExtractedData> extractedDataList = List.of(new ExtractedData("dob", DocumentUtils.getDateOfBirthStr(contextHolder, source), "Date of birth"),
                    new ExtractedData("gender", DocumentUtils.getGender(contextHolder, source), "Gender"),
                    new ExtractedData("firstName", DocumentUtils.getFirstName(contextHolder, source), "FirstName"),
                    new ExtractedData("middleName", DocumentUtils.getMiddleNameViz(contextHolder, source), "Middle name"),
                    new ExtractedData("lastName", DocumentUtils.getLastName(contextHolder, source), "Last name"),
                    new ExtractedData("dateOfExpiry", DocumentUtils.getDateOfExpiry(contextHolder, source), "Date of expiry"),
                    new ExtractedData("issuingAuthority", DocumentUtils.getIssuingAuthority(contextHolder, source), "Issuing Authority"),
                    new ExtractedData("edition", DocumentUtils.getEdition(contextHolder), "Edition"),
                    new ExtractedData("nationality", DocumentUtils.getNationality(contextHolder, source), "Nationality"),
                    new ExtractedData("name", DocumentUtils.getName(getCustomerResponse.getCustomer(), isPassport).getFullName(), "Name"));

            userSummaryResponse.setDocumentExtractedDataList(extractedDataList);
            userSummaryResponse.setImages(new HashMap<>(1));
            userSummaryResponse.getImages().put("document", Base64.getEncoder().encodeToString(frontPage.getData()));
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }

        log.info("getting summary completed");

        return userSummaryResponse;
    }
}
