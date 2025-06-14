package org.techdisqus.service.rate.limit;

import org.springframework.stereotype.Component;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseHandlerChain {

    private static final List<ResponseHandler> responseHandlers = new ArrayList<>();

    public ResponseHandlerChain register(ResponseHandler responseHandler) {
        responseHandlers.add(responseHandler);
        return this;
    }

    public void processResponse(AbstractRequest request, AbstractResponse response) {

        responseHandlers.forEach(responseHandler -> {
            if(responseHandler.isSupported(request, response)) {
                responseHandler.onResponse(request, response);
            }
        });

    }




}
