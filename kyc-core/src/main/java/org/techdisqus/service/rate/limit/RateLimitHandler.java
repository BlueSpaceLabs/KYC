package org.techdisqus.service.rate.limit;

import org.techdisqus.request.AbstractRequest;

public interface RateLimitHandler {

    boolean isAllowedToExecuted(AbstractRequest request);
}
