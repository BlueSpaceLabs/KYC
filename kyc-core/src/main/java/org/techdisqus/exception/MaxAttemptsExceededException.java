package org.techdisqus.exception;

import org.techdisqus.request.AbstractRequest;

public class MaxAttemptsExceededException extends BaseException{

    public MaxAttemptsExceededException(String message, String errorMessage, String errorCode, AbstractRequest request) {
        super(message, errorMessage, errorCode, request);
    }
}
