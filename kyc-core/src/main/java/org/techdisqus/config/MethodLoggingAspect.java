package org.techdisqus.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.techdisqus.response.AbstractResponse;

@Aspect
@Component
public class MethodLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodLoggingAspect.class);

    @Around("execution(* com.techdisqus.service..*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();

        logger.info("START: {}", methodName);
        try {
            Object result = joinPoint.proceed();
            if(result instanceof AbstractResponse response) {
                if (response.isSuccess()) {
                    logger.info("END: {} is success (duration: {} ms)", methodName, System.currentTimeMillis() - start);
                } else {
                    logger.info("END: {} is failed (duration: {} ms)", methodName, System.currentTimeMillis() - start);
                }
            }

            return result;
        } catch (Throwable ex) {
            logger.error("ERROR in {}: {}", methodName, ex.getMessage(), ex);
            throw ex;
        }
    }
}

