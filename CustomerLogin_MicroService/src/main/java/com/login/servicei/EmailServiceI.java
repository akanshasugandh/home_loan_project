package com.login.servicei;

import com.login.model.EmailDetails;
import com.login.model.SanctionLetter;

public interface EmailServiceI
{

	public void sendEmail(EmailDetails ed);
	
	public void sendEmailToCustomer(EmailDetails ed);
	
	public void sendEmail2(EmailDetails ed);
	
	public void sendEmailToCustomerr(EmailDetails ed);

	public void sendSanctionEmail(SanctionLetter sl, EmailDetails ed);

	public void sendEmailOtp(String emailId, long Otp);

	public void sendEmailAcc(EmailDetails ed);

	public void sendEmailRej(EmailDetails ed);



}
