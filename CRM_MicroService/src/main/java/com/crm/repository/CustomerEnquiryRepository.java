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
	List<CustomerEnquiry> findByAge(int age);



}
