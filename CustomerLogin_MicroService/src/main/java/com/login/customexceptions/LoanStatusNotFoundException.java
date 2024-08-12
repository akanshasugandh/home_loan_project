package com.login.customexceptions;

public class LoanStatusNotFoundException extends RuntimeException
{
	public LoanStatusNotFoundException(String msg)
	{
		super(msg);
	}
}
