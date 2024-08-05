package com.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crm.model.CustomerEnquiry;

@Repository
public interface CustomerEnquiryRepository extends JpaRepository<CustomerEnquiry, Integer>
{

	Optional<CustomerEnquiry> findByFirstName(String firstName);
	
	Optional<CustomerEnquiry> findByLastName(String lastName);
	
	List<CustomerEnquiry> findByAge(int age);
	
	@Query(name = "findByEmailId", value = "from CustomerEnquiry where emailId=?1")
	public Optional<CustomerEnquiry> findByEmailId(String emailId);

	@Query(name = "findAllByCibilStatus", value = "from CustomerEnquiry where cibilStatus=?1")
	public List<CustomerEnquiry> findAllByCibilStatus(String cibilStatus);

	@Query(name = "findAllByLoanStatus", value = "from CustomerEnquiry where loanStatus=?1")
	public List<CustomerEnquiry> findAllByLoanStatus(String loanStatus);
	



}
