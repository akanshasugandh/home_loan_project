package com.crm.controller;

import com.crm.model.CustomerEnquiry;

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
		
		String str="Enquiry details saved successfully!";

		servicei.saveEnquiry(ce);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(ce.getEmailId());
		emailservicei.sendEmail(ed);
		
		log.info("info()....save Enquiry Details....");
		log.warn("warn().....save Enquiry Details....");
		log.error("error().....save Enquiry Details....");
		log.debug("debug().....save Enquiry Details....");
		log.trace("trace().....save Enquiry Details....");
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEnquiry")
	public List<CustomerEnquiry> getCustomerEnquiry()
	{

		log.info("info()...getAllEnquiry().........");
		log.warn("warn()..getAllEnquiry().........");
		log.error("error()...getAllEnquiry().....");
		log.debug("debug()...getAllEnquiry().....");
		log.trace("trace()...getAllEnquiry().....");
		List<CustomerEnquiry> al=servicei.getCustomerEnquiry(); 

		
		return al;
	}
	@GetMapping("/getById/{customerEnquiryId}")
	public CustomerEnquiry getById(@PathVariable int customerEnquiryId)
	{
		CustomerEnquiry ce=servicei.getByCuId(customerEnquiryId);
		log.info("info().....get All ID Enquiry()....");
		log.warn("warn().....get All ID Enquiry()....");
		log.error("error().....get All ID Enquiry()....");
		log.debug("debug().....get All ID Enquiry()....");
		log.trace("trace().....get All ID Enquiry()....");
		return ce;
	}

	
	@GetMapping("/getByCustomName/{firstName}")
	public CustomerEnquiry findByName(@PathVariable String firstName)
	{
		System.out.println("This is GetByCustomerName Method...");
		log.info("info().....get All Name Enquiry()....");
		log.warn("warn().....get All Name Enquiry()....");
		log.error("error().....get All Name Enquiry()...");
		log.debug("debug().....get All Name Enquiry()....");
		log.trace("trace().....get All Name Enquiry()...");
		
		CustomerEnquiry  ce2=servicei.findByName(firstName);
		return ce2;
	}
	
	@GetMapping("/getByCustomLastName/{lastName}")
	public CustomerEnquiry findByLastName(@PathVariable String lastName)
	{
		System.out.println("This is GetByCustomerLastName Method...");
		log.info("info().....get Enquiry By Last Name()....");
		log.warn("warn()......get Enquiry By Last Name()....");
		log.error("error()......get Enquiry By Last Name()...");
		log.debug("debug()......get Enquiry By Last Name()....");
		log.trace("trace()......get Enquiry By Last Name().....");
		
		CustomerEnquiry  ce2=servicei.findByLastName(lastName);
		return ce2;
	}
	
	@GetMapping("/getByCustomAge/{age}")
	public List<CustomerEnquiry> findByAge(@PathVariable int age)
	{
		List<CustomerEnquiry>  ce3=servicei.findByAge(age);
		return ce3;
	}
	
	@DeleteMapping("/deleteCustomerEnquiryById/{customerEnquiryId}")
	public String deleteByCustomerEnquiryByID(@PathVariable("customerEnquiryId")int customerEnquiryId) 
	{
        servicei.deleteCustomerEnquiryById(customerEnquiryId);
        log.info("info().....delete Customer Enquiry By Id()....");
		log.warn("warn().....delete Customer Enquiry By Id()....");
		log.error("error().....delete Customer Enquiry By Id()....");
		log.debug("debug().....delete Customer Enquiry By Id....");
		log.trace("trace().....delete Customer Enquiry By Id....");
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
		log.warn("warn().....update Details()....");
		log.error("error().....update Details()....");
		log.debug("debug().....update Details()....");
		log.trace("trace().....update Details()....");
		return new ResponseEntity<String> ("Customer Details Updated.....",HttpStatus.OK);
	}

}
