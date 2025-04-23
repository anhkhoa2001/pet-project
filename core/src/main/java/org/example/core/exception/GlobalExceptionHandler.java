package org.example.core.exception;

import org.example.core.dto.ResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseBase<?> handleException(Exception e) {
        e.printStackTrace();

        return new ResponseBase<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
