package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.model.CustomerEnquiry;
import com.crm.servicei.CustomerEnquiryServiceI;


@RestController
public class CustomerEnquiryController
{
	@Autowired private CustomerEnquiryServiceI servicei;
	
	@PostMapping("/saveEnquiryDetails")
	public ResponseEntity<String> saveEnquiryDetails(@RequestBody CustomerEnquiry ce)
	{
		String str="Enquiry details saved successfully!";
		servicei.saveEnquiry(ce);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEnquiry")
	public List<CustomerEnquiry> getCustomerEnquiry()
	{
		List<CustomerEnquiry> al=servicei.getCustomerEnquiry(); 
		return al;
	}
	@GetMapping("/getById/{customerEnquiryId}")
	public CustomerEnquiry getById(@PathVariable int customerEnquiryId)
	{
		CustomerEnquiry ce=servicei.getByCuId(customerEnquiryId);
		return ce;
	}

}
