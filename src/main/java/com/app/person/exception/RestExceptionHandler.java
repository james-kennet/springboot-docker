package com.app.person.exception;

import com.app.person.constants.ErrorConstants;
import com.app.person.dto.exception.ServiceException;
import com.app.person.dto.response.ErrorResponse;
import com.app.person.dto.exception.RequestValidationException;
import com.app.person.dto.exception.ErrorObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<Object> serviceErrorHandler(ServiceException e) {
        LOGGER.error("Error detected while processing service method: ", e);
        ErrorObject error = new ErrorObject(BAD_REQUEST, ErrorConstants.ERROR_GENERIC_MESSAGE + " - " + e.getMessage());
        return new ResponseEntity<>(new ErrorResponse(error), error.getStatus());
    }

    @ExceptionHandler(value = RequestValidationException.class)
    public ResponseEntity<Object> validatorErrorHandler(RequestValidationException e) {
        LOGGER.error("Error detected while validating person request: ", e);
        ErrorObject error = new ErrorObject(BAD_REQUEST, ErrorConstants.VALIDATOR_ERROR_COLUMN + " - " + e.getMessage());
        return new ResponseEntity<>(new ErrorResponse(error), error.getStatus());
    }
}
