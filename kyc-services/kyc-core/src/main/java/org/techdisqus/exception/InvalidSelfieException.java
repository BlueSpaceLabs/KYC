package org.techdisqus.exception;

import org.techdisqus.request.AbstractRequest;

public class InvalidSelfieException extends BaseException {

  public InvalidSelfieException(String message, String errorMessage, String errorCode, AbstractRequest request) {
    super(message, errorMessage, errorCode, request);
  }

  public InvalidSelfieException(Exception e, String errorMessage, String errorCode, AbstractRequest request) {
    super(e.getMessage(), errorMessage, errorCode, request);
  }


}
