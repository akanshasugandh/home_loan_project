package com.crm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.crm.model.EmailDetails;
import com.crm.servicei.EmailServiceI;

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
}
