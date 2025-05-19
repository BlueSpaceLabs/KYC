package org.techdisqus.service;

import org.techdisqus.request.ValidateCodeRequest;
import org.techdisqus.response.ValidateCodeResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VerifyCodeServiceImpl extends KycBaseService implements ValidateCodeService{

    @Override
    public ValidateCodeResponse verifyOtp(ValidateCodeRequest request) {
        ValidateCodeResponse  response =  ValidateCodeResponse.builder().build();
        Map<String, String> map = request.getRequestInformation();
        response.setRequestId(map.get("requestId"));
        response.setSpanId(getRequestId());
        response.setAccountIdentifier(request.getAccountIdentifier());
        response.setUserData(request.getRequestInformation());

        return response;
    }
}
