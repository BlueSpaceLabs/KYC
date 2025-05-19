package org.techdisqus.dao;



import org.techdisqus.dao.request.CustomAttributeUpdateDaoRequest;
import org.techdisqus.dao.response.custom.attributes.CustomAttributeUpdateDaoResponse;
import org.techdisqus.dao.response.custom.attributes.CustomDetailsDaoRequest;

import java.util.concurrent.Future;

public interface UpdateCustomAttributesDao  {

    CustomAttributeUpdateDaoResponse updateCustomAttributes(String externalId, CustomAttributeUpdateDaoRequest daoRequest);

    CustomAttributeUpdateDaoResponse updateCustomAttributes(String externalId, CustomDetailsDaoRequest daoRequest);
    Future<CustomAttributeUpdateDaoResponse> updateCustomAttributesAsync(String externalId, CustomAttributeUpdateDaoRequest daoRequest);

    Future<CustomAttributeUpdateDaoResponse> updateCustomAttributesAsync(String externalId,CustomDetailsDaoRequest daoRequest);
}
