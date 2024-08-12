package com.login.servicei;

import java.util.List;

import com.login.model.CustomerEnquiry;

public interface CustomerEnquiryServiceI {

	public void saveEnquiry(CustomerEnquiry ce);

	public List<CustomerEnquiry> getCustomerEnquiry();

	public  CustomerEnquiry getByCuId(int customerEnquiryId);

	public CustomerEnquiry findByName(String firstName);

	public List<CustomerEnquiry> findByAge(int age);
	
	public void deleteCustomerEnquiryById(int customerEnquiryId);

	public CustomerEnquiry findByLastName(String lastName);
	
	public CustomerEnquiry getByCusEmailId(String emailId);

	public List<CustomerEnquiry> getAllByCusCibilStatus(String cibilStatus);

	public List<CustomerEnquiry> getAllByCusLoanStatus(String loanStatus);

	public CustomerEnquiry getCustByContact(long contactNumber);

	public CustomerEnquiry getCustByPancard(String pancardNumber);

	public List<CustomerEnquiry> getCustomerEnquiryByAddress(String address);

	public CustomerEnquiry getCusEnqByAadharCardNumber(String aadharCardNumber);






}
