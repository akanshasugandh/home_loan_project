package com.crm.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.CustomeException.EnquiryNotFoundException;
import com.crm.CustomeException.InvalidAgeException;
import com.crm.CustomeException.NameNotFoundException;
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

	@Override
	public List<CustomerEnquiry> getCustomerEnquiry() 
	{
		List<CustomerEnquiry> al=repository.findAll();
		return al;
	}
	
	@Override
	public CustomerEnquiry getByCuId(int customerEnquiryId) 
	{
		Optional<CustomerEnquiry> ce = repository.findById(customerEnquiryId);
		if(ce.isPresent())
		{
			return ce.get();
		}
		else
		{
      throw new EnquiryNotFoundException("Enquiry Not found For  This Id");
		}
	}
	@Override
	public CustomerEnquiry findByName(String firstName) 
	{
		
	return repository.findByFirstName(firstName).orElseThrow(()->new NameNotFoundException("Name Not Found:"
				+firstName ));
	}
	@Override
	public List<CustomerEnquiry> findByAge(int age) 
	{
		if(age<=18|| age>= 65)
		{
			throw new InvalidAgeException("Age is not Valid....");
		}
		
		return repository.findByAge(age);
	}

	@Override
	public void deleteCustomerEnquiryById(int customerEnquiryId)
	{
		   repository.deleteById(customerEnquiryId);		
	}


	

	
	

	
	
	}
