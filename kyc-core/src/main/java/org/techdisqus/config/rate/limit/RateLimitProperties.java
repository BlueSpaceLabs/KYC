package org.techdisqus.config.rate.limit;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ConfigurationProperties(prefix = "ratelimit")
@Data
public class RateLimitProperties {
    private Defaults defaults = new Defaults();
    private Map<String, MethodConfig> methods = new HashMap<>();

    @Data
    public static class Defaults {
        private int maxAttempts  ;
        private long durationMillis; // default 1 min

        // Getters and setters
    }

    @Data
    public static class MethodConfig {
        private int maxAttempts;
        private long durationMillis;

        // Getters and setters
    }

    @PostConstruct
    public void init(){
        System.out.println(defaults);
    }
    // Getters and setters
}
