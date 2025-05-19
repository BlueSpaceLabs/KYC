package org.techdisqus.dao;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.techdisqus.dao.request.SaveToTrustStoreDaoRequest;
import org.techdisqus.dao.response.SaveToTrustStoreDaoResponse;

import java.util.Objects;

@Component
public class RestCustomerOperations extends AbstractRestDao implements CustomerOperations{


    public static final String API_V_1_CUSTOMERS = "/api/v1/customers/";

    public static final String HEADER_AUTHORIZATION = "Authorization";




    @Override
    public SaveToTrustStoreDaoResponse saveCustomer(SaveToTrustStoreDaoRequest request, String customerId){

        //
        return   restClient.post()
                .uri(API_V_1_CUSTOMERS + customerId + "/store")
                .header(HEADER_AUTHORIZATION, getBearerToken())
                .body(request)
                .header("content-type", MediaType.APPLICATION_JSON_VALUE)
                .exchange((clientRequest, clientResponse) ->
                        Objects.requireNonNull(clientResponse.bodyTo(SaveToTrustStoreDaoResponse.class)));
    }
}
