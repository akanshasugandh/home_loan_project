package com.crm.servicei;

import com.crm.model.EmailDetails;

public interface EmailServiceI
{

	public void sendEmail(EmailDetails ed);
	
	public void sendEmailToCustomer(EmailDetails ed);
	
	public void sendEmail2(EmailDetails ed);
	
}
