package com.microservice.tokentest.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TokenCotrollerException {
    HttpStatus status = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<Object> signature() {

        ApiException apiException = new ApiException(
                "Token is invalid",
                status,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(apiException, status);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> time() {

        ApiException apiException = new ApiException(
                "Token is expired",
                status,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(apiException, status);
    }
}
