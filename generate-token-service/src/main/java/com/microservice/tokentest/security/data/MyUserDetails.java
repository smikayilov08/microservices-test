package com.microservice.tokentest.security.data;

import com.microservice.tokentest.data.Employees;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
public class MyUserDetails implements UserDetails {
    private Employees request;
    List<SimpleGrantedAuthority> authorities;

    public MyUserDetails(Employees request) {
        this.request = request;
        authorities = Arrays.asList(request.getEmpRole().split(""))
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return request.getEmpPassword();
    }

    @Override
    public String getUsername() {
        return request.getEmpName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
