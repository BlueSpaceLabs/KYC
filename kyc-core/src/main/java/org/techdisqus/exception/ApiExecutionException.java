package org.techdisqus.exception;

import org.techdisqus.request.AbstractRequest;

public class ApiExecutionException extends BaseException {

  public ApiExecutionException(Throwable t, AbstractRequest request) {
    super(t.getMessage(), "Error while executing the API", "execution.error", request);
  }

  public ApiExecutionException(Throwable t) {
    super(t.getMessage(), "Error while executing the API", "execution.error", null);
  }
}
