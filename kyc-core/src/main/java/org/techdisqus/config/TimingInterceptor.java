package org.techdisqus.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContext;
import org.springframework.util.DigestUtils;
import org.techdisqus.util.ApplicationContextUtils;
import org.techdisqus.util.EncryptionUtil;

import java.util.Map;

public class TimingInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(TimingInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws java.io.IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        String reqInformation = MDC.get("reqInfo");
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        String str = encryptionUtil.decrypt(reqInformation);
        String hashedId = "";
        try {
            String identifier = "NA";
            if(str != null && !str.isEmpty()) {
                Map<String, String> map = new ObjectMapper().readValue(str, new TypeReference<>() {});
                identifier = map.get("msisdn");
            }

            hashedId = DigestUtils.md5DigestAsHex(identifier.getBytes());
            Response response = chain.proceed(request);
            long timeTaken = System.currentTimeMillis() - startTime;
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder();

            builder.header("Correlation-ID", MDC.get("Correlation-ID"));


            // Log and record downstream time
            logger.info("id:{} hashedId {} HTTP {} {} took {} ms", identifier, hashedId, request.method(), request.url(), timeTaken);

            return response;
        } catch (Exception ex) {
            long timeTaken = System.currentTimeMillis() - startTime;
            logger.warn("id: hashedId {} HTTP {} {} failed after {} ms", hashedId, request.method(), request.url(), timeTaken);
            throw ex;
        }
    }
}
