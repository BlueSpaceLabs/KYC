package org.techdisqus.service;


import lombok.extern.slf4j.Slf4j;

import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.ValidateAccountResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class VerifyAccountServiceImpl extends KycBaseService implements ValidateAccountService{

    @Override
    public ValidateAccountResponse verify(ValidateAccountRequest request) {

        log.info("account validation started");
        ValidateAccountResponse response = ValidateAccountResponse.builder().build();
        response.setAccountIdentifier(request.getAccountIdentifier());
        Map<String, String> reqInfo = new HashMap<>();
        reqInfo.put("msisdn", request.getAccountIdentifier());
        response.setUserData(reqInfo);
        log.info("account validation ended");
        return response;
    }
}
