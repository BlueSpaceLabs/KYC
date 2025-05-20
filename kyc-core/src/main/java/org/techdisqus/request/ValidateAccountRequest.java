package org.techdisqus.request;

import lombok.Data;

import java.util.List;

@Data
public class ValidateAccountRequest extends AbstractRequest{

    private String accountIdentifier;
    private List<Consent> consents;
}
