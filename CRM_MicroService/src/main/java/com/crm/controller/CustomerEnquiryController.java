package com.crm.controller;

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
import com.crm.model.CustomerEnquiry;
import com.crm.servicei.CustomerEnquiryServiceI;

import com.crm.model.EmailDetails;
import com.crm.servicei.EmailServiceI;

@RestController
public class CustomerEnquiryController
{
	private static Logger log= LoggerFactory.getLogger(CustomerEnquiryController.class);
	@Autowired private CustomerEnquiryServiceI servicei;
	
	@Autowired private EmailServiceI emailservicei;
	
	@PostMapping("/saveEnquiryDetails")
	public ResponseEntity<String> saveEnquiryDetails(@RequestBody CustomerEnquiry ce)
	{
		log.info("info()...CustomerEnquiry Saved.....");
		String str="Enquiry details saved successfully!";
		servicei.saveEnquiry(ce);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(ce.getEmailId());
		emailservicei.sendEmail(ed);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEnquiry")
	public List<CustomerEnquiry> getCustomerEnquiry()
	{
		log.info("info()...getAllEnquiry().....");
		log.warn("warn()..getAllEnquiry().....");
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
		return ce;
	}

	@DeleteMapping("/deleteCustomerEnquiryById/{customerEnquiryId}")
	public String deleteByCustomerEnquiryByID(@PathVariable("customerEnquiryId")int customerEnquiryId) {
        servicei.deleteCustomerEnquiryById(customerEnquiryId);
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
		return new ResponseEntity<String> ("Customer Details Updated..",HttpStatus.OK);
	}
	
}
