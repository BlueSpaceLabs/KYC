package org.techdisqus.service;

import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.request.UploadDocumentsRequest;
import org.techdisqus.response.UploadDocumentsResponse;

public interface UserAdditionalDocumentService {

    UploadDocumentsResponse uploadDocs(UploadDocumentsRequest request, KycRequestHeaders kycRequestHeaders);
}
