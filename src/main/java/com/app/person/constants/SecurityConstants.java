package com.app.person.constants;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/generateToken";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "Web-singpass-service";
    public static final String TOKEN_AUDIENCE = "Pru-secure-app";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
