package com.admin.customexceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler
    public ResponseEntity<ApiError> EnquiryNotFoundExceptionhandler(EnquiryNotFoundException e,HttpServletRequest request){
  	  ApiError error=new ApiError();
  	  error.setMessage(e.getMessage());
  	  error.setPath(request.getRequestURI());
  	  error.setStatusCode(HttpStatus.NOT_FOUND.value());
  	  error.setStatusMessage(HttpStatus.NOT_FOUND);
  	  error.setTimeStamp(new Date());
  	  return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
    public ResponseEntity<ApiError> UserNotFoundException(UserNotFoundException e,HttpServletRequest request){
  	  ApiError error=new ApiError();
  	  error.setMessage(e.getMessage());
  	  error.setPath(request.getRequestURI());
  	  error.setStatusCode(HttpStatus.NOT_FOUND.value());
  	  error.setStatusMessage(HttpStatus.NOT_FOUND);
  	  error.setTimeStamp(new Date());
  	  return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
}
}
