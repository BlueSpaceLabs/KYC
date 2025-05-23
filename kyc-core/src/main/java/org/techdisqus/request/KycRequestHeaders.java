package org.techdisqus.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KycRequestHeaders {
    private String accountIdentifier;
    private String requestInformation;
    private String locale;
}
