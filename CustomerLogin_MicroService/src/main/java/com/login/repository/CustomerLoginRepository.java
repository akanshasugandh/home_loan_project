package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.CustomerRegForm;



@Repository
public interface CustomerLoginRepository extends JpaRepository<CustomerRegForm, Integer> 
{
	
	public CustomerRegForm findByEmailIdAndPassword(String emailId, String password);

	public CustomerRegForm findByEmailId(String emailId);

	
}
