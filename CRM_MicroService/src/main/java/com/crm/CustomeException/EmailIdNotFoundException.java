package com.crm.CustomeException;

public class EmailIdNotFoundException extends RuntimeException
{
	public EmailIdNotFoundException(String msg_em)
	{
		super(msg_em);
	}
}
