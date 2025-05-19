package org.techdisqus.service;


import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.ValidateAccountResponse;
import org.springframework.stereotype.Component;

@Component
public class VerifyAccountServiceImpl extends KycBaseService implements ValidateAccountService{
    @Override
    public ValidateAccountResponse verify(ValidateAccountRequest request) {

        ValidateAccountResponse response = ValidateAccountResponse.builder().build();
        response.setRequestId(getRequestId());

        return response;
    }
}
