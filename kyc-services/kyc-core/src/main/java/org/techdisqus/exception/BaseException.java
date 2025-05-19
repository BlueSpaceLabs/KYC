package org.techdisqus.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.techdisqus.request.AbstractRequest;

@Getter
@Slf4j
public abstract class BaseException extends RuntimeException {

    private final String errorMessage;
    private final  String errorCode;
    private final AbstractRequest request;

    public BaseException(String message, String errorMessage, String errorCode, AbstractRequest request) {
        super(message);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.request = request;
    }

}
