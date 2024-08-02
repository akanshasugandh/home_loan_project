package com.crm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.model.CustomerEnquiry;
import com.crm.repository.CustomerEnquiryRepository;
import com.crm.servicei.CustomerEnquiryServiceI;

@Service
public class CustomerEnquiryServiceImpl implements CustomerEnquiryServiceI{

	@Autowired private CustomerEnquiryRepository repository;
	
	@Override
	public void saveEnquiry(CustomerEnquiry ce) 
	{
		repository.save(ce);
	}

}
