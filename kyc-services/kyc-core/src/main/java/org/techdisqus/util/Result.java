package org.techdisqus.util;

public class Result<T> {

    private final T response;
    private final boolean isSuccess;
    private Throwable ex;

    public Result(T response, boolean isSuccess) {
        this.response = response;
        this.isSuccess = isSuccess;
    }

    public Result(Throwable ex, boolean isSuccess) {
        this.response = null;
        this.ex = ex;
        this.isSuccess = isSuccess;
    }

    public T getResponse() {
        return response;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Throwable getEx() {
        return ex;
    }


}
