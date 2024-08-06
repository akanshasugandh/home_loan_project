package com.oe.customexceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ApiError {

	private int statusCode;
	private String message;
	private HttpStatus statusMessage;
	private Date timeStamp;
	private String path;
	

}
