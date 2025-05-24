package org.techdisqus.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class ApiLoggingInterceptor implements HandlerInterceptor {


    private final AtomicInteger successCount = new AtomicInteger();
    private final AtomicInteger errorCount = new AtomicInteger();

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        MDC.put("reqInfo", request.getHeader("x-requestInformation"));
        startTime.set(System.currentTimeMillis());
        log.info("API START: {} {}", request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            long duration = System.currentTimeMillis() - startTime.get();
            int status = response.getStatus();

            if (status >= 200 && status < 300) {
                successCount.incrementAndGet();
                log.info("API SUCCESS: {} {} [{}] ({} ms)", request.getMethod(), request.getRequestURI(), status, duration);
            } else {
                errorCount.incrementAndGet();
                log.warn("API ERROR: {} {} [{}] ({} ms)", request.getMethod(), request.getRequestURI(), status, duration);
            }
        }finally {
            startTime.remove();
            MDC.clear();
        }
    }

    // Optional: expose counts
    public int getSuccessCount() {
        return successCount.get();
    }

    public int getErrorCount() {
        return errorCount.get();
    }
}
