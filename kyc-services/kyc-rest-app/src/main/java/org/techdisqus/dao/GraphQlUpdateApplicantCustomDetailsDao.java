package org.techdisqus.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.custom.attributes.CustomAttributesUpdateGrpahQlDaoResponse;
import org.techdisqus.exception.ApiExecutionException;


import java.util.concurrent.Future;

@Component
public class GraphQlUpdateApplicantCustomDetailsDao extends AbstractRestDao implements UpdateApplicantCustomDetailsDao{

    private Logger logger = LoggerFactory.getLogger(GraphQlUpdateApplicantCustomDetailsDao.class);
    public CustomAttributesUpdateGrpahQlDaoResponse updateCustomAttributes(QueryDaoRequest queryDaoRequest) {


               return trustplatformRestClient.post().uri("/data-service/graphql")
                        .body(queryDaoRequest)
                .exchange((clientRequest, clientResponse) -> {
                    if(clientResponse.getStatusCode() != HttpStatus.OK){
                        logger.error("CustomAttributesUpdate: Invalid response status {}", clientResponse.getStatusCode());
                        throw new ApiExecutionException(new RuntimeException("Error updating custom attributes"),null);
                    }
                    return clientResponse.bodyTo(CustomAttributesUpdateGrpahQlDaoResponse.class);
                });



    }

    @Async
    public Future<CustomAttributesUpdateGrpahQlDaoResponse> updateCustomAttributesAsync(QueryDaoRequest queryDaoRequest) {
        return AsyncResult.forValue(updateCustomAttributes(queryDaoRequest));
    }
}
