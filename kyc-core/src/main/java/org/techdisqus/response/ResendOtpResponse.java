package org.techdisqus.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResendOtpResponse extends AbstractResponse{

    private String accountIdentifier;

}
