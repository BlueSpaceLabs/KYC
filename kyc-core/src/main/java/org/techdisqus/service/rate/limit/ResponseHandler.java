package org.techdisqus.service.rate.limit;

import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;

public interface ResponseHandler {

    void onResponse(AbstractRequest request, AbstractResponse response);

    boolean isSupported(AbstractRequest request, AbstractResponse response);
}
