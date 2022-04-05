package com.microservice.tokentest.security.model;

import com.microservice.tokentest.data.UserEntity;
import com.microservice.tokentest.model.UserEntityRepo;
import com.microservice.tokentest.security.data.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityRepo repo;

    @Override
    public UserDetails loadUserByUsername(String userName) {

        Optional<UserEntity> emp=repo.findByUserName(userName);

       emp.orElseThrow(()->new UsernameNotFoundException("User not found"));
       return emp.map(MyUserDetails::new).get();
    }
}
