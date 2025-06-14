package org.techdisqus.service.rate.limit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.techdisqus.exception.MaxAttemptsExceededException;
import org.techdisqus.request.AbstractRequest;
import org.techdisqus.response.AbstractResponse;
import org.techdisqus.service.SelfieScanService;

import java.time.Duration;
import java.util.Map;

public class SmileEvaluationRequestHandler implements RequestHandler{
    @Override
    public boolean handleRequest(AbstractRequest request, AbstractResponse response, ProceedingJoinPoint joinPoint) {
        Map<String, String> map = request.getRequestInformation();
        int count = Integer.parseInt(map.getOrDefault("smileEvalCount", "0"));

        if(count >= 100) {

            throw new MaxAttemptsExceededException(
                    "Max attempts exceeded",
                    "Max attempts exceeded, retry after sometime ",
                    "max.attempts.exceeded",
                    (AbstractRequest) joinPoint.getArgs()[0]
            );
        }
        return count > 100;
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

    @Override
    public boolean isSupported(AbstractRequest request, AbstractResponse response, ProceedingJoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().isInstance(SelfieScanService.class);
    }
}
