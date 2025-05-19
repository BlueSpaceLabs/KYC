package org.techdisqus.service;

import org.techdisqus.request.ValidateAccountRequest;
import org.techdisqus.response.AbstractResponse;
import org.techdisqus.response.ValidateAccountResponse;

public interface ValidateAccountService  {

    ValidateAccountResponse verify(ValidateAccountRequest request);
}
