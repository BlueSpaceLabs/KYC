package org.techdisqus.service;


import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.ValidateAccountResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VerifyAccountServiceImpl extends KycBaseService implements ValidateAccountService{
    @Override
    public ValidateAccountResponse verify(ValidateAccountRequest request) {

        ValidateAccountResponse response = ValidateAccountResponse.builder().build();
        response.setRequestId(getRequestId());
        response.setSpanId(getRequestId());
        response.setAccountIdentifier(request.getAccountIdentifier());
        Map<String, String> reqInfo = new HashMap<>();
        reqInfo.put("msisdn", request.getAccountIdentifier());
        reqInfo.put("requestId", response.getRequestId());
        response.setUserData(reqInfo);

        return response;
    }
}
