package com.login.customexceptions;

public class EmailIdNotFoundException extends RuntimeException
{
	public EmailIdNotFoundException(String msg) {
		super(msg);
	}

}
