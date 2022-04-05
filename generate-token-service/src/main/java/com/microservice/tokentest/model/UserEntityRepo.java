package com.microservice.tokentest.model;

import com.microservice.tokentest.data.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepo extends CrudRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUserName(String userName);
}
