package com.crm.servicei;

import java.util.List;

import com.crm.model.CustomerEnquiry;

public interface CustomerEnquiryServiceI {

	public void saveEnquiry(CustomerEnquiry ce);

	public List<CustomerEnquiry> getCustomerEnquiry();

	public  CustomerEnquiry getByCuId(int customerEnquiryId);

	public CustomerEnquiry findByName(String firstName);

	public List<CustomerEnquiry> findByAge(int age);
	
	public void deleteCustomerEnquiryById(int customerEnquiryId);




}
