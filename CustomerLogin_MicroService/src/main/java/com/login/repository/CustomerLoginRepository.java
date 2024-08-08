package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.CustomerLogin;

@Repository
public interface CustomerLoginRepository extends JpaRepository<CustomerLogin, Integer> {

}
