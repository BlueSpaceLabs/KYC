package org.techdisqus.exception;

import org.techdisqus.request.AbstractRequest;

public class ProcessDocumentException extends BaseException {
  public ProcessDocumentException(Throwable e, String errorMessage, String errorCode, AbstractRequest request) {
    super(e.getMessage(), errorMessage, errorCode, request);
  }
}
