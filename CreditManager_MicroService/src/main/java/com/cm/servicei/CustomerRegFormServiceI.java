package com.cm.servicei;

import com.cm.model.CustomerRegForm;

public interface CustomerRegFormServiceI {

	public CustomerRegForm getByCuRegId(int customerRegId);
	
	public void saveRegForm(CustomerRegForm crf);

}
