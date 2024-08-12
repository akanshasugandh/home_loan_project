package com.login.servicei;

import java.util.List;

import com.login.model.CustomerRegForm;

public interface CustomerLoginServiceI 
{

	public List<CustomerRegForm> getCustomerRegForm();

	public CustomerRegForm customerLogin(String emailId,String password, long otp);

	public CustomerRegForm getByCuId(int sanctionId);

	public CustomerRegForm getByCuIdr(int sanctionId);

	public void saveRegForm(CustomerRegForm byCuId);

	



}
