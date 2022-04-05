package com.microservice.tokentest.service;

import com.microservice.tokentest.data.UserEntity;
import com.microservice.tokentest.model.UserEntityDto;
import com.microservice.tokentest.model.UserEntityRepo;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    @Autowired
    UserEntityRepo repo;

    @Autowired
    PasswordEncoder encoder;

    public UserEntityDto save(UserEntityDto userEntityDto) {
        userEntityDto.setPassword(encoder.encode(userEntityDto.getPassword()));
        return new UserEntityDto(repo.save(new UserEntity(userEntityDto)));
    }

}
