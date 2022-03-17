package com.microservice.tokentest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class LoginControllerException {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> time(UsernameNotFoundException e) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(apiException, status);
    }
}
