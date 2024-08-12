package com.login.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.login.model.EmailDetails;
import com.login.model.SanctionLetter;
import com.login.servicei.EmailServiceI;

@Service
public class EmailServiceImpl implements EmailServiceI
{
	@Autowired private JavaMailSender sender;

	@Override
	public void sendEmail(EmailDetails ed)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Enquiry submitted successfully");
		message.setText("Welcome to Home Loan Application. Your enquiry details are submitted. Please wait till the further updates are sent!");
	
		sender.send(message);
		
	}

	@Override
	public void sendEmailToCustomer(EmailDetails ed) 
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("submitted successfully");
		message.setText("Dear Sir/Madam, You're Home Loan Enquiry Forwarded To OE. "
				+ "Please wait till the further updates are sent!");
		sender.send(message);
	}
	
	@Override
	public void sendEmail2(EmailDetails ed)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Registration done successfully");
		message.setText("Registration done successfully! Please wait till the further updates are sent!");
	
		sender.send(message);
		
	}

	@Override
	public void sendEmailToCustomerr(EmailDetails ed) 
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Registration done successfully");
		message.setText("Registration done successfully! Please wait till the further updates are sent!");
	
		sender.send(message);
		
	}

	@Override
	public void sendSanctionEmail(SanctionLetter sl, EmailDetails ed) 
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Sanction Letter details");
		message.setText("Dear "+sl.getApplicantName()+","+"\n"+
				"Your loan amount is sanctioned with Rs."+sl.getSanctionAmount()+". "+
				"Your tenure period is "+sl.getLoanTenure()+" year. "+
				"The rate of interest on your loan amount is "+sl.getRateofInterest()+"%. "+
				"Your loan EMI is "+sl.getMonthlyEMIAmount()+". "+"\n"+
				"You can now login to your account and accept your sanction letter!"+"\n"+
				"Regards,"+"\n"+
				"Bank");
		sender.send(message);
		
	}


	@Override
	public void sendEmailOtp(String emailId, long Otp) {
		try
		{
			SimpleMailMessage message=new SimpleMailMessage();
			message.setTo(emailId);
			message.setSubject("otp is => " +Otp);
			message.setText("Validate your otp before login...");
			sender.send(message);
		}
		catch(Exception me)
		{
			System.out.println(me.getMessage());

		}
	}

	@Override
	public void sendEmailAcc(EmailDetails ed) 
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Enquiry submitted successfully");
		message.setText("Sanction Accepted is successfull! Please wait till the further updates are sent!");
	
		sender.send(message);
	}

	@Override
	public void sendEmailRej(EmailDetails ed) 
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Enquiry submitted successfully");
		message.setText("Sanction Rejected! Please wait till the further updates are sent!");
	
		sender.send(message);
	}

	

	

	
	
}
