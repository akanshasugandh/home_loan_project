package com.crm.servicei;

import com.crm.model.CustomerRegForm;

public interface CustomerRegFormServiceI {

	public void saveRegForm(CustomerRegForm crf);

	public CustomerRegForm getByRegId(int customerRegId);

	public CustomerRegForm getByName(String firstName);

	public CustomerRegForm getByEmailId(String emailId);

	public CustomerRegForm getByPassword(String password);

	public CustomerRegForm getByAadharNum(String aadharCardNumber);

	public CustomerRegForm getByPancardNum(String pancardNumber);
}
