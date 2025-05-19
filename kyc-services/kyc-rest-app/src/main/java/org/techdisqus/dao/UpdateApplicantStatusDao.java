package org.techdisqus.dao;


import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.status.update.StatusUpdateDaoResponse;

import java.util.concurrent.Future;

public interface UpdateApplicantStatusDao {

    StatusUpdateDaoResponse updateStatus(QueryDaoRequest queryDaoRequest);



}
