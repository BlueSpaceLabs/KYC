package org.techdisqus.service;

import org.techdisqus.request.UserSmileRequest;
import org.techdisqus.response.UserSelfieResponse;

public interface SelfieScanService {

    UserSelfieResponse scanSelfie(UserSmileRequest request);
}
