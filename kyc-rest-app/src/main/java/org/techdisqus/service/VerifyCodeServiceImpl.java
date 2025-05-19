package org.techdisqus.service;

import org.techdisqus.request.ValidateCodeRequest;
import org.techdisqus.response.ValidateCodeResponse;
import org.springframework.stereotype.Component;

@Component
public class VerifyCodeServiceImpl extends KycBaseService implements ValidateCodeService{

    @Override
    public ValidateCodeResponse verifyOtp(ValidateCodeRequest request) {
        ValidateCodeResponse  response =  ValidateCodeResponse.builder().build();
        response.setRequestId(request.getRequestId());
        
        return response;
    }
}
