package com.microservice.tokentest.security.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class JwtFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService service;

    public Boolean checkToken(String token) {
        String name = null;
        String jwt = null;
        final String header =token;

        if (header != null && header.startsWith("Bearer ")) {
            jwt = header.substring(7);

                name = jwtUtil.extractUserName(jwt);

           return jwtUtil.validateToken(jwt, name);

        }
        return false;
    }
}
