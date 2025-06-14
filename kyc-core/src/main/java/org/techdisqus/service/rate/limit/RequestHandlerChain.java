package org.techdisqus.service.rate.limit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestHandlerChain {

    private static final List<RequestHandler> requestHandlers = new ArrayList<>();

    public RequestHandlerChain register(RequestHandler requestHandler) {
        requestHandlers.add(requestHandler);
        return this;
    }

    public void processRequest(AbstractRequest request, AbstractResponse response, ProceedingJoinPoint joinPoint) {

        requestHandlers.forEach(requestHandler -> {
            if(requestHandler.isSupported(request, response,joinPoint)) {
                requestHandler.handleRequest(request, response, joinPoint);
            }
        });

    }




}
