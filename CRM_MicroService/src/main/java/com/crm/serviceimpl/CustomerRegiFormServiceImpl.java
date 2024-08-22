package com.crm.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.CustomeException.CustomerNotFoundException;
import com.crm.model.CustomerRegForm;
import com.crm.repository.CustomerRegFormRepository;
import com.crm.servicei.CustomerRegiFormServiceI;

@Service
public class CustomerRegiFormServiceImpl implements CustomerRegiFormServiceI
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

	
	@Override
	public List<CustomerRegForm> getFirstNameAsc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s1.getFirstName().compareTo(s2.getFirstName())).toList();
	}

	@Override
	public List<CustomerRegForm> getLastNameAsc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s1.getLastName().compareTo(s2.getLastName())).toList();
	}	
	
	@Override
	public List<CustomerRegForm> getAgeByAsc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2)->(int)s1.getAge()-(int)s2.getAge()).toList();	
	}

	@Override
	public List<CustomerRegForm> getcontactNumberByAsc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2)->(int)s1.getContactNumber()- (int)s2.getContactNumber()).toList();
	}

	@Override
	public List<CustomerRegForm> getEmailIdByAsc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s1.getEmailId().compareTo(s2.getEmailId())).toList();
	}

	@Override
	public List<CustomerRegForm> getaadharCardNumberByAsc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s1.getAadharCardNumber().compareTo(s2.getAadharCardNumber())).toList();
	}

	@Override
	public List<CustomerRegForm> getPancardNumberByAsc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s1.getPancardNumber().compareTo(s2.getPancardNumber())).toList();
	}
	
	@Override()
	public List<CustomerRegForm> getFirstNameDesc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s2.getFirstName().compareTo(s1.getFirstName())).toList();
	}

	@Override
	public List<CustomerRegForm> getLastNameDesc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s2.getLastName().compareTo(s1.getLastName())).toList();
	}

	@Override
	public List<CustomerRegForm> getAgeByDesc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2)->(int)s2.getAge()-(int)s1.getAge()).toList();		
	}

	@Override
	public List<CustomerRegForm> getcontactNumberByDesc() 
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2)->(int)s2.getContactNumber()-(int)s1.getContactNumber()).toList();	
	}
	
	@Override
	public List<CustomerRegForm> getEmailIdByDesc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s2.getEmailId().compareTo(s1.getEmailId())).toList();
	}

	@Override
	public List<CustomerRegForm> getaadharCardNumberByDesc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s2.getAadharCardNumber().compareTo(s1.getAadharCardNumber())).toList();
	}

	@Override
	public List<CustomerRegForm> getPancardNumberByDesc()
	{
		List<CustomerRegForm> lt = repository.findAll();
		return lt.stream().sorted((s1,s2) -> s2.getPancardNumber().compareTo(s1.getPancardNumber())).toList();
	}
	
}
