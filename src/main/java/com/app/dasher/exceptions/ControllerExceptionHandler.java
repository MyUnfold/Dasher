package com.app.dasher.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Paly
 * @version 1.0
 * @date 02/09/22 6:39 PM
 * @company Automicle
 */

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, NullPointerException.class, IllegalStateException.class, ObjectNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        ApiError apiError = null;
//        switch (ex) {
////          case IllegalStateException illegalStateException -> new ApiError(HttpStatus.CONFLICT,
////              illegalStateException.getMessage(), illegalStateException.getMessage());
////          case ObjectNotFoundException objectNotFoundException -> new ApiError(HttpStatus.NOT_FOUND,
////              objectNotFoundException.getMessage(), objectNotFoundException.getMessage());
//          default -> new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getMessage());
//        };

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }
}