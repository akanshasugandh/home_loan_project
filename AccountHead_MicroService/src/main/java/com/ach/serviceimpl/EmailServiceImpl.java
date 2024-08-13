package com.ach.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ach.model.EmailDetails;
import com.ach.model.Ledger;
import com.ach.model.LoanDisbursement;
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
				"Bank");
		sender.send(message);
	}


	@Override
	public void ledgerGeneratedEmail(Ledger led, EmailDetails ed)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Ledger generated");
		message.setText("Ledger is generated after successful disbursement of loan.");
		sender.send(message);
	}
}


