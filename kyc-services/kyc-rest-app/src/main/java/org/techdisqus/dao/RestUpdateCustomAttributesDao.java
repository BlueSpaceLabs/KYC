package org.techdisqus.dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.request.CustomAttributeUpdateDaoRequest;
import org.techdisqus.dao.response.custom.attributes.CustomAttributeUpdateDaoResponse;
import org.techdisqus.dao.response.custom.attributes.CustomDetailsDaoRequest;


import java.util.Objects;
import java.util.concurrent.Future;

import static org.springframework.scheduling.annotation.AsyncResult.*;
import static org.techdisqus.dao.RestCustomerOperations.HEADER_AUTHORIZATION;

@Component
public class RestUpdateCustomAttributesDao extends AbstractRestDao implements UpdateCustomAttributesDao{

    public CustomAttributeUpdateDaoResponse updateCustomAttributes(String externalId, CustomAttributeUpdateDaoRequest daoRequest){
        return trustplatformRestClient
                .put()
                .uri("/abis/v3/onboarding/applicants/" + externalId + "/enroll")
                .header(HEADER_AUTHORIZATION,  getBearerToken())
                .body(daoRequest)
                .exchange((clientRequest, clientResponse) -> Objects.requireNonNull(clientResponse.bodyTo(CustomAttributeUpdateDaoResponse.class)));
    }

    @Override
    public CustomAttributeUpdateDaoResponse updateCustomAttributes(String externalId, CustomDetailsDaoRequest daoRequest) {

        return trustplatformRestClient
                .put()
                .uri("/abis/v3/applicants/" + externalId + "/fields")
                .header(HEADER_AUTHORIZATION,  getBearerToken())
                .body(daoRequest)
                .exchange((clientRequest, clientResponse) -> Objects.requireNonNull(clientResponse.bodyTo(CustomAttributeUpdateDaoResponse.class)));


    }

    @Async
    public Future<CustomAttributeUpdateDaoResponse> updateCustomAttributesAsync(String externalId, CustomAttributeUpdateDaoRequest daoRequest){
        return forValue(updateCustomAttributes(externalId, daoRequest));
    }

    @Override
    @Async
    public Future<CustomAttributeUpdateDaoResponse> updateCustomAttributesAsync(String externalId, CustomDetailsDaoRequest daoRequest) {
        return forValue(updateCustomAttributes(externalId, daoRequest));
    }
}
