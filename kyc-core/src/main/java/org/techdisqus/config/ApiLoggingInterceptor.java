package org.techdisqus.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ApiLoggingInterceptor.class);

    private final AtomicInteger successCount = new AtomicInteger();
    private final AtomicInteger errorCount = new AtomicInteger();

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTime.set(System.currentTimeMillis());
        logger.info("API START: {} {}", request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long duration = System.currentTimeMillis() - startTime.get();
        int status = response.getStatus();

        if (status >= 200 && status < 300) {
            successCount.incrementAndGet();
            logger.info("API SUCCESS: {} {} [{}] ({} ms)", request.getMethod(), request.getRequestURI(), status, duration);
        } else {
            errorCount.incrementAndGet();
            logger.warn("API ERROR: {} {} [{}] ({} ms)", request.getMethod(), request.getRequestURI(), status, duration);
        }

        startTime.remove();
    }

    // Optional: expose counts
    public int getSuccessCount() {
        return successCount.get();
    }

    public int getErrorCount() {
        return errorCount.get();
    }
}
