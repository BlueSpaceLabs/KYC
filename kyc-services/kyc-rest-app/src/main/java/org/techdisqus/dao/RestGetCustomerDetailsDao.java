package org.techdisqus.dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

import static org.techdisqus.dao.RestCustomerOperations.HEADER_AUTHORIZATION;

@Component
public class RestGetCustomerDetailsDao extends AbstractRestDao implements GetCustomerDetailsDao {
    public GetCustomerDetailsDaoResponse queryByExternalId(String externalId, boolean fullResponse){
        //TODO: update response model CustomerDetailsDaoResponse to have custom attributes
        return trustplatformRestClient
                .get()
                .uri("/abis/v3/onboarding/applicants/" + externalId + "?fullResponse=" + fullResponse)
                .header(HEADER_AUTHORIZATION, getBearerToken())
                .exchange((clientRequest, clientResponse) -> Objects.requireNonNull(clientResponse.bodyTo(GetCustomerDetailsDaoResponse.class)));
    }

    @Override
    public List<GetCustomerDetailsDaoResponse> queryByExternalIds(List<String> externalId, boolean fullResponse){
        //TODO: update response model CustomerDetailsDaoResponse to have custom attributes
        return trustplatformRestClient
                .get()
                .uri("/abis/v3/onboarding/applicants/" + externalId + "?fullResponse=" + fullResponse)
                .header(HEADER_AUTHORIZATION, getBearerToken())
                .exchange((clientRequest, clientResponse) -> Objects.requireNonNull(clientResponse.bodyTo(List.class)));

    }

    @Async
    @Override
    public Future<GetCustomerDetailsDaoResponse> queryByExternalIdAsync(String externalId, boolean fullResponse) {
        return AsyncResult.forValue(queryByExternalId(externalId,fullResponse));
    }

    @Async
    @Override
    public Future<List<GetCustomerDetailsDaoResponse>> queryByExternalIdsAsync(List<String> externalIds, boolean fullResponse) {
         return AsyncResult.forValue(queryByExternalIds(externalIds,fullResponse));
    }

}
