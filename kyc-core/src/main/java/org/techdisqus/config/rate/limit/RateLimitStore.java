package org.techdisqus.config.rate.limit;

import java.util.List;

public interface RateLimitStore {
    /**
     * Get timestamps list (or count) for given method key.
     * Should remove expired entries internally if needed.
     */
    List<Long> getTimestamps(String key);

    /**
     * Add a timestamp (usually current time) for the given key.
     */
    void addTimestamp(String key, long timestamp);
}

