package com.cm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cm.model.EmailDetails;
import com.cm.model.SanctionLetter;
import com.cm.servicei.EmailServiceI;

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
				"Bank");
		sender.send(message);
	}

}


