package com.oe.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.oe.model.EmailDetails;
import com.oe.servicei.EmailServiceI;



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
}
