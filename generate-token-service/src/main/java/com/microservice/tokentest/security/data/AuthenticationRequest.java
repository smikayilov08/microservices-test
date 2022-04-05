package com.microservice.tokentest.security.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
     String userName;
     String password;
}
