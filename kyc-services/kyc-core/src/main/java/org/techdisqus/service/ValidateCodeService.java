package org.techdisqus.service;

import org.techdisqus.request.ValidateCodeRequest;
import org.techdisqus.response.ValidateCodeResponse;

public interface ValidateCodeService {

    ValidateCodeResponse verifyOtp(ValidateCodeRequest request);
}
