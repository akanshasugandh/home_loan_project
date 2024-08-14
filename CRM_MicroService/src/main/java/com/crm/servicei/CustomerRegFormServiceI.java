package com.crm.servicei;

import com.crm.model.CustomerRegForm;

public interface CustomerRegFormServiceI {

	public void saveRegForm(CustomerRegForm crf);

	public CustomerRegForm getByRegId(int customerRegId);

	public CustomerRegForm getByCuRegName(String firstName);

	public CustomerRegForm getByCuRegEmailId(String emailId);

	public CustomerRegForm getByCuRegPassword(String password);

	public CustomerRegForm getByCuRegAadharNum(String aadharCardNumber);

	public CustomerRegForm getByCuRegPancardNum(String pancardNumber);
}
