package org.techdisqus.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.request.EditRequest;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.response.EditResponse;
import org.techdisqus.service.utils.UserDetailsUtil;

import java.util.*;

@Component
@Slf4j
public class EditServiceImpl extends KycBaseService implements EditService {

    @Autowired
    private UserDetailsUtil userDetailsUtil;

    @SneakyThrows
    @Override
    public EditResponse edit(EditRequest request, KycRequestHeaders kycRequestHeaders) {
        log.info("getting edit");

        Map<String, String> map = request.getRequestInformation();

        EditResponse editResponse = EditResponse
                .builder()
                .userData(request.getRequestInformationString())
                .documents(userDetailsUtil.getAdditionalDocuments(map))
                .accountIdentifier(map.get("msisdn"))
                .userOnboardingDetails(userDetailsUtil.getUserOnboardingDetails(map))
                .images(userDetailsUtil.getIdAndSelfie(map))
                .build();


        log.info("getting summary completed");

        return editResponse;
    }
}
