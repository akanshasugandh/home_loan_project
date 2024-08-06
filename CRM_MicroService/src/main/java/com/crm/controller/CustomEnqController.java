package com.crm.controller;
import com.crm.CustomeException.AddharCardNumberNotFoundException;
import com.crm.CustomeException.EmailIdNotFoundException;
import com.crm.CustomeException.InvalidAgeException;
import com.crm.CustomeException.LastNameNotFoundExcep;
import com.crm.CustomeException.NameNotFoundException;
import com.crm.CustomeException.PancardNotExistException;
import com.crm.CustomeException.PhonenoNotExistException;
import com.crm.model.CustomerEnquiry;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.servicei.CustomerEnquiryServiceI;

import com.crm.model.EmailDetails;
import com.crm.servicei.EmailServiceI;


@RestController
public class CustomEnqController {

private static Logger log=LoggerFactory.getLogger(CustomEnqController.class);
	

	@Autowired private CustomerEnquiryServiceI servicei;
	
	@Autowired private EmailServiceI emailservicei;
	
	
	@PostMapping("/saveEnquiryDetails")
	public ResponseEntity<String> saveEnquiryDetails(@RequestBody CustomerEnquiry ce)
	{
		ce.setCustomerEnquiryDate(new Date());
		ce.setCustomerEnquiryTime(new Time(System.currentTimeMillis()));
		servicei.saveEnquiry(ce);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(ce.getEmailId());
		emailservicei.sendEmail(ed);
		log.info("info()....save Enquiry Details....");
		String str="Enquiry details saved successfully!";
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEnquiry")
	public List<CustomerEnquiry> getCustomerEnquiry()
	{

		log.info("info()...getAllEnquiry().........");
		List<CustomerEnquiry> al=servicei.getCustomerEnquiry(); 

		
		return al;
	}
	@GetMapping("/getById/{customerEnquiryId}")
	public CustomerEnquiry getById(@PathVariable int customerEnquiryId)
	{
		CustomerEnquiry ce=servicei.getByCuId(customerEnquiryId);
		log.info("info().....get All ID Enquiry()....");
		return ce;
	}

	
	@GetMapping("/getByCustomName/{firstName}")
	public CustomerEnquiry findByName(@PathVariable String firstName)
	{
		System.out.println("This is GetByCustomerName Method...");
		log.info("info().....get All Name Enquiry()....");
		log.error("error().....Name Not Found....");
		try
		{
				String s="^([A-Z][A-Z0-9]([A-Z0-9]+)$";
		}
		catch(NameNotFoundException nm)
		{
			log.error(nm.getMessage());
		}
		CustomerEnquiry  ce2=servicei.findByName(firstName);
		return ce2;
	}
	
	@GetMapping("/getByCustomLastName/{lastName}")
	public CustomerEnquiry findByLastName(@PathVariable String lastName)
	{
		System.out.println("This is GetByCustomerLastName Method...");
		log.info("info().....get Enquiry By Last Name()....");
		log.error("error().....Last Name Not Found....");
		try
		{
				String s="^([A-Z][A-Z0-9]([A-Z0-9]+)$";
		}
		catch(LastNameNotFoundExcep lnm)
		{
			log.error(lnm.getMessage());
		}
		CustomerEnquiry  ce2=servicei.findByLastName(lastName);
		return ce2;
	}
	
	@GetMapping("/getByCustomAge/{age}")
	public List<CustomerEnquiry> findByAge(@PathVariable int age)
	{
		
		log.info("info().....get Customer Age()....");
		log.error("error().....Age Not Found....");
		try
		{
				String s="^(65|[1-9][7-9][0-9]?)$";
		}
		catch(InvalidAgeException ag)
		{
			log.error(ag.getMessage());
		}
		List<CustomerEnquiry>  ce3=servicei.findByAge(age);
		return ce3;
	}
	
	@GetMapping("/getByEmailId/{emailId}")
	public CustomerEnquiry getByEmailId(@PathVariable String emailId)
	{
		log.info("info().....get Customer Email-Id()....");
		log.error("error().....Customer Email-Id Not Found....");
		try
		{
				String s="^[a-zA-Z0-9. _%+-]+@[a-zA-Z0-9.";
		}
		catch(EmailIdNotFoundException ag)
		{
			log.error(ag.getMessage());
		}
		CustomerEnquiry ce=servicei.getByCusEmailId(emailId);
		return ce;
	}
	
	@GetMapping("/getCustByContact/{contactNumber}")
	public CustomerEnquiry getCustByContact(@PathVariable long contactNumber)
	{
		log.info("info().....get Customer Contact()....");
		log.error("error().....Customer Contact Not Found....");
		try
		{
				String s="[0-9]+";
		}
		catch(PhonenoNotExistException ag)
		{
			log.error(ag.getMessage());
		}
		CustomerEnquiry ce = servicei.getCustByContact(contactNumber);
		return ce;
	}
	
	@GetMapping("/getCustByPancard/{pancardNumber}")
	public CustomerEnquiry getCustByPancard(@PathVariable String pancardNumber)
	{
		log.info("info().....get Customer Pancard()....");
		log.error("error().....Customer PanCard Not Found....");
		try
		{
				String s="[A-Z]{5}[0-9]{4}[A-Z]{1}";
		}
		catch(PancardNotExistException ag)
		{
			log.error(ag.getMessage());
		}
		CustomerEnquiry ce = servicei.getCustByPancard(pancardNumber);
		return ce;
	}
	@GetMapping("/CustomerEnquiry/{address}")
	public List<CustomerEnquiry> getCustomerEnquiryByAddress(@PathVariable ("address") String address)
	{
		List<CustomerEnquiry> clist=     servicei.getCustomerEnquiryByAddress(address);
		log.info("info().....Customer Enquiry Address()....");
		return clist;
	}
	@GetMapping("/getAllByCibilStatus/{cibilStatus}")
	public ResponseEntity<List<CustomerEnquiry>> getAllByCibilStatus(@PathVariable String cibilStatus)
	{
		List<CustomerEnquiry> cusList=servicei.getAllByCusCibilStatus(cibilStatus);
		log.info("info().....get Cibil Status()....");
		return new ResponseEntity<List<CustomerEnquiry>>(cusList, HttpStatus.OK);
	}
	
	@GetMapping("/getAllByLoanStatus/{loanStatus}")
	public ResponseEntity<List<CustomerEnquiry>> getAllByLoanStatus(@PathVariable String loanStatus)
	{
		List<CustomerEnquiry> cusList=servicei.getAllByCusLoanStatus(loanStatus);
		log.info("info().....get Loan Status()....");
		return new ResponseEntity<List<CustomerEnquiry>>(cusList, HttpStatus.OK);
	}
	
	@GetMapping("/CustomerEnquiryAadhar/{aadharCardNumber}")
	public CustomerEnquiry getCustomerEnquiryByAadharCardNumber(@PathVariable ("aadharCardNumber")String aadharCardNumber) 
	{
		log.info("info().....get Customer Aadhar()....");
		log.error("error().....Customer Aadhar Not Found....");
		try
		{
			String s="^(12|[1-9][7-9][0-9]?)$";
		}
		catch(AddharCardNumberNotFoundException ag)
		{
			log.error(ag.getMessage());
		}
		 
		CustomerEnquiry c=servicei.getCusEnqByAadharCardNumber(aadharCardNumber);
		      
		              return  c;
	   }
		
	
	
	@DeleteMapping("/deleteCustomerEnquiryById/{customerEnquiryId}")
	public String deleteByCustomerEnquiryByID(@PathVariable("customerEnquiryId")int customerEnquiryId) 
	{
        servicei.deleteCustomerEnquiryById(customerEnquiryId);
        log.info("info().....delete Customer Enquiry By Id()....");
		return "Customer Enquiry Deleted Successfully....!!1";
	}

	
	@PutMapping("/updateDetails/{customerEnquiryId}")
	public ResponseEntity<String> updateAllDetails(@PathVariable int customerEnquiryId,@RequestBody CustomerEnquiry ce)
	{
	    CustomerEnquiry cust  = servicei.getByCuId(customerEnquiryId);
	    cust.setFirstName(ce.getFirstName());
	    cust.setLastName(ce.getLastName());
	    cust.setAge(ce.getAge());
	    cust.setGender(ce.getGender());
	    cust.setContactNumber(ce.getContactNumber());
	    cust.setEmailId(ce.getEmailId());
	    cust.setAadharCardNumber(ce.getAadharCardNumber());
	    cust.setPancardNumber(ce.getPancardNumber());
	    cust.setAddress(ce.getAddress());
	    cust.setCibilScore(ce.getCibilScore());
	    cust.setCibilStatus(ce.getCibilStatus());
	    cust.setLoanStatus(ce.getLoanStatus());
	    servicei.saveEnquiry(cust);
	    log.info("info().....update Details()....");
		return new ResponseEntity<String> ("Customer Details Updated.....",HttpStatus.OK);
	}
	

}
