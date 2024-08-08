package com.crm.servicei;

import com.crm.model.CustomerRegForm;

public interface CustomerRegFormServiceI {

	public void saveRegForm(CustomerRegForm crf);

	public CustomerRegForm getByRegId(int customerRegId);

}
