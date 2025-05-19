package org.techdisqus.request;

import lombok.Data;

@Data
public class ValidateAccountRequest extends AbstractRequest{

    private String accountIdentifier;
}
