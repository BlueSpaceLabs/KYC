package org.techdisqus.service;


import lombok.extern.slf4j.Slf4j;

import org.techdisqus.OtpUtil;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.ValidateAccountResponse;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ValidateAccountServiceImpl extends KycBaseService implements ValidateAccountService{

    private static final SecureRandom random = new SecureRandom();

    @Override
    public ValidateAccountResponse verify(ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders) {

        log.info("account validation started");
        ValidateAccountResponse response = ValidateAccountResponse.builder().build();
        response.setAccountIdentifier(request.getAccountIdentifier());
        String otp = OtpUtil.generateOtp(request.getAccountIdentifier(), 6);
        Map<String, String> reqInfo = new HashMap<>();
        reqInfo.put("msisdn", request.getAccountIdentifier());
        reqInfo.put("otp", otp);
        response.setUserData(reqInfo);
        response.setMessage("message is " + otp);
        log.info("account validation ended");

        return response;
    }

    @Override
    public ValidateAccountResponse resendOtp(ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders) {
        log.info("resend otp started");
        ValidateAccountResponse response = ValidateAccountResponse.builder().build();
        response.setAccountIdentifier(request.getAccountIdentifier());
        String otp = OtpUtil.generateOtp(request.getAccountIdentifier(), 6);
        Map<String, String> reqInfo = new HashMap<>();
        reqInfo.put("msisdn", request.getAccountIdentifier());
        reqInfo.put("otp", otp);
        response.setUserData(reqInfo);
        response.setMessage("OTP is " + otp);
        log.info("resend otp ended");

        return response;
    }


}
