package com.cm.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.model.CustomerRegForm;
import com.cm.model.EmailDetails;
import com.cm.model.SanctionLetter;
import com.cm.servicei.CustomerRegFormServiceI;
import com.cm.servicei.EmailServiceI;
import com.cm.servicei.SanctionLServiceI;

@RestController
public class SanctionLController {
	
	@Autowired SanctionLServiceI sanctionlservice;
	@Autowired CustomerRegFormServiceI curegservice;
	@Autowired EmailServiceI emailservicei;
	
	double emi_value;
	
	private static Logger log=LoggerFactory.getLogger(SanctionLController.class);
	
	@PostMapping("calculateEMI")
	public ResponseEntity<SanctionLetter> calculateEMI(@RequestBody SanctionLetter sl)
	{
		double p;	//loan amount
		double emi;	//EMI
		float r;	//rate of interest
		int t;		//tenure period
	
		p=sl.getSanctionAmount();
		r=sl.getRateofInterest();
		t=sl.getLoanTenure();
		t=t*12;	//time in month
		r=r/(12*100);	//as rate of interest is taken in per annum
		
		emi=(p*r*Math.pow((1+r),t))/(Math.pow((1+r),t)-1);
		sl.setMonthlyEMIAmount(emi);
		emi_value=emi;
		System.out.println("Monthly EMI= "+emi);
		return new ResponseEntity<SanctionLetter>(sl, HttpStatus.OK);
	}
	
	@PostMapping("/saveSL/{CustomerRegId}")
	public String saveSanctionLetter(@RequestBody SanctionLetter sl, @PathVariable int CustomerRegId)
	{
		CustomerRegForm cureg=curegservice.getByCuRegId(CustomerRegId);
		cureg.getSanctionLetter().setApplicantName(cureg.getFirstName());
		cureg.getSanctionLetter().setSanctionAmount(sl.getSanctionAmount());
		cureg.getSanctionLetter().setLoanTenure(sl.getLoanTenure());
		cureg.getSanctionLetter().setRateofInterest(sl.getRateofInterest());
		cureg.getSanctionLetter().setSanctionDate(new Date());
		cureg.getSanctionLetter().setMonthlyEMIAmount(emi_value);
		sl.setApplicantName(cureg.getFirstName());
		sl.setMonthlyEMIAmount(emi_value);
		curegservice.saveRegForm(cureg);
		
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(cureg.getEmailId());
		emailservicei.sendSanctionEmail(sl, ed);
		log.info("info()....save Sanction letter Details....");
		return "Sanction letter data saved successfully";
	}
	


}