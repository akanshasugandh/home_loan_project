package com.oe.servicei;

import com.oe.model.EmailDetails;

public interface EmailServiceI
{

	public void sendEmail(EmailDetails ed);
	
	public void sendEmailToCustomer(EmailDetails ed);

	
}
