package com.ach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ach.model.CustomerRegForm;

@Repository
public interface CustomerRegFormRepository extends JpaRepository<CustomerRegForm, Integer> 
{

}
