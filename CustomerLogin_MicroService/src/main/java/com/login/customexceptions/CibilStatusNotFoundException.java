package com.login.customexceptions;

public class CibilStatusNotFoundException extends RuntimeException
{
	public CibilStatusNotFoundException(String msg_cb)
	{
		super(msg_cb);
	}
}
