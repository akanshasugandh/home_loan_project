package com.crm.servicei;

import java.util.List;

import com.crm.model.CustomerEnquiry;

public interface CustomerEnquiryServiceI {

	public void saveEnquiry(CustomerEnquiry ce);

	public List getCustomerEnquiry();

}
