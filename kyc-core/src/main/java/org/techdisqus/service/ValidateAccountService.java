package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.ValidateAccountResponse;

public interface ValidateAccountService  {

    ValidateAccountResponse verify(ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders);

    ValidateAccountResponse resendOtp(ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders);
}
