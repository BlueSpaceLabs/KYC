package org.techdisqus.service;

public interface RetryHandler {

    boolean isAttemptsExceeded(RequestExecutionContext context);

    boolean incrementCount(RequestExecutionContext context);
}
