package com.admin.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.admin.customexceptions.EnquiryNotFoundException;
import com.admin.customexceptions.UserNotFoundException;
import com.admin.model.CustomerEnquiry;

import com.admin.model.Users;
import com.admin.servicei.UsersServiceI;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class AdminController

{
	@Autowired
	UsersServiceI uservicei;
	@Autowired
	RestTemplate restT;
	
	@PostMapping("/saveUsersData")
	public ResponseEntity<String> saveDataByAdmin(@RequestBody Users u ) 
	{
		
		uservicei.saveDetails(u);
		String str="Customer details saved successfully!";
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	@GetMapping("/getUser/{userName}")
	public Users getUserByUName(@PathVariable String userName)
	{
		return 	uservicei.findByUserName(userName);
		
	}

	@GetMapping("/login/{userId}/{upassword}")
	public ResponseEntity<Users> loginWithUserIdAndPass(@PathVariable int userId,@PathVariable String upassword)
	{
		Users usr=uservicei.userLogin(userId,upassword);
		
		if(usr!=null)
		{
			return new ResponseEntity<Users> (usr,HttpStatus.OK); 
		}
		else
		{
			throw new UserNotFoundException("User Not found For  This Id");	
		}
	}
	
	@GetMapping("/getByCibilStatus/{cibilStatus}")
	public List<CustomerEnquiry> getAllByCustomerCibilS(@PathVariable String cibilStatus)
	{
		String urlCibilStatus="http://localhost:8855/getAllByCibilStatus/"+cibilStatus;
		List<CustomerEnquiry> CibilSlist=restT.getForObject(urlCibilStatus, List.class);
		return CibilSlist;
	}
	@GetMapping("/getByLoanStatus/{loanStatus}")
	public List<CustomerEnquiry> getAllByCustomerLoanS(@PathVariable String loanStatus)
	{
		String urlLoanStatus="http://localhost:8855/getAllByLoanStatus/"+loanStatus;
		List<CustomerEnquiry> LoanSlist=restT.getForObject(urlLoanStatus, List.class);
		return LoanSlist;
	}
	
	@PutMapping("updateUDetails/{userId}")
	public ResponseEntity<String> updateUserData(@PathVariable int userId, @RequestBody Users us) {
	
		Users user=uservicei.getByUId(userId);
		user.setUserName(us.getUserName());
		user.setUemailId(us.getUemailId());
		user.setUpassword(us.getUpassword());
		user.setUserType(us.getUserType());
		uservicei.saveDetails(user);
		return new ResponseEntity<String> ("Users Details Updated.....",HttpStatus.OK);
	}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


