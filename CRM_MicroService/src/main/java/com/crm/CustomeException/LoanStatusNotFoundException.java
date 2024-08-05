package com.crm.CustomeException;

public class LoanStatusNotFoundException extends RuntimeException
{
	public LoanStatusNotFoundException(String msg)
	{
		super(msg);
	}
}
