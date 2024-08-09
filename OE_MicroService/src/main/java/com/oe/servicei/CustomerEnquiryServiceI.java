package com.oe.servicei;

import com.oe.model.CustomerEnquiry;

public interface CustomerEnquiryServiceI {

	public CustomerEnquiry calculateCibilScore(int customerEnquiryId);

	public CustomerEnquiry getByCuId(int customerEnquiryId);

	public void saveEnquiry(CustomerEnquiry ce);
}
