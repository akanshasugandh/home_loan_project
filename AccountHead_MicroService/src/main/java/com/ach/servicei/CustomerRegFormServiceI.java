package com.ach.servicei;

import com.ach.model.CustomerRegForm;

public interface CustomerRegFormServiceI {

	public CustomerRegForm getByCuRegId(int customerRegId);
	
	public void saveRegForm(CustomerRegForm crf);

}
