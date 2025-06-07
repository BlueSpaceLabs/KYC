package org.techdisqus.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("testuser")
                .password(passwordEncoder().encode("testpass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> {})
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for APIs
                .authorizeHttpRequests(authorize -> authorize
                        // Permit all actuator health and info endpoints without authentication
                        .requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll()
                        // Permit actuator endpoints (you can restrict these too)
                        .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                        // Permit validateAccount and other public endpoints
                        .requestMatchers("/v1/ekyc/validateAccount", "/health", "/status","/api/auth/**")
                        .permitAll()
                        // All other endpoints require authentication
                        .anyRequest().authenticated()
                )
                // Add your JWT/UUID filter before UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("https://sim.webthoughts.in");
        config.addAllowedOriginPattern("https://kyc.bluwyre.ai");
        config.addAllowedOriginPattern("http://localhost:3000");
        config.addAllowedOriginPattern("https://*.ngrok-free.app");
        //config.addAllowedOriginPattern("*");

        config.addAllowedHeader("*");
        config.addExposedHeader(HttpHeaders.AUTHORIZATION);
        config.addExposedHeader("x-requestInformation");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

   /* @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // allow all paths
                        .allowedOriginPatterns(
                                "https://sim.webthoughts.in",
                                "http://localhost:3000",
                                "https://2f78-223-233-81-32.ngrok-free.app"
                        )
                        .exposedHeaders(HttpHeaders.AUTHORIZATION)
                        .allowedMethods("*") // allow all HTTP methods
                        .allowedHeaders("*") // allow all headers
                        .allowCredentials(true); // or true if needed
            }
        };
    }*/

}
