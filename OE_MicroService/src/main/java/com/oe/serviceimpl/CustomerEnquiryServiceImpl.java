package com.oe.serviceimpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.oe.model.CustomerEnquiry;
import com.oe.repository.CustomerEnquiryRepository;
import com.oe.servicei.CustomerEnquiryServiceI;

@Service
public class CustomerEnquiryServiceImpl implements CustomerEnquiryServiceI 
{
	@Autowired private CustomerEnquiryRepository repository;
	@Override
	public CustomerEnquiry calculateCibilScore(int customerEnquiryId) {
CustomerEnquiry custome=repository.findById(customerEnquiryId).orElseThrow(()->new RuntimeException("Customer Not Found"));
		
		Random r=new Random();
		int cibilScore=r.nextInt(900-300)+300;
		custome.setCibilScore(cibilScore);
		custome.setCibilStatus(cibilScore>=650 ? "Good ": "Poor");
		custome.setLoanStatus(cibilScore>=650 ? "Cibil_Approved" : "Cibil_Rejected");
		return repository.save(custome);
	}

	}


