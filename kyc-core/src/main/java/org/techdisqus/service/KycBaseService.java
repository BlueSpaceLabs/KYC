package org.techdisqus.service;

import com.innovatrics.dot.integrationsamples.disapi.model.CustomerOnboardingApi;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;
import org.techdisqus.util.EncryptionUtil;
import org.techdisqus.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public abstract class KycBaseService implements RetryHandler{

    protected static final String DECLINED = "declined";

    protected static final String MASTER = "master";

    protected static final String ACCEPT = "accept";

    protected static final String REVIEW = "review";

    protected static final String UNIQUENESS = "uniqueness";

    protected static final String REJECT = "reject";

    protected static final String TERMS_ACCEPTANCE_CONFIRMATION = "termsAcceptanceConfirmation";

    protected static final String ACCEPT_AND_CONFIRMATIONIS = "acceptAndConfirmationis";

    private static Logger logger = LoggerFactory.getLogger(KycBaseService.class);

    private static int RETRY = 3;

    @Value("${retryTime:3}")
    private long retryTime;

    @Autowired
    protected EncryptionUtil encryptionUtil;

    @Autowired
    protected MessageProvider messageProvider;

    @Autowired
    protected CustomerOnboardingApi customerOnboardingApi;

    protected boolean isLocalCitizen(String country){
        return "PHL".equalsIgnoreCase(country) || "FILIPINO".equalsIgnoreCase(country);
    }

    @Override
    public boolean incrementCount(RequestExecutionContext context) {
        return false;
    }

    @Override
    public boolean isAttemptsExceeded(RequestExecutionContext context) {
        AbstractRequest request = context.getRequest();
        Map<String, String> opaqueData =  request.getRequestInformation();
        int currentSelfieRetryCount = Integer.parseInt(opaqueData.getOrDefault(
                context.getWhichRetry(),"0"));

        String attemptTimeInSeconds = opaqueData.get("sentDateTime");


        if (StringUtils.isNotEmpty(attemptTimeInSeconds)) {

            long previousTime = Long.parseLong(attemptTimeInSeconds);
            long currentTime = Instant.now().toEpochMilli();
            boolean is24HoursPassed = (currentTime - previousTime) >= retryTime;

            if (currentSelfieRetryCount >= context.getCountThreshold() && !is24HoursPassed) {
                return false;
            }

            if (is24HoursPassed) {
                opaqueData.put(context.getWhichRetry(), "0");
            }
        }

        return true;
    }

    public  interface ExecuteOperation<T> {
        T executeTask();
    }

    public  interface ExecuteAsyncOperation<T> {
        T executeTask();
        int hashCode();
        boolean equals();
    }

    public <T> Result<T> executeWithRetry(ExecuteOperation<T> executeOperation){
        return executeWithRetry(executeOperation, RETRY);
    }

    public <T> Result<T> executeWithRetry(ExecuteOperation<T> executeOperation, int retry){

        int attempts = 1;

        while ( attempts <= retry) {
            logger.info("attempts {} ", attempts);
            try {
               T response =  executeOperation.executeTask();
               return new Result<>(response,true);
            }catch (Exception e) {
                logger.error("Error while execution ", e);
                attempts++;
//                return new Result<>(e.getCause(),true);
            }
        }

        return new Result<>(null, false);

    }

    public <T> Result<List<T>> executeAsyncWithRetry(List<ExecuteAsyncOperation<T>> executeOperation){
        return executeAsyncWithRetry(executeOperation, RETRY);
    }

    public <T> Result<List<T>> executeAsyncWithRetry(List<ExecuteAsyncOperation<T>> executeOperations, int retry){

        int attempts = 1;

        Set<ExecuteAsyncOperation<T>> executed = new LinkedHashSet<>(executeOperations.size());

        List<T> responses = new ArrayList<>(executeOperations.size());

        while ( attempts <= retry) {

            for(ExecuteAsyncOperation<T> executeAsyncOperation : executeOperations) {
                if(!executed.contains(executeAsyncOperation)) {
                    try {
                        T response =  executeAsyncOperation.executeTask();
                        responses.add(response);
                        executed.add(executeAsyncOperation);
                    }catch (Exception e) {
                        logger.error("Error while execution ", e);
                        attempts++;
//                return new Result<>(e.getCause(),true);
                    }
                }
            }
        }

        return new Result<>(null, false);
    }

    protected String getRequestId() {
        return UUID.randomUUID().toString();
    }

    protected String getSessionId() {
        return UUID.randomUUID().toString();
    }

    public Locale toLocale(AbstractRequest request) {
        return Locale.forLanguageTag(request.getLocale());
    }

    protected <T extends AbstractResponse> T setAndReturnErrorResponse(String errorCode, String errorDesc, T response) {
        response.setErrorCode(errorCode);
        response.setErrorDetails(errorDesc);
        return response;
    }

    private void incrementCount(AbstractResponse response, Map<String, String> opaqueData, String whichCount,
                                int count) {
        opaqueData.put("selfieRetryCount", String.valueOf(count + 1));
        opaqueData.put(whichCount, String.valueOf(count + 1));
        opaqueData.put("sentDateTime", String.valueOf(Instant.now().toEpochMilli()));
        response.setUserData(opaqueData);
    }
}
