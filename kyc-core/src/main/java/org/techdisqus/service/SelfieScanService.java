package org.techdisqus.service;

import org.techdisqus.request.UserSelfieRequest;
import org.techdisqus.response.UserSelfieResponse;

public interface SelfieScanService {

    UserSelfieResponse scanSelfie(UserSelfieRequest request);
}
