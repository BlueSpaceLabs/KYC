package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UserDetailsRequest;
import org.techdisqus.response.UserDetailsResponse;

public interface UserDetailsService {

    UserDetailsResponse submitPersonalDetails(UserDetailsRequest request, KycRequestHeaders kycRequestHeaders);
}
