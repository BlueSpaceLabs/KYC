package org.techdisqus.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenUtil {

    @Autowired
    private EncryptionUtil encryptionUtil;

    private static final long EXPIRATION_TIME = 86400000; // 1 day in ms
    private static final String SECRET = "y9V@8!ze#4T$gYf2kLd^0eMvR%qXN&Ap\n"; // at least 32 characters
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String subject) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(subject)
                .setIssuer("kyc-resp-app")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Duration.ofHours(1).toMillis())) // 1 hour
                .signWith(key, SignatureAlgorithm.HS256) // pass SecretKey directly
                .compact();
    }

    public String validateTokenAndGetSubject(String token, String requestInformation) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY) // SecretKey again
                .build()
                .parseClaimsJws(token).getBody();
        log.info("accountIdentifier {} sessionId {} requestId {}", claims.getSubject(), claims.get("sessionId"),
                claims.get("requestId"));

        String str = encryptionUtil.decrypt(requestInformation);

        if (claims.getExpiration().before(new Date())) {
            throw new RuntimeException("Token is expired");
        }

        Map<String,String> map;

        try {
             map = new ObjectMapper().readValue(str, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize decrypted userData", e);
        }


        if(map.containsKey("msisdn")) {
            String msisdn = map.get("msisdn");

            if(!claims.getSubject().equals(msisdn)){
                throw new RuntimeException("Invalid subject in token");
            }
        }

        if (!"kyc-resp-app".equals(claims.getIssuer())) {
            throw new RuntimeException("Invalid token issuer");
        }


        return claims.getSubject();



    }
}
