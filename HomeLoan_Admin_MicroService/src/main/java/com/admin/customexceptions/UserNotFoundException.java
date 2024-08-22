package com.admin.customexceptions;

public class UserNotFoundException extends RuntimeException
{
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
