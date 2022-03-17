package com.microservice.tokentest.security.model;

import com.microservice.tokentest.data.Employees;
import com.microservice.tokentest.model.EmployeesRepo;
import com.microservice.tokentest.security.data.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeesRepo repo;

    @Override
    public UserDetails loadUserByUsername(String userName) {

        Optional<Employees> emp=repo.findByEmpName(userName);

       emp.orElseThrow(()->new UsernameNotFoundException("User not found"));
       return emp.map(MyUserDetails::new).get();
    }
}
