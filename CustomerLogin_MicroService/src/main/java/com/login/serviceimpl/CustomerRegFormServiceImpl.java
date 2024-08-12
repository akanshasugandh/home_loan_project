package com.login.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.CustomerRegForm;
import com.login.repository.CustomerRegFormRepository;
import com.login.servicei.CustomerRegFormServiceI;

@Service
public class CustomerRegFormServiceImpl implements CustomerRegFormServiceI
{
	
	@Autowired CustomerRegFormRepository repository;

	@Override
	public void saveRegForm(CustomerRegForm crf) 
	{
		repository.save(crf);
	}

	@Override
	public CustomerRegForm getByRegId(int customerRegId)
	{
		Optional<CustomerRegForm> crfOp=repository.findById(customerRegId);
		CustomerRegForm crf=crfOp.get();
		if(crfOp.isPresent())
		{
			return crf;
		}
		else
		{
			throw new RuntimeException("Customer with this registration id not found");
		}
		
	}

	@Override
	public CustomerRegForm getByCuRegId(int customerRegId) 
	{
		return repository.findById(customerRegId).get();
	}


}
