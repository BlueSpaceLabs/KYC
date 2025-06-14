package org.techdisqus.service.rate.limit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;

public interface RequestHandler {

    boolean handleRequest(AbstractRequest request, AbstractResponse response,ProceedingJoinPoint joinPoint);
    boolean isSupported(AbstractRequest request,  AbstractResponse response,ProceedingJoinPoint joinPoint);
}
