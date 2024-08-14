package com.crm.CustomeException;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}

}
