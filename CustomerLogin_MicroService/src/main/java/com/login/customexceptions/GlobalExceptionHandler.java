package com.login.customexceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class GlobalExceptionHandler {
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
    public ResponseEntity<ApiError> cibilStatusNotFoundExceptionHandler(CibilStatusNotFoundException ci, HttpServletRequest request)
    {
    	ApiError error=new ApiError();
		error.setMessage(ci.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ResponseEntity<ApiError> loanStatusNotFoundExceptionHandler(LoanStatusNotFoundException ls, HttpServletRequest request)
    {
    	ApiError error=new ApiError();
		error.setMessage(ls.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    	
    }
    
    @ExceptionHandler
    public ResponseEntity<ApiError> PhonenoNotExistExceptionExceptionHandler(PhonenoNotExistException p, HttpServletRequest request)
    {
    	ApiError error=new ApiError();
		error.setMessage(p.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ResponseEntity<ApiError> PancardNotExistFoundExceptionHandler(PancardNotExistException pc, HttpServletRequest request)
    {
    	ApiError error=new ApiError();
		error.setMessage(pc.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    	
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> AddharCardNumberNotFoundExceptionExceptionHandler(AddharCardNumberNotFoundException ac, HttpServletRequest request)
    {
    	ApiError error=new ApiError();
		error.setMessage(ac.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    	
    }
    
    @ExceptionHandler
    public ResponseEntity<ApiError>EmailIdNotFoundExceptionExceptionHandler(EmailIdNotFoundException em,HttpServletRequest request)
    {
    	ApiError error=new ApiError();
		error.setMessage(em.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setTimeStamp(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    	
    }
  
}
