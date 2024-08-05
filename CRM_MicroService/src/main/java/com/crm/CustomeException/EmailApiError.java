package com.crm.CustomeException;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class EmailApiError
{
	private int statusCode;
	private String message;
	private HttpStatus statusMessage;
	private Date timeStamp;
	private String path;
}
