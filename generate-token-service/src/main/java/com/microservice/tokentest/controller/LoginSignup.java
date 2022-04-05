package com.microservice.tokentest.controller;

import com.microservice.tokentest.model.UserEntityDto;
import com.microservice.tokentest.security.data.AuthenticationRequest;
import com.microservice.tokentest.security.data.AuthenticationResponse;
import com.microservice.tokentest.security.model.JwtUtil;
import com.microservice.tokentest.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1")
public class LoginSignup {
    @Autowired
    AuthenticationManager manager;

    @Autowired
    UserDetailsService service;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        }catch (AuthenticationException e){
            throw new UsernameNotFoundException("User not Found");
        }
        final UserDetails user = service.loadUserByUsername(request.getUserName());

        final String jwt = jwtUtil.createToken(user);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public UserEntityDto addEmp(@RequestBody UserEntityDto userEntityDto){
        return userService.save(userEntityDto);
    }
}