package org.techdisqus.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.techdisqus.util.JwtTokenUtil;

import java.io.IOException;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String requestInformation = request.getHeader("x-requestInformation");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                String username = jwtTokenUtil.validateTokenAndGetSubject(token, requestInformation);
                var authorities = List.of(new SimpleGrantedAuthority("ROLE_USER")); // or ROLE_ADMIN based on your logic
                var authToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authToken);
                String newToken = jwtTokenUtil.generateToken(username);
                response.setHeader(HttpHeaders.AUTHORIZATION,newToken);
                // You can put username into SecurityContextHolder if needed
                MDC.put("username", username); // optional: to include in logs
            } catch (Exception ex) {
                logger.error("Invalid JWT Token: {}", ex);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }/*else {
            var authorities = List.of(new SimpleGrantedAuthority("ROLE_USER")); // or ROLE_ADMIN based on your logic
            var authToken = new UsernamePasswordAuthenticationToken("username", null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authToken);

        }*/

        filterChain.doFilter(request, response);
    }
}

