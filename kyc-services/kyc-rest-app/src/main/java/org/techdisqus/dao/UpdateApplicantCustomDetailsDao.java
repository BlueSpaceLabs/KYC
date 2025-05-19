package org.techdisqus.dao;


import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.custom.attributes.CustomAttributesUpdateGrpahQlDaoResponse;

public interface UpdateApplicantCustomDetailsDao  {

    CustomAttributesUpdateGrpahQlDaoResponse updateCustomAttributes(QueryDaoRequest queryDaoRequest);




}
