package org.techdisqus.dao;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface GetImageDao {

    byte[] getImage(String url);

    @Async
    Future<byte[]> getImageAsync(String link);
}
