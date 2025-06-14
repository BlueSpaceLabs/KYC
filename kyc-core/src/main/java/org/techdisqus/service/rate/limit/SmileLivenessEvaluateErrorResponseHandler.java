package org.techdisqus.service.rate.limit;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;
import org.techdisqus.util.Utils;

import java.util.Map;

@Component
public class SmileLivenessEvaluateErrorResponseHandler implements ResponseHandler{

    @Autowired
    private ResponseHandlerChain responseHandlerChain;

    @Override
    public void onResponse(AbstractRequest request, AbstractResponse response) {
        if(!response.isSuccess()) {
            Map<String,String> userData = Utils.parseInfo(response.getUserData());
            int count = Integer.parseInt(userData.getOrDefault("smileEvalCount", "0")) + 1;
            userData.put("smileEvalCount", count+"");
            response.setUserData(userData);
        }

    }

    @Override
    public boolean isSupported(AbstractRequest request, AbstractResponse response) {
        return response.getErrorCode().equals("SMILE-008");
    }

    @PostConstruct
    public void register() {
        responseHandlerChain.register(this);
    }
}
