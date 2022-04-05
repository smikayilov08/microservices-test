package com.microservice.tokentest.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class SignUpExceptionController {

    HttpStatus status = HttpStatus.BAD_REQUEST;
    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<Object> time(PSQLException e) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(apiException, status);
    }}
