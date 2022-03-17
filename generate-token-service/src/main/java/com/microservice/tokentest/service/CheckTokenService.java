package com.microservice.tokentest.service;

import com.microservice.tokentest.security.model.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTokenService {

    @Autowired
    private JwtFilter filter;

    public boolean checkToken(String token){
        return  filter.checkToken(token);
    }
}
