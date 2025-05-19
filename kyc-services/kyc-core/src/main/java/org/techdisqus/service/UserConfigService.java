package org.techdisqus.service;

import org.techdisqus.request.AccountTypeSelectionRequest;
import org.techdisqus.request.UserConfigRequest;
import org.techdisqus.response.AccountTypeSelectionResponse;
import org.techdisqus.response.UserConfigResponse;

public interface UserConfigService {


    UserConfigResponse getAccountTypes(UserConfigRequest request);

    AccountTypeSelectionResponse submitAccountType(AccountTypeSelectionRequest request);
}
