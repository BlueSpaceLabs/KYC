package org.techdisqus.dao;



import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.config.ConfigDataDaoResponse;

import java.util.concurrent.Future;

public interface ConfigDataDao extends BaseDao {

    ConfigDataDaoResponse getConfig(QueryDaoRequest queryDaoRequest);

    Future<ConfigDataDaoResponse> getConfigAsync(QueryDaoRequest queryDaoRequest);

}
