package org.techdisqus.dao;





import org.techdisqus.dao.request.SaveToTrustStoreDaoRequest;
import org.techdisqus.dao.response.SaveToTrustStoreDaoResponse;

public interface CustomerOperations{

    SaveToTrustStoreDaoResponse saveCustomer(SaveToTrustStoreDaoRequest request, String ulid);
}
