package com.microservice.tokentest.security.data;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class AuthenticationResponse {
    private String jwt;
}
