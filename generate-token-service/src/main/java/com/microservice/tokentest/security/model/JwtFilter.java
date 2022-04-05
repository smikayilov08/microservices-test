package com.microservice.tokentest.security.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JwtFilter {
    @Autowired
    private JwtUtil jwtUtil;

    public Boolean checkToken(String header) {
        String name ;
        String jwt;

        if (header != null && header.startsWith("Bearer ")) {
            jwt = header.substring(7);

                name = jwtUtil.extractUserName(jwt);

           return jwtUtil.validateToken(jwt, name);

        }
        return false;
    }
}
