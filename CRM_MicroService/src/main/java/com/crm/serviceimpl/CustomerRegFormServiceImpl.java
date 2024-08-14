package com.crm.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.CustomeException.CustomerNotFoundException;
import com.crm.model.CustomerRegForm;
import com.crm.repository.CustomerRegFormRepository;
import com.crm.servicei.CustomerRegFormServiceI;

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
		
		if(crfOp.isPresent())
		{
			CustomerRegForm crf=crfOp.get();
			return crf;
		}
		else
		{
			throw new CustomerNotFoundException("Customer with this registration id not found");
		}
		
	}

	@Override
	public CustomerRegForm getByCuRegName(String firstName) {
		Optional<CustomerRegForm> crfOp=repository.findByName(firstName);
		
		if(crfOp.isPresent())
		{
			CustomerRegForm crf=crfOp.get();
			return crf;
		}
		else
		{
			throw new CustomerNotFoundException("Customer with name: "+firstName+" not found");
		}
	}

	@Override
	public CustomerRegForm getByCuRegEmailId(String emailId) {
		Optional<CustomerRegForm> crfOp=repository.findByEmailId(emailId);
		
		if(crfOp.isPresent())
		{
			CustomerRegForm crf=crfOp.get();
			return crf;
		}
		else
		{
			throw new CustomerNotFoundException("Customer with emailId: "+emailId+" not found");
		}
	}

	@Override
	public CustomerRegForm getByCuRegPassword(String password) {
		Optional<CustomerRegForm> crfOp=repository.findByPassword(password);
		
		if(crfOp.isPresent())
		{
			CustomerRegForm crf=crfOp.get();
			return crf;
		}
		else
		{
			throw new CustomerNotFoundException("Customer with password: "+password+" not found");
		}
	}

	@Override
	public CustomerRegForm getByCuRegAadharNum(String aadharCardNumber) {
		Optional<CustomerRegForm> crfOp=repository.findByAadharNum(aadharCardNumber);
		
		if(crfOp.isPresent())
		{
			CustomerRegForm crf=crfOp.get();
			return crf;
		}
		else
		{
			throw new CustomerNotFoundException("Customer with aadharCardNumber: "+aadharCardNumber+" not found");
		}
	}

	@Override
	public CustomerRegForm getByCuRegPancardNum(String pancardNumber) {
		Optional<CustomerRegForm> crfOp=repository.findByPancardNum(pancardNumber);
		
		if(crfOp.isPresent())
		{
			CustomerRegForm crf=crfOp.get();
			return crf;
		}
		else
		{
			throw new CustomerNotFoundException("Customer with pancardNumberr: "+pancardNumber+" not found");
		}
	}

}
