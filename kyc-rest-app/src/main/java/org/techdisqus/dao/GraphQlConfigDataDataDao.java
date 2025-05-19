package org.techdisqus.dao;


import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.config.ConfigDataDaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Component
public class GraphQlConfigDataDataDao extends AbstractRestDao implements ConfigDataDao {

    @Override
    public ConfigDataDaoResponse getConfig(QueryDaoRequest queryDaoRequest) {



        ResponseEntity<ConfigDataDaoResponse> response =  new RestTemplate().
                postForEntity("" + "/data-service/graphql", queryDaoRequest, ConfigDataDaoResponse.class);


        if(response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error getting config");
        }

        return response.getBody();
    }

    @Override
    @Async
    public Future<ConfigDataDaoResponse> getConfigAsync(QueryDaoRequest queryDaoRequest) {
        return AsyncResult.forValue(getConfig(queryDaoRequest));
    }
}
