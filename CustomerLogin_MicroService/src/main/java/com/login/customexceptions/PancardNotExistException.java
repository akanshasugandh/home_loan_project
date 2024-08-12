package com.login.customexceptions;

public class PancardNotExistException extends RuntimeException{

	public PancardNotExistException(String msg)
	{
		super(msg);
	}
	
}
