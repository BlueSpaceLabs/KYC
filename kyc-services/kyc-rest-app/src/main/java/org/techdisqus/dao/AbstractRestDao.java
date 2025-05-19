package org.techdisqus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestClient;

public class AbstractRestDao {


    @Autowired
    @Qualifier("disClient")
    protected RestClient restClient;

    @Autowired
    @Qualifier("trustPlatformClient")
    protected RestClient trustplatformRestClient;

    @Autowired
    @Qualifier("token")
    protected String token;

    protected String getBearerToken(){
        return "Bearer " + token;
    }
}
