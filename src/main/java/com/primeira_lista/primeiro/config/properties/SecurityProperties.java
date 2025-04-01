package com.primeira_lista.primeiro.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.security")
public class SecurityProperties {
        /**
     * Client default
     */
    private String clientDefault;

    /**
     * Para o client credentials
     */
    private String clientCredentials;

    /**
     * Allowed origin patterns
     */
    private String[] allowedOriginPatterns;

    public String[] getAllowedOriginPatterns() {
        return allowedOriginPatterns;
    }

    public void setAllowedOriginPatterns(String[] allowedOriginPatterns) {
        this.allowedOriginPatterns = allowedOriginPatterns;
    }

    public String getClientDefault() {
        return clientDefault;
    }

    public void setClientDefault(String clientDefault) {
        this.clientDefault = clientDefault;
    }

    public String getClientCredentials() {
        return clientCredentials;
    }

    public void setClientCredentials(String clientCredentials) {
        this.clientCredentials = clientCredentials;
    }
}
