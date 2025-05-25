package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;

import org.techdisqus.request.UserSummaryRequest;
import org.techdisqus.response.UserSummaryResponse;

public interface UserSummaryService {

    UserSummaryResponse getSummary(UserSummaryRequest request, KycRequestHeaders kycRequestHeaders);
}
