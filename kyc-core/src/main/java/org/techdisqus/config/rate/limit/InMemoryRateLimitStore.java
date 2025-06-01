package org.techdisqus.config.rate.limit;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Primary
@Component
public class InMemoryRateLimitStore implements RateLimitStore {
    private final Map<String, List<Long>> store = new ConcurrentHashMap<>();

    @Override
    public List<Long> getTimestamps(String key) {
        return store.computeIfAbsent(key, k -> Collections.synchronizedList(new ArrayList<>()));
    }

    @Override
    public void addTimestamp(String key, long timestamp) {
        List<Long> timestamps = getTimestamps(key);
        synchronized (timestamps) {
            timestamps.add(timestamp);
        }
    }
}
