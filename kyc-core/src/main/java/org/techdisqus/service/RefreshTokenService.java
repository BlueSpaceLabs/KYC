package org.techdisqus.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RefreshTokenService {

    // Simulating DB with a concurrent map
    private final Map<String, String> tokenStore = new ConcurrentHashMap<>();

    public String createRefreshToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(token, username);
        return token;
    }

    public String validateRefreshToken(String token) {
        String username = tokenStore.get(token);
        if (username == null) {
            throw new RuntimeException("Invalid or expired refresh token");
        }
        return username;
    }

    public void revokeToken(String token) {
        tokenStore.remove(token);
    }
}
