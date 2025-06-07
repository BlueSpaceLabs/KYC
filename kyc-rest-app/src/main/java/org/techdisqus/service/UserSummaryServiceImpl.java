package org.techdisqus.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UserSummaryRequest;
import org.techdisqus.response.UserSummaryResponse;
import org.techdisqus.service.utils.UserDetailsUtil;

import java.util.*;

@Component
@Slf4j
public class UserSummaryServiceImpl extends KycBaseService implements UserSummaryService {

    @Autowired
    private UserDetailsUtil userDetailsUtil;

    @SneakyThrows
    @Override
    public UserSummaryResponse getSummary(UserSummaryRequest request, KycRequestHeaders kycRequestHeaders) {

        log.info("getting summary");

        Map<String, String> map = request.getRequestInformation();

        UserSummaryResponse userSummaryResponse = UserSummaryResponse
                .builder()
                .userData(request.getRequestInformationString())
                .documents(userDetailsUtil.getAdditionalDocuments(map))
                .accountIdentifier(map.get("msisdn"))
                .userOnboardingDetails(userDetailsUtil.getUserOnboardingDetails(map))
                .images(userDetailsUtil.getIdAndSelfie(map))
                .build();


        log.info("getting summary completed");

        return userSummaryResponse;
    }
}
