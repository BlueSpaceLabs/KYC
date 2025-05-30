package org.techdisqus.request;

import lombok.Data;

@Data
public class TokenRefreshRequest {
    private String refreshToken;
}
