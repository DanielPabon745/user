package com.example.users.users.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {
        HttpStatus httpStatus = null;
        switch (ex.getMessage()) {
            case ErrorMessage.NOT_FOUND_MESSAGE:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case ErrorMessage.BAD_REQUEST_MESSAGE:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            default:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), httpStatus, request);
    }
}
