package org.techdisqus.service;

import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import org.techdisqus.request.*;
import org.techdisqus.response.*;

public interface DocumentScanService {

    DocumentScanResponse scanDocument(DocumentScanRequest request) throws ApiException;

}
