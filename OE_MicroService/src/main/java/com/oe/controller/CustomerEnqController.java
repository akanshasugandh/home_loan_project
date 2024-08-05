package com.oe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oe.model.CustomerEnquiry;
import com.oe.servicei.CustomerEnquiryServiceI;
import com.oe.servicei.EmailServiceI;

@RestController
public class CustomerEnqController 
{
	private static Logger log= LoggerFactory.getLogger(CustomerEnqController.class);
	@Autowired private CustomerEnquiryServiceI servicei;
	
	@Autowired private EmailServiceI emailservicei;
	
	@GetMapping("/generateCibilSc/{customerEnquiryId}")
	public CustomerEnquiry calculateCibilScore(@PathVariable int customerEnquiryId)
	{
		return servicei.calculateCibilScore(customerEnquiryId);
	}

}
