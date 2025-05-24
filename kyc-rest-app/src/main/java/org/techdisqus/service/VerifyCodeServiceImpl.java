package org.techdisqus.service;

import lombok.extern.slf4j.Slf4j;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.ValidateCodeRequest;
import org.techdisqus.response.ValidateCodeResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class VerifyCodeServiceImpl extends KycBaseService implements ValidateCodeService{

    @Override
    public ValidateCodeResponse verifyOtp(ValidateCodeRequest request, KycRequestHeaders kycRequestHeaders) {
        log.info("otp validation started");
        ValidateCodeResponse  response =  ValidateCodeResponse.builder().build();
        Map<String, String> map = request.getRequestInformation();
        response.setAccountIdentifier(request.getAccountIdentifier());
        response.setUserData(request.getRequestInformation());
        log.info("otp validation ended");
        return response;
    }
}
