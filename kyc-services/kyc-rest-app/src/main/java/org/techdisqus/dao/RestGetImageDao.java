package org.techdisqus.dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.Future;

import static org.techdisqus.dao.RestCustomerOperations.HEADER_AUTHORIZATION;

@Component
public class RestGetImageDao extends AbstractRestDao implements GetImageDao{

    public byte[] getImage(String url){
        return trustplatformRestClient.get().uri(url)
                .header(HEADER_AUTHORIZATION, getBearerToken())
                .exchange((clientRequest, clientResponse) -> Objects.requireNonNull(clientResponse.bodyTo(byte[].class)));
    }


    @Override
    @Async
    public Future<byte[]> getImageAsync(String link){

        return AsyncResult.forValue(getImage(link));
    }
}
