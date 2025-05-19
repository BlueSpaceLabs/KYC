package org.techdisqus.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidateCodeResponse extends AbstractResponse{

    private String accountIdentifier;

}
