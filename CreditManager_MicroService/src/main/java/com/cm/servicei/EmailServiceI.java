package com.cm.servicei;

import com.cm.model.EmailDetails;
import com.cm.model.SanctionLetter;

public interface EmailServiceI
{

	public void sendSanctionEmail(SanctionLetter sl, EmailDetails em);
	
}
