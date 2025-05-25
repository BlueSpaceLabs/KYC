package org.techdisqus.config.async;

import org.slf4j.MDC;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ContextAwareExecutorService extends AbstractExecutorService {

    private final ExecutorService delegate;

    public ContextAwareExecutorService(ExecutorService delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute(Runnable command) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        delegate.execute(() -> {
            Map<String, String> previous = MDC.getCopyOfContextMap();
            setMDC(contextMap);
            try {
                command.run();
            } finally {
                setMDC(previous);
            }
        });
    }

    private void setMDC(Map<String, String> contextMap) {
        if (contextMap != null) MDC.setContextMap(contextMap);
        else MDC.clear();
    }

    // === Delegate remaining ExecutorService methods ===
    @Override public void shutdown() { delegate.shutdown(); }
    @Override public List<Runnable> shutdownNow() { return delegate.shutdownNow(); }
    @Override public boolean isShutdown() { return delegate.isShutdown(); }
    @Override public boolean isTerminated() { return delegate.isTerminated(); }
    @Override public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate.awaitTermination(timeout, unit);
    }
    @Override public <T> Future<T> submit(Callable<T> task) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return delegate.submit(() -> {
            setMDC(contextMap);
            try {
                return task.call();
            } finally {
                MDC.clear();
            }
        });
    }
}
