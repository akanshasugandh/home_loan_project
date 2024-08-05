package com.crm.CustomeException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiError>personNotFoundExceptionhandler(EnquiryNotFoundException e,HttpServletRequest request){
  	  ApiError error=new ApiError();
  	  error.setMessage(e.getMessage());
  	  error.setPath(request.getRequestURI());
  	  error.setStatusCode(HttpStatus.NOT_FOUND.value());
  	  error.setStatusMessage(HttpStatus.ACCEPTED.NOT_FOUND);
  	  error.setTimeStamp(new Date());
  	  return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
  	  }
    
    @ExceptionHandler
    public ResponseEntity<ApiError>NamNtFoundException(NameNotFoundException ne,HttpServletRequest request){
  	  ApiError error=new ApiError();
  	  error.setMessage(ne.getMessage());
  	  error.setPath(request.getRequestURI());
  	  error.setStatusCode(HttpStatus.NOT_FOUND.value());
  	  error.setStatusMessage(HttpStatus.ACCEPTED.NOT_FOUND);
  	  error.setTimeStamp(new Date());
  	  return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
  	  }
    @ExceptionHandler
    public ResponseEntity<ApiError>LastNamNtFoundException(LastNameNotFoundExcep lne,HttpServletRequest request){
  	  ApiError error=new ApiError();
  	  error.setMessage(lne.getMessage());
  	  error.setPath(request.getRequestURI());
  	  error.setStatusCode(HttpStatus.NOT_FOUND.value());
  	  error.setStatusMessage(HttpStatus.ACCEPTED.NOT_FOUND);
  	  error.setTimeStamp(new Date());
  	  return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
  	  }
    
    @ExceptionHandler
    public ResponseEntity<ApiError>AgeNtFoundException(InvalidAgeException ae,HttpServletRequest request){
  	  ApiError error=new ApiError();
  	  error.setMessage(ae.getMessage());
  	  error.setPath(request.getRequestURI());
  	  error.setStatusCode(HttpStatus.NOT_FOUND.value());
  	  error.setStatusMessage(HttpStatus.ACCEPTED.NOT_FOUND);
  	  error.setTimeStamp(new Date());
  	  return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
  	  }
    
    @ExceptionHandler
    public ResponseEntity<EmailApiError> emailIdNotFoundExceptionHandler(EmailIdNotFoundException e, HttpServletRequest request)
    {
    	EmailApiError error=new EmailApiError();
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<EmailApiError>(error, HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler
    public ResponseEntity<CibilApiError> cibilStatusNotFoundExceptionHandler(CibilStatusNotFoundException e, HttpServletRequest request)
    {
		CibilApiError error=new CibilApiError();
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<CibilApiError>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ResponseEntity<LoanStatusApiError> loanStatusNotFoundExceptionHandler(LoanStatusNotFoundException e, HttpServletRequest request)
    {
    	LoanStatusApiError error=new LoanStatusApiError();
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<LoanStatusApiError>(error, HttpStatus.NOT_FOUND);
    	
    }



}
