package com.ach.customexception;

public class CustomerDataNotFoundException extends RuntimeException 
{
	public CustomerDataNotFoundException(String msg)
	{
		super(msg);
	}

}
