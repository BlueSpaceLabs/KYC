package org.techdisqus.config.preprocess;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.request.KycRequestHeaders;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Order(1)
@Aspect
@Component
public class PreprocessAspect {

    private static final Logger logger = LoggerFactory.getLogger(PreprocessAspect.class);

    private static final Map<String, List<Long>> methodCallTimes = new ConcurrentHashMap<>();



    @Around("execution(* org.techdisqus.service..*(..))")
    public Object preprocess(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        MDC.put("methodName", methodName);
        logger.info("START: {}", methodName);

        String sessionId = "";
        String id = "";

        try {
            Object[] args = joinPoint.getArgs();
            if (args != null && args.length > 0 && args[0] instanceof AbstractRequest request) {
                if (args.length == 2 && args[1] != null && args[1] instanceof KycRequestHeaders kycRequestHeaders) {
                    if (request.getRequestInformationString() == null && kycRequestHeaders.getRequestInformation() != null) {
                        request.setRequestInformation(kycRequestHeaders.getRequestInformation());
                    }
                }
            }
        } catch(Throwable ex) {
            logger.error("ERROR in {}: {}", methodName, ex.getMessage(), ex);
            throw ex;
        }
        return joinPoint.proceed();
    }

}

