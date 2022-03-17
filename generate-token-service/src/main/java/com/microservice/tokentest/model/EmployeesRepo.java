package com.microservice.tokentest.model;

import com.microservice.tokentest.data.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepo extends CrudRepository<Employees,Integer> {
    Optional<Employees> findByEmpName(String userName);
}
