package com.crm.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.CustomeException.AddharCardNumberNotFoundException;
import com.crm.CustomeException.CibilStatusNotFoundException;
import com.crm.CustomeException.EnquiryNotFoundException;
import com.crm.CustomeException.LoanStatusNotFoundException;
import com.crm.CustomeException.PancardNotExistException;
import com.crm.CustomeException.PhonenoNotExistException;
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
		
	return repository.findByFirstName(firstName).orElseThrow(()->new EnquiryNotFoundException("Name Not Found:"
				+firstName ));
	}
	@Override
	public CustomerEnquiry findByLastName(String lastName) {
		return repository.findByLastName(lastName).orElseThrow(()->new EnquiryNotFoundException("Last Name Not Found:"
				+lastName ));
	}

	@Override
	public List<CustomerEnquiry> findByAge(int age) 
	{
		if(age<=18|| age>= 65)
		{
			throw new EnquiryNotFoundException("Age is not Valid....");
		}
		
		return repository.findByAge(age);
	}

	@Override
	public void deleteCustomerEnquiryById(int customerEnquiryId)
	{
		   repository.deleteById(customerEnquiryId);		
	}
	
	@Override
	public CustomerEnquiry getByCusEmailId(String emailId) 
	{
		Optional<CustomerEnquiry> ceOp=repository.findByEmailId(emailId);
		
		if(ceOp.isPresent())
		{
			CustomerEnquiry ce=ceOp.get();
			return ce;
		}
		else
		{
			throw new EnquiryNotFoundException("Customer with this emailId not found");
		}
	}

	@Override
	public List<CustomerEnquiry> getAllByCusCibilStatus(String cibilStatus) 
	{
		List<CustomerEnquiry> cusList=repository.findAllByCibilStatus(cibilStatus);
		
		if(cibilStatus.equalsIgnoreCase("CIBIL_pending")||cibilStatus.equalsIgnoreCase("good")||cibilStatus.equalsIgnoreCase("poor"))
		{
			return cusList;
		}
		else
		{
			throw new CibilStatusNotFoundException("Invalid CIBIL status");
		}
	}

	@Override
	public List<CustomerEnquiry> getAllByCusLoanStatus(String loanStatus) 
	{
		List<CustomerEnquiry> cusList=repository.findAllByLoanStatus(loanStatus);
		
		if(loanStatus.equalsIgnoreCase("Loan_pending")||loanStatus.equalsIgnoreCase("fwdToOE")||loanStatus.equalsIgnoreCase("CIBIL_approved")||loanStatus.equalsIgnoreCase("CIBIL_rejected"))
		{
			return cusList;
		}
		else
		{
			throw new LoanStatusNotFoundException("Invalid Loan status");
		}
	}

	@Override
	public CustomerEnquiry getCustByContact(long contactNumber)
	{
		Optional<CustomerEnquiry> ce = repository.findByContactNo(contactNumber);
		if(ce.isPresent())
		{
			return ce.get();
		}
		else
		{
          throw new PhonenoNotExistException("Invalid Contact Number..");
		}  
	    
	}

	@Override
	public CustomerEnquiry getCustByPancard(String pancardNumber)
	{		
		Optional<CustomerEnquiry> ce = repository.findByPancardNo(pancardNumber);
		if(ce.isPresent())
		{
			return ce.get();
		}
		else
		{
		    throw new PancardNotExistException("Invalid Pancard Number..");
		}  				
	}

	public List< CustomerEnquiry> getCustomerEnquiryByAddress(String address) {
    List<CustomerEnquiry> clist=      repository.getCustomerEnquiryByAdd(address);
          if(clist.isEmpty()) {
        	  throw new EnquiryNotFoundException("CustomerEnquiry is Not Found For this Address");
          }
          return clist;
          
	}
	@Override
	public CustomerEnquiry getCusEnqByAadharCardNumber(String aadharCardNumber) {
		  Optional<CustomerEnquiry>ce=  repository.getEnquiryByAadhar(aadharCardNumber);
	if(ce.isPresent()) {
           return ce.get();
	}
	
	else {		
	throw new AddharCardNumberNotFoundException("Enquiry is Not Found for This AddharCardNumber");
	}
	
	}
	


	
	
}
