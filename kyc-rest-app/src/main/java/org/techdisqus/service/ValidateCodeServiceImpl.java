package org.techdisqus.service;

import lombok.extern.slf4j.Slf4j;
import org.techdisqus.service.utils.OtpUtil;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.ValidateCodeRequest;
import org.techdisqus.response.ValidateCodeResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ValidateCodeServiceImpl extends KycBaseService implements ValidateCodeService{


    @Override
    public ValidateCodeResponse verifyOtp(ValidateCodeRequest request, KycRequestHeaders kycRequestHeaders) {
        log.info("otp validation started");
        ValidateCodeResponse  response =  ValidateCodeResponse.builder().build();
        Map<String, String> map = request.getRequestInformation();
        response.setAccountIdentifier(map.get("msisdn"));
        response.setUserData(map);
        String otp = request.getOtp();
        String message = OtpUtil.validateOtp(map.get("msisdn"), otp);

        if("OTP is valid.".equals(message)) {
            return response;
        }

        if("Invalid OTP.".equals(message)) {
            response.setErrorCode("OTP-001");
            response.setErrorDetails(message);
            return response;
        }

        if("Maximum validation attempts exceeded.".equals(message)) {
            response.setErrorCode("OTP-002");
            response.setErrorDetails(message);
            return response;
        }

        if("OTP expired or not found.".equals(message)) {
            response.setErrorCode("OTP-003");
            response.setErrorDetails(message);
            return response;
        }




        log.info("otp validation ended");
        return response;
    }





}
