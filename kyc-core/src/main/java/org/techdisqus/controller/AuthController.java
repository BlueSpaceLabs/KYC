package org.techdisqus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techdisqus.request.JwtRequest;
import org.techdisqus.request.TokenRefreshRequest;
import org.techdisqus.response.JwtAuthResponse;
import org.techdisqus.service.RefreshTokenService;
import org.techdisqus.util.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/token")
    public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                    )
            );

            String accessToken = jwtTokenUtil.generateToken(request.getUsername());
            String refreshToken = refreshTokenService.createRefreshToken(request.getUsername());

            return ResponseEntity.ok(new JwtAuthResponse(accessToken, refreshToken));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshRequest request) {
        try {
            String username = refreshTokenService.validateRefreshToken(request.getRefreshToken());
            String accessToken = jwtTokenUtil.generateToken(username);
            return ResponseEntity.ok(new JwtAuthResponse(accessToken, request.getRefreshToken()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }
    }
}
