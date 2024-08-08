package com.oe.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.oe.model.CustomerEnquiry;
import com.oe.model.EmailDetails;
import com.oe.servicei.CustomerEnquiryServiceI;
import com.oe.servicei.EmailServiceI;

@RestController
public class CustomerEnqController 
{
	private static Logger log= LoggerFactory.getLogger(CustomerEnqController.class);
	
	@Autowired private CustomerEnquiryServiceI servicei;
	
	@Autowired private EmailServiceI emailservicei;
	
	@Autowired
	RestTemplate rsTemplate;
	
	@PostMapping("/calulateCibilSc/{customerEnquiryId}")
	public ResponseEntity<CustomerEnquiry >calculateCibilScore(@PathVariable int customerEnquiryId)
	{
			CustomerEnquiry cue=servicei.calculateCibilScore(customerEnquiryId);
			log.info("info()....Customer CIBIL Score is Calculated....");
			EmailDetails ed=new EmailDetails();
			ed.setToEmail(cue.getEmailId());
			emailservicei.sendEmailToCustomer(ed);
			emailservicei.sendEmail(ed);
			return ResponseEntity.ok(cue);
	}
	
	
	@GetMapping("/getAllEnquiry")
	public List<CustomerEnquiry> getCustomerEnquiry()
	{
		String url = "http://localhost:8855/getAllEnquiry";
		List<CustomerEnquiry> list = rsTemplate.getForObject(url, List.class);
		
		List<CustomerEnquiry> allData = new ArrayList();
	    allData.addAll(list);
	    
	    return allData;
	}
	
	@GetMapping("/getById/{customerEnquiryId}")
	public CustomerEnquiry getById(@PathVariable int customerEnquiryId)
	{
		String url = "http://localhost:8855/getById/"+customerEnquiryId;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;
	}
	
	@GetMapping("/getByCustomFirstName/{firstName}")
	public CustomerEnquiry findByName(@PathVariable String firstName)
	{
		String url = "http://localhost:8855/getByCustomName/"+firstName;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;
	}

	@GetMapping("/getByCustomLastName/{lastName}")
	public CustomerEnquiry findByLastName(@PathVariable String lastName)
	{
		String url = "http://localhost:8855/getByCustomLastName/"+lastName;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;
	}
		
	@GetMapping("/getByCustomAge/{age}")
	public List<CustomerEnquiry> findByAge(@PathVariable int age)
	{	
		String url = "http://localhost:8855/getByCustomAge/"+age;
		List<CustomerEnquiry> list = rsTemplate.getForObject(url, List.class);
		
		List<CustomerEnquiry> allData = new ArrayList();
	    allData.addAll(list);
	    
	    return allData;
	}
	
	@GetMapping("/getByEmailId/{emailId}")
	public CustomerEnquiry getByEmailId(@PathVariable String emailId)
	{
		String url = "http://localhost:8855/getByEmailId/"+emailId;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;	
	}
	
	@GetMapping("/getCustByContact/{contactNumber}")
	public CustomerEnquiry getCustByContact(@PathVariable long contactNumber)
	{
		String url = "http://localhost:8855/getCustByContact/"+contactNumber;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;
	}
	
	@GetMapping("/getCustByPancard/{pancardNumber}")
	public CustomerEnquiry getCustByPancard(@PathVariable String pancardNumber)
	{
		String url = "http://localhost:8855/getCustByPancard/"+pancardNumber;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;
	}
	
	@GetMapping("/CustomerEnquiry/{address}")
	public List<CustomerEnquiry> getCustomerEnquiryByAddress(@PathVariable ("address") String address)
	{
		String url = "http://localhost:8855/CustomerEnquiry/"+address;
		List<CustomerEnquiry> list = rsTemplate.getForObject(url, List.class);
		
		List<CustomerEnquiry> allData = new ArrayList();
	    allData.addAll(list);
	    
	    return allData;
	}
	
	@GetMapping("/getAllByCibilStatus/{cibilStatus}")
	public List<CustomerEnquiry> getAllByCibilStatus(@PathVariable String cibilStatus)
	{
		String url = "http://localhost:8855/getAllByCibilStatus/"+cibilStatus;
		List<CustomerEnquiry> list = rsTemplate.getForObject(url, List.class);
		System.out.println(cibilStatus);
		List<CustomerEnquiry> allData = new ArrayList();
	    allData.addAll(list);
	    
	    return allData;
	}
	
	@GetMapping("/getAllByLoanStatus/{loanStatus}")
	public List<CustomerEnquiry> getAllByLoanStatus(@PathVariable String loanStatus)
	{
		String url = "http://localhost:8855/getAllByLoanStatus/"+loanStatus;
		List<CustomerEnquiry> list = rsTemplate.getForObject(url, List.class);
		
		List<CustomerEnquiry> allData = new ArrayList();
	    allData.addAll(list);
	    
	    return allData;
	}
	
	@GetMapping("/CustomerEnquiryAadhar/{aadharCardNumber}")
	public CustomerEnquiry getCustomerEnquiryByAadharCardNumber(@PathVariable ("aadharCardNumber")String aadharCardNumber) 
	{
		String url = "http://localhost:8855/CustomerEnquiryAadhar/"+aadharCardNumber;
		CustomerEnquiry ce= rsTemplate.getForObject(url, CustomerEnquiry.class);
		return ce;
	}
	

}
