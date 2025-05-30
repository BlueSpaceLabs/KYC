package org.techdisqus.service;

import org.techdisqus.request.EditRequest;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.response.EditResponse;

public interface EditService {

    EditResponse edit(EditRequest request, KycRequestHeaders kycRequestHeaders);
}
