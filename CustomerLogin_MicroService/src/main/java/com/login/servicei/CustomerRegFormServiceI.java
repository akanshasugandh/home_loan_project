package com.login.servicei;

import com.login.model.CustomerRegForm;

public interface CustomerRegFormServiceI 
{

	public void saveRegForm(CustomerRegForm crf);

	public CustomerRegForm getByRegId(int customerRegId);

	public CustomerRegForm getByCuRegId(int customerRegId);


}
