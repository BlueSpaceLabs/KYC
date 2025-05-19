package org.techdisqus.exception;

import org.techdisqus.request.AbstractRequest;

public class InvalidDocumentException extends BaseException {

  public InvalidDocumentException(String message, String errorMessage, String errorCode, AbstractRequest request) {
    super(message, errorMessage, errorCode, request);
  }

  public InvalidDocumentException(Exception e, String errorMessage, String errorCode, AbstractRequest request) {
    super(e.getMessage(), errorMessage, errorCode, request);
  }

}
