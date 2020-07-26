package com.app.person.dto.exception;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
    public TokenException(Throwable t) {
        super(t);
    }
}
