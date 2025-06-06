package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {

    private String accessToken;
    private int expiry;
}
