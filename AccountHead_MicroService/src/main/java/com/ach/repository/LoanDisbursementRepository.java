package com.ach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ach.model.CustomerRegForm;
import com.ach.model.LoanDisbursement;

@Repository
public interface LoanDisbursementRepository extends JpaRepository<CustomerRegForm, Integer> {

}
