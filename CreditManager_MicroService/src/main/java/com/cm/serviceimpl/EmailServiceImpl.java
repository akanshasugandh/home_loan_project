package com.cm.serviceimpl;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cm.model.EmailDetails;
import com.cm.model.SanctionLetter;
import com.cm.servicei.EmailServiceI;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailServiceI
{
	@Autowired private JavaMailSender sender;
	
	@Override
	public void sendSanctionEmail(SanctionLetter sl, EmailDetails em) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(em.getToEmail());
		message.setSubject("Sanction Letter details");
		message.setText("Dear "+sl.getApplicantName()+","+"\n"+
				"Your loan amount is sanctioned with Rs."+sl.getSanctionAmount()+". "+
				"Your tenure period is "+sl.getLoanTenure()+" year. "+
				"The rate of interest on your loan amount is "+sl.getRateofInterest()+"%. "+
				"Your loan EMI is "+sl.getMonthlyEMIAmount()+". "+"\n"+
				"You can now login to your account and accept your sanction letter!"+"\n"+
				"Regards,"+"\n"+
				"AMPRR Finance Ltd.");
		sender.send(message);
	}
	@Override
	public void sendSanctionLonEmail(SanctionLetter letter, EmailDetails ed) {
		MimeMessage mm= sender.createMimeMessage();
		try 
		{
			MimeMessageHelper helper=new MimeMessageHelper(mm,true);
			helper.setTo(ed.getToEmail());							
			helper.setSubject("Sanction Letter For Home Loan");                   
			helper.setText("Dear "+letter.getApplicantName()+",\nPlease Find Your sanction letter attached.");	
			helper.addAttachment("letter.pdf",()-> new ByteArrayInputStream(letter.getSanctionDocpdf()));
			sender.send(mm);
		} 
		catch (MessagingException e) 
		{
			
			e.printStackTrace();
		}

		
	}

}


