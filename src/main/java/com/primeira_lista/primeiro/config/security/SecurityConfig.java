package com.primeira_lista.primeiro.config.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.primeira_lista.primeiro.config.properties.SecurityProperties;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SecurityConfig {
    private final SecurityProperties securityProperties;
    @Bean
     CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration
                .setAllowedOriginPatterns(List.of(securityProperties.getAllowedOriginPatterns()));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type",
                "Content-Type", "Access-Control-Allow-Headers", "access-control-allow-origin"));
        configuration
                .setExposedHeaders(Arrays.asList("X-Get-Header", "Access-Control-Allow-Methods"));
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
