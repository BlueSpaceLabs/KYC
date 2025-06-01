package org.techdisqus.config.rate.limit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.techdisqus.exception.MaxAttemptsExceededException;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;
import org.techdisqus.service.KycBaseService;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Order(2)
@Aspect
@Component
public class RateLimitAspect {

    private static final Logger logger = LoggerFactory.getLogger(RateLimitAspect.class);

    private static final Map<String, List<Long>> methodCallTimes = new ConcurrentHashMap<>();

    private final RateLimitStore rateLimitStore;
    private final RateLimitProperties rateLimitProperties;

    public RateLimitAspect(@Lazy RateLimitStore rateLimitStore, RateLimitProperties rateLimitProperties) {
        this.rateLimitStore = rateLimitStore;
        this.rateLimitProperties = rateLimitProperties;
    }


    @Around("execution(* org.techdisqus.service..*(..))")
    public Object rateLimit(ProceedingJoinPoint joinPoint) throws Throwable {

        if (joinPoint.getTarget() instanceof KycBaseService) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            String methodKey = method.getDeclaringClass().getName() + "." + method.getName();

            RateLimit annotation = method.getAnnotation(RateLimit.class);
            int maxAttempts = annotation != null && annotation.maxAttempts() > 0
                    ? annotation.maxAttempts()
                    : rateLimitProperties.getDefaults().getMaxAttempts();
            long durationMillis = annotation != null && annotation.durationMillis() > 0
                    ? annotation.durationMillis()
                    : rateLimitProperties.getDefaults().getDurationMillis();

            long now = System.currentTimeMillis();
            List<Long> timestamps = rateLimitStore.getTimestamps(methodKey);

            synchronized (timestamps) {
                // Remove old timestamps
                timestamps.removeIf(t -> now - t > durationMillis);


                // If attempts exceed limit, block execution
                if (timestamps.size() >= maxAttempts) {
                    throw new MaxAttemptsExceededException(
                            "Max attempts exceeded",
                            "Max attempts exceeded, retry after " + tryAfter(durationMillis),
                            "max.attempts.exceeded",
                            (AbstractRequest) joinPoint.getArgs()[0]
                    );
                }
            }

            // Call the method
            Object response = joinPoint.proceed();

            // Add timestamp only if response indicates error
            if (isFailure(response)) {
                rateLimitStore.addTimestamp(methodKey, now);
            }
            return response;
        }

        return joinPoint.proceed();
    }

    private String tryAfter(long durationMillis) {

        long secs = Duration.ofMillis(durationMillis).toSeconds();

        if (secs < 60) {
            return secs + " Seconds";
        }

        long mins = Duration.ofMillis(durationMillis).toMinutes();
        if (mins < 60) {
            return mins + " Minutes";
        }

        long hours = Duration.ofMillis(durationMillis).toHours();
        if (hours < 24) {
            return hours + " Hours";
        }

        long days = Duration.ofMillis(durationMillis).toDays();

        return days + " Days";

    }

    private boolean isFailure(Object obj) {
        if (obj instanceof AbstractResponse response) {
            return !response.isSuccess();
        }

        return false;
    }

    private void isAllowedToExecute(ProceedingJoinPoint joinPoint) {

        if (joinPoint.getTarget() instanceof KycBaseService kycBaseService) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            String methodKey = method.getDeclaringClass().getName() + "." + method.getName();

            RateLimit annotation = method.getAnnotation(RateLimit.class);
            int maxAttempts = annotation != null && annotation.maxAttempts() > 0
                    ? annotation.maxAttempts()
                    : rateLimitProperties.getDefaults().getMaxAttempts();
            long durationMillis = annotation != null && annotation.durationMillis() > 0
                    ? annotation.durationMillis()
                    : rateLimitProperties.getDefaults().getDurationMillis();

            long now = System.currentTimeMillis();
            List<Long> timestamps = rateLimitStore.getTimestamps(methodKey);

            synchronized (timestamps) {
                // Remove expired
                timestamps.removeIf(t -> now - t > durationMillis);

                if (timestamps.size() >= maxAttempts) {
                    throw new MaxAttemptsExceededException(
                            "Max attempts exceeded",
                            "Max attempts exceeded",
                            "max.attempts.exceeded",
                            (AbstractRequest) joinPoint.getArgs()[0]
                    );
                }

                rateLimitStore.addTimestamp(methodKey, now);
            }
        }

    }

}

