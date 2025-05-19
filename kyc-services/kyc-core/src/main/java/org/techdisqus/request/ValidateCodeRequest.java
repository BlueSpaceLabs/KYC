package org.techdisqus.request;

import lombok.Data;

@Data
public class ValidateCodeRequest extends AbstractRequest{

    private String accountIdentifier;
    private String otp;
}
