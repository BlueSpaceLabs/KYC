package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.RegisterUserRequest;
import org.techdisqus.response.RegisterUserResponse;

public interface RegisterUserService {

    RegisterUserResponse register(RegisterUserRequest request, KycRequestHeaders kycRequestHeaders);
}
