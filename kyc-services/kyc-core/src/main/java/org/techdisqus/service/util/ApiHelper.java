package org.techdisqus.service.util;

import com.innovatrics.dot.integrationsamples.disapi.ApiCallback;
import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import org.techdisqus.exception.ApiExecutionException;
import org.techdisqus.request.AbstractRequest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ApiHelper {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static <T> void executeAsyncWithHandler(
            ApiInvoker<T> apiInvoker,
            long timeoutMillis,
            ResponseHandler<T> responseHandler
    ) {
        CompletableFuture<T> future = new CompletableFuture<>();

        // Setup timeout
        ScheduledFuture<?> timeoutTask = scheduler.schedule(() -> {
            future.completeExceptionally(new TimeoutException("Request timed out after " + timeoutMillis + " ms"));
        }, timeoutMillis, TimeUnit.MILLISECONDS);

        // Invoke API
        apiInvoker.invoke(new ApiCallback<T>() {
            @Override
            public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                timeoutTask.cancel(true);
                future.completeExceptionally(e);
            }

            @Override
            public void onSuccess(T result, int statusCode, Map<String, List<String>> responseHeaders) {
                timeoutTask.cancel(true);
                future.complete(result);
            }

            @Override
            public void onUploadProgress(long bytesWritten, long contentLength, boolean done) { }

            @Override
            public void onDownloadProgress(long bytesRead, long contentLength, boolean done) { }
        });

        // Handle success or failure
        future.thenAccept(responseHandler::onSuccess)
                .exceptionally(ex -> {
                    responseHandler.onFailure(ex);
                    return null;
                });
    }

    @FunctionalInterface
    public interface ApiInvoker<T> {
        void invoke(ApiCallback<T> callback);
    }

    @FunctionalInterface
    public interface ResponseHandler<T> {
        void onSuccess(T response);
        default void onFailure(Throwable t) {
            t.printStackTrace();
        }
    }

    public static <T> CompletableFuture<T> execute(ApiCall<T> apiCall, AbstractRequest request)  {
        CompletableFuture<T> future = new CompletableFuture<>();

        try {
            apiCall.invoke(new ApiCallback<T>() {
                @Override
                public void onSuccess(T result, int statusCode, Map<String, List<String>> responseHeaders) {
                    future.complete(result);
                }

                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    future.completeExceptionally(e);
                }

                @Override public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {}
                @Override public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {}
            });
        } catch (ApiException e) {
            throw new ApiExecutionException(e, request);
        }

        return future;
    }

    @FunctionalInterface
    public interface ApiCall<T> {
        void invoke(ApiCallback<T> callback) throws ApiException;
    }
}


