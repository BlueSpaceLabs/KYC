package org.techdisqus.config.logging.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.MDC;

import java.io.IOException;

public class OkHttpHeaderInjector implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder builder = originalRequest.newBuilder();

        builder.header("Correlation-ID", MDC.get("Correlation-ID"));

        return chain.proceed(builder.build());
    }
}
