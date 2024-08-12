package com.login.controller;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.login.model.CustomerRegForm;
import com.login.model.EmailDetails;
import com.login.servicei.CustomerLoginServiceI;
import com.login.servicei.CustomerRegFormServiceI;
import com.login.servicei.EmailServiceI;

@RestController
public class CustomerLoginController 
{
	@Autowired CustomerRegFormServiceI regFormServiceI;
	
	@Autowired CustomerLoginServiceI loginServiceI;
	
	@Autowired private EmailServiceI emailservicei;
	long Otp;
	private static Logger log=LoggerFactory.getLogger(CustomerLoginController.class);
	
	@GetMapping("/getAllRegEnquiry")
	public List<CustomerRegForm> getCustomerRegForm()
	{
		log.info("info()...getAllEnquiry().........");
		List<CustomerRegForm> al=loginServiceI.getCustomerRegForm(); 
		return al;
	}

	@GetMapping("/login/{emailId}/{password}/{getOtp}")
	public ResponseEntity<String> UsernamePwd(@PathVariable String emailId,@PathVariable String password,@PathVariable int getOtp)
	{
		CustomerRegForm cr=loginServiceI.customerLogin(emailId, password,getOtp);
		log.info("info()...get email password Otp().........");
		if(getOtp==Otp)
		{
			return new ResponseEntity<String> ("Valied OTP",HttpStatus.OK); 
		}
		else
		{
			return new ResponseEntity<String> ("Invalied OTP",HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/sendOtp/{emailId}/{CustomerRegId}")
	public String getOtp(@PathVariable String emailId,@PathVariable int CustomerRegId)
	{
		log.info("info()...get Otp().........");
		Random r=new Random();
		Otp=1000+r.nextInt(9999);
		emailservicei.sendEmailOtp(emailId, Otp);
		return String.valueOf(Otp);	
	}
	
	@GetMapping("/viewSanctionAccepted/{sanctionId}")
	public ResponseEntity<String> sanAccepted(@PathVariable int sanctionId)
	{
		CustomerRegForm byCuId = loginServiceI.getByCuId(sanctionId);
		byCuId.setLoanStatus("sanAccepted");
		loginServiceI.saveRegForm(byCuId);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(byCuId.getEmailId());
		emailservicei.sendEmailAcc(ed);
		log.info("info()...view Sanction Accepted().........");
		return new ResponseEntity<String>("sanAccepted", HttpStatus.OK);
	}
	
	@GetMapping("/viewSanctionRejected/{sanctionId}")
	public ResponseEntity<String> sanRejected(@PathVariable int sanctionId)
	{
		CustomerRegForm byCuId = loginServiceI.getByCuIdr(sanctionId);
		byCuId.setLoanStatus("sanRejected");
		loginServiceI.saveRegForm(byCuId);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(byCuId.getEmailId());
		emailservicei.sendEmailRej(ed);
		log.info("info()...view Sanction Rejected().........");
		return new ResponseEntity<String>("sanRejected", HttpStatus.OK);
	}
}
