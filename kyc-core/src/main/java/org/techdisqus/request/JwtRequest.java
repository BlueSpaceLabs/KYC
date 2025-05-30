package org.techdisqus.request;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
    // getters/setters
}