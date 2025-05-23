package org.techdisqus.exception;

import org.techdisqus.request.AbstractRequest;

public class BadRequestException extends BaseException {

  public BadRequestException(String message, String errorMessage, String errorCode, AbstractRequest request) {
    super(message, errorMessage, errorCode, request);
  }

  public BadRequestException(Exception e, String errorMessage, String errorCode, AbstractRequest request) {
    super(e.getMessage(), errorMessage, errorCode, request);
  }

}
