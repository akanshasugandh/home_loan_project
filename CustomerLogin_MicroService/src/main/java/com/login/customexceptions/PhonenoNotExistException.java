package com.login.customexceptions;

public class PhonenoNotExistException extends RuntimeException{

	public PhonenoNotExistException(String msg)
	{
		super(msg);
	}
	
}
