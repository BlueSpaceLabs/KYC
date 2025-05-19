package org.techdisqus.service;

import lombok.Data;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;

@Data
public class RequestExecutionContext {

    private AbstractRequest request;
    private AbstractResponse response;
    private String whichRetry;
    private int countThreshold;
}
