package com.microservice.tokentest.controller;

import com.microservice.tokentest.security.data.AuthenticationRequest;
import com.microservice.tokentest.security.data.AuthenticationResponse;
import com.microservice.tokentest.security.model.JwtUtil;
import com.microservice.tokentest.service.CheckTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;

@RestController
public class Login {
    @Autowired
    AuthenticationManager manager;

    @Autowired
    UserDetailsService service;

    @Autowired
    JwtUtil jwtUtil;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private CheckTokenService checkTokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        }catch (AuthenticationException e){
            throw new UsernameNotFoundException("User not Found");
        }
        final UserDetails user = service.loadUserByUsername(request.getUserName());

        final String jwt = jwtUtil.createToken(user);
        
            //sending token to buyer-service
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        AuthenticationResponse data = new AuthenticationResponse(jwt);
//
//        HttpEntity<?> entity = new HttpEntity<Object>(data, headers);
//        ResponseEntity<Object> responseEntity =
//                responseEntity = restTemplate.exchange("http://customer-token-service/token", HttpMethod.POST, entity, Object.class);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/check-token")
    public ResponseEntity<?> checkToken(@RequestHeader("Authorization") String token){
        return new ResponseEntity<>(checkTokenService.checkToken(token),HttpStatus.ACCEPTED);
    }
}
