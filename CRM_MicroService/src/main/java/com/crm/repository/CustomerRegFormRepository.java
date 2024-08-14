package com.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crm.model.CustomerRegForm;

@Repository
public interface CustomerRegFormRepository extends JpaRepository<CustomerRegForm, Integer> 
{
	@Query(name = "findByName", value = "from CustomerRegForm where firstName=?1")
	public Optional<CustomerRegForm> findByName(String firstName);
	
	@Query(name = "findByEmailId", value = "from CustomerRegForm where emailId=?1")
	public Optional<CustomerRegForm> findByEmailId(String emailId);

	@Query(name = "findByPassword", value = "from CustomerRegForm where password=?1")
	public Optional<CustomerRegForm> findByPassword(String password);

	@Query(name = "findByAadharNum", value = "from CustomerRegForm where aadharCardNumber=?1")
	public Optional<CustomerRegForm> findByAadharNum(String aadharCardNumber);

	@Query(name = "findByPancardNum", value = "from CustomerRegForm where pancardNumber=?1")
	public Optional<CustomerRegForm> findByPancardNum(String pancardNumber);

	
}
