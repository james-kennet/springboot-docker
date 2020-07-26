package com.app.person.dto.exception;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable t) {
        super(t);
    }
}
