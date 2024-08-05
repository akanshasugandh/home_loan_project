package com.oe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oe.model.CustomerEnquiry;

@Repository
public interface CustomerEnquiryRepository extends JpaRepository<CustomerEnquiry, Integer> {

}
