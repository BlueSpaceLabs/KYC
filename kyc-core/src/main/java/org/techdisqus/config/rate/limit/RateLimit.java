package org.techdisqus.config.rate.limit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimit {
    int maxAttempts() default -1;         // -1 means use default
    long durationMillis() default -1L;    // -1 means use default
}

