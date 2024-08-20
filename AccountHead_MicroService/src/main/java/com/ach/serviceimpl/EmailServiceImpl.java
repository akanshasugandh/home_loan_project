package com.ach.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ach.model.CustomerRegForm;
import com.ach.model.EmailDetails;
import com.ach.model.Ledger;
import com.ach.model.LoanDisbursement;
import com.ach.repository.CustomerRegFormRepository;
import com.ach.servicei.EmailServiceI;

@Service
public class EmailServiceImpl implements EmailServiceI
{
	@Autowired private JavaMailSender sender;
	
	@Override
	public void loanDisbursementEmail(LoanDisbursement loanDis, EmailDetails em){
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(em.getToEmail());
		message.setSubject("Loan Disbursement details");
		message.setText("Dear "+loanDis.getApplicantName()+","+"\n"+
				"We're glad to inform you that your loan is disbursed with total sanctioned amount of Rs."+loanDis.getTotalLoanSanctionedAmount()+". "+
				"Loan transfered amount is "+loanDis.getTransferedAmount()+" . "+
				"Your Loan payment status now is "+loanDis.getPaymentStatus()+". "+
				"For bank account number "+loanDis.getBankAccountNumber()+". "+"\n"+
				"You can proceed with further steps!"+"\n"+
				"Regards,"+"\n"+
				"AMPRR Finance limited.");
		sender.send(message);
	}

	@Override
	public void ledgerGeneratedEmail(Ledger led, EmailDetails emd)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(emd.getToEmail());
		message.setSubject("Ledger generated");
		message.setText("Dear valuable customer, \n"
				+ "Your loan amount is due on "+led.getNextEmiStartDate()+", with the last date to pay it on "+led.getNextEmiEndDate()+". "
 	 			+ "Your total payable amount is "+led.getPayableAmountWithInterest()+". \n"+
				"We request you to pay it on time to avoid any further complications. \n"+
				"Regards, \n"+
				"AMPRR Finance Ltd");
		sender.send(message);
	}
}


