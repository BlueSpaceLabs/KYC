package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.ResendOtpRequest;
import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.ResendOtpResponse;
import org.techdisqus.response.ValidateAccountResponse;

public interface ValidateAccountService  {

    ValidateAccountResponse verify(ValidateAccountRequest request, KycRequestHeaders kycRequestHeaders);

    ResendOtpResponse resendOtp(ResendOtpRequest request, KycRequestHeaders kycRequestHeaders);
}
