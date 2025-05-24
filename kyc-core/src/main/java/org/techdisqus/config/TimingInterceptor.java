package org.techdisqus.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TimingInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(TimingInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws java.io.IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();

        try {
            Response response = chain.proceed(request);
            long timeTaken = System.currentTimeMillis() - startTime;
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder();

            builder.header("Correlation-ID", MDC.get("Correlation-ID"));
            MDC.put("endpoint", request.url().toString());
            MDC.put("executionTime", timeTaken + "");
            // Log and record downstream time
            logger.info("HTTP {} {} status code {} isSuccess {} took {} ms",  request.method(), request.url(), response.code(), response.isSuccessful(), timeTaken);

            return response;
        } catch (Exception ex) {
            long timeTaken = System.currentTimeMillis() - startTime;
            MDC.put("endpoint", request.url().toString());
            MDC.put("executionTime", timeTaken + "");
            logger.warn("HTTP {} {} failed after {} ms",  request.method(), request.url(), timeTaken);
            throw ex;
        }finally {
            MDC.remove("endpoint");
            MDC.remove("executionTime");
        }
    }
}
