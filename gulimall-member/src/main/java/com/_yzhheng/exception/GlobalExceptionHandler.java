package com._yzhheng.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<String> handleUserNameException(UserNameException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // You can add more exception handlers here for other exceptions
}