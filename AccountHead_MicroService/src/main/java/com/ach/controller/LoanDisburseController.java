package com.ach.controller;

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

import com.ach.model.CustomerRegForm;
import com.ach.model.EmailDetails;
import com.ach.model.Ledger;
import com.ach.model.LoanDisbursement;
import com.ach.servicei.CustomerRegFormServiceI;
import com.ach.servicei.EmailServiceI;
import com.ach.servicei.LoanDisbursementServiceI;

@RestController
public class LoanDisbursementController
{
	@Autowired LoanDisbursementServiceI disServiceI;
	@Autowired CustomerRegFormServiceI curegservice;
	@Autowired EmailServiceI emailservicei;
	
	private static Logger log=LoggerFactory.getLogger(LoanDisbursementController.class);
	
	@PostMapping("/loanDisburseInfo/{CustomerRegId}")
	public ResponseEntity<LoanDisbursement> loanDisburseInfo(@RequestBody LoanDisbursement loanDis, @PathVariable int CustomerRegId)
	{
		CustomerRegForm cureg=curegservice.getByCuRegId(CustomerRegId);
		cureg.getLoanDisbursement().setApplicantName(cureg.getFirstName());
		cureg.getLoanDisbursement().setTotalLoanSanctionedAmount(cureg.getSanctionLetter().getSanctionAmount());
		cureg.getLoanDisbursement().setAmountPaidDate(new Date());
		cureg.getLoanDisbursement().setBankAccountNumber(cureg.getBankinfo().getBankAccountNo());
		cureg.getLoanDisbursement().setBankBranchName(cureg.getBankinfo().getBranchName());
		cureg.getLoanDisbursement().setBankIfscNumber(cureg.getBankinfo().getIfscCode());
		cureg.getLoanDisbursement().setTransferedAmount(loanDis.getTransferedAmount());
		cureg.getLoanDisbursement().setPaymentStatus(loanDis.getPaymentStatus());
		loanDis.setApplicantName(cureg.getFirstName());
		loanDis.setTotalLoanSanctionedAmount(cureg.getSanctionLetter().getSanctionAmount());
		loanDis.setBankAccountNumber(cureg.getBankinfo().getBankAccountNo());
		curegservice.saveRegForm(cureg);
		
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(cureg.getEmailId());
		emailservicei.loanDisbursementEmail(loanDis, ed);
		log.info("info()....save loan disbursement details....");
		return new ResponseEntity<LoanDisbursement>(cureg.getLoanDisbursement(), HttpStatus.OK);
	}
	
	@PostMapping("/generateLedger/{CustomerRegId}")
	public ResponseEntity<Ledger> generateLedger(@RequestBody Ledger led, @PathVariable int CustomerRegId)
	{
		CustomerRegForm cureg=curegservice.getByCuRegId(CustomerRegId);
		cureg.getLedger().setLedgerCreatedDate(new Date());
		cureg.getLedger().setTotalPrincipalAmount(cureg.getLoanDisbursement().getTotalLoanSanctionedAmount());
		cureg.getLedger().setPayableAmountWithInterest(led.getPayableAmountWithInterest());
		cureg.getLedger().setTenure(cureg.getSanctionLetter().getLoanTenure());
		cureg.getLedger().setMonthlyEMI(cureg.getSanctionLetter().getMonthlyEMIAmount());
		cureg.getLedger().setAmountPaidTillDate(led.getAmountPaidTillDate());
		cureg.getLedger().setRemainingAmount(led.getRemainingAmount());
		cureg.getLedger().setNextEmiStartDate(led.getNextEmiStartDate());
		cureg.getLedger().setNextEmiEndDate(led.getNextEmiEndDate());
		cureg.getLedger().setPreviousEmiStatus(led.getPreviousEmiStatus());
		cureg.getLedger().setCurrentMonthEmiStatus(led.getCurrentMonthEmiStatus());
		cureg.getLedger().setLoanEndDate(led.getLoanEndDate());
		cureg.getLedger().setLoanStatus(cureg.getLoanStatus());
		curegservice.saveRegForm(cureg);
		
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(cureg.getEmailId());
		emailservicei.ledgerGeneratedEmail(led, ed);
		log.info("info()....save ledger generated details....");
		return new ResponseEntity<Ledger>(cureg.getLedger(), HttpStatus.OK);
	}

	
	
}
