package com.microservice.tokentest.controller;

import com.microservice.tokentest.service.CheckTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    private CheckTokenService checkTokenService;

    @GetMapping("/check-token")
    public ResponseEntity<?> checkToken(@RequestHeader("Authorization") String token){
        return new ResponseEntity<>(checkTokenService.checkToken(token), HttpStatus.ACCEPTED);
    }
}
