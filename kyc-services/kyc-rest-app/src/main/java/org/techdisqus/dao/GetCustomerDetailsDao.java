package org.techdisqus.dao;


import org.techdisqus.dao.response.custom.attributes.GetCustomerDetailsDaoResponse;

import java.util.List;
import java.util.concurrent.Future;

public interface GetCustomerDetailsDao {
    GetCustomerDetailsDaoResponse queryByExternalId(String externalId, boolean fullResponse);

    List<GetCustomerDetailsDaoResponse> queryByExternalIds(List<String> externalId, boolean fullResponse);

    Future<GetCustomerDetailsDaoResponse> queryByExternalIdAsync(String externalId, boolean fullResponse);
    Future<List<GetCustomerDetailsDaoResponse>> queryByExternalIdsAsync(List<String> externalIds, boolean fullResponse);
}
