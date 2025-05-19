package org.techdisqus.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.status.update.StatusUpdateDaoResponse;
import org.techdisqus.exception.ApiExecutionException;

import java.util.Objects;

@Component
public class GraphQlUpdateApplicantStatusDao extends AbstractRestDao implements UpdateApplicantStatusDao{

    private Logger logger = LoggerFactory.getLogger(GraphQlUpdateApplicantStatusDao.class);

    public StatusUpdateDaoResponse updateStatus(QueryDaoRequest queryDaoRequest) {
        return trustplatformRestClient
                .post()
                .uri("/data-service/graphql")
                .body(queryDaoRequest)
                .header("content-type", MediaType.APPLICATION_JSON_VALUE)
                .exchange((clientRequest, clientResponse) -> {
                    if(clientResponse.getStatusCode().value() != 200) {
                        throw new ApiExecutionException(new RuntimeException("Error while updating status and status code is " + clientResponse.getStatusCode().value()));
                    }
                    return Objects.requireNonNull(clientResponse.bodyTo(StatusUpdateDaoResponse.class));
                });

    }
}
