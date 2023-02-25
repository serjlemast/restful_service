package com.dimitrii.maksymov.user_service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {
    public record Application(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime dateTime) {
    }
    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<Object> handleApplicationException(ApplicationException ex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        Application application = new Application(
                ex.getMessage(),
                ex,
                badRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(application, badRequest);
    }
}
