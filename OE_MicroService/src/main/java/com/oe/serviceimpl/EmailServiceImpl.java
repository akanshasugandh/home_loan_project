package com.oe.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oe.model.CustomerEnquiry;
import com.oe.model.EmailDetails;
import com.oe.servicei.EmailServiceI;

import jakarta.mail.internet.MimeMessage;



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
		
		try
		{
			MimeMessage msg=sender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(msg,true);
			CustomerEnquiry ce=new CustomerEnquiry();
			helper.setTo(ed.getToEmail());
			helper.setSubject(ed.getSubject());
			helper.setText(ed.getTxtMsg());	
			sender.send(msg);
		}
		catch(Exception me)
		{
			System.out.println(me.getMessage());

		}
	}

	@Override
	public void sendEmailAcc(EmailDetails ed) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Enquiry submitted successfully");
		message.setText("Documents verification is successfull! Please wait till the further updates are sent!");
	
		sender.send(message);
		
	}
	
	@Override
	public void sendEmailRej(EmailDetails ed) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(ed.getToEmail());
		message.setSubject("Enquiry submitted successfully");
		message.setText("Documents verification failed! Sorry you're not eligible for getting loan");
	
		sender.send(message);
	}
}


