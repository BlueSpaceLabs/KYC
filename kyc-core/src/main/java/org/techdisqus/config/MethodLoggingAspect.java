package org.techdisqus.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.AbstractResponse;
import org.techdisqus.util.ApplicationContextUtils;
import org.techdisqus.util.EncryptionUtil;

import java.util.Map;
import java.util.UUID;

@Aspect
@Component
public class MethodLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodLoggingAspect.class);

    @Around("execution(* org.techdisqus.service..*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        MDC.put("methodName", methodName);
        logger.info("START: {}", methodName);
        String requestId = getRequestId();
        String sessionId = "";
        MDC.put("requestId", requestId);
        String id = "";
        try {
            Object[] args = joinPoint.getArgs();
            if(args != null && args.length > 0 && args[0] instanceof ValidateAccountRequest request) {
                id = request.getAccountIdentifier();
                MDC.put("identifier", DigestUtils.md5DigestAsHex(id.getBytes()));
                sessionId = getSessionId();
                MDC.put("sessionId", sessionId);
            }else if(args != null && args.length > 0 && args[0] instanceof AbstractRequest request){
                Map<String,String> reqInformation = request.getRequestInformation();
                String identifier = reqInformation.get("identifier");
                String hashedId = DigestUtils.md5DigestAsHex(identifier.getBytes());
                MDC.put("identifier", hashedId);
                MDC.put("sessionId", reqInformation.get("sessionId"));
            }

            Object result = joinPoint.proceed();
            if(result instanceof AbstractResponse response) {

                response.setRequestId(requestId);

                if(args != null && args.length > 0 && args[0] instanceof ValidateAccountRequest
                        && response.getUserData() != null && !response.getUserData().isEmpty()) {
                    ApplicationContext context = ApplicationContextUtils.getApplicationContext();
                    EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
                    String str = encryptionUtil.decrypt(response.getUserData());
                    try {
                        Map<String,String> map =  new ObjectMapper().readValue(str, new TypeReference<>() {
                        });
                        map.put("sessionId", sessionId);
                        map.put("identifier", id);
                        response.setUserData(map);
                    } catch (JsonProcessingException e) {
                        logger.info("Error while getting user data {}", response.getUserData(), e);
                    }
                }
                MDC.put("timeTaken", (System.currentTimeMillis() - start) + "");

                if (response.isSuccess()) {
                    logger.info("END: {} is success (duration: {} ms)", methodName, System.currentTimeMillis() - start);
                } else {
                    logger.info("END: {} is failed (duration: {} ms)", methodName, System.currentTimeMillis() - start);
                    logger.error("Error details {}", response);
                }
            }

            return result;
        } catch (Throwable ex) {
            logger.error("ERROR in {}: {}", methodName, ex.getMessage(), ex);
            throw ex;
        }
    }

    private String getRequestId() {
        return UUID.randomUUID().toString();
    }
    private String getSessionId() {
        return UUID.randomUUID().toString();
    }
}

