package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidateAccountResponse extends AbstractResponse{

    private String accountIdentifier;

}
