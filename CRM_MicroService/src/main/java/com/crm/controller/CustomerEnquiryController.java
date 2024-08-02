package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
