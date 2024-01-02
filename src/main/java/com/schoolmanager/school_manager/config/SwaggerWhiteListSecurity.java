package com.schoolmanager.school_manager.config;

public class SwaggerWhiteListSecurity {
    public static final String[] AUTH_WHITE_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs/**",
            "/swagger-resources/**"
    };
}
