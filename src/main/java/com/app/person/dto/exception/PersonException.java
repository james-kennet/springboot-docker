package com.app.person.dto.exception;

public class PersonException extends RuntimeException {
    public PersonException(String message) {
        super(message);
    }
    public PersonException(Throwable t) {
        super(t);
    }
}
