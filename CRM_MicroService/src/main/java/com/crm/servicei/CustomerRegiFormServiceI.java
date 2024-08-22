package com.crm.servicei;

import java.util.List;

import com.crm.model.CustomerRegForm;

public interface CustomerRegiFormServiceI {

	public void saveRegForm(CustomerRegForm crf);

	public CustomerRegForm getByRegId(int customerRegId);

	public CustomerRegForm getByCuRegName(String firstName);

	public CustomerRegForm getByCuRegEmailId(String emailId);

	public CustomerRegForm getByCuRegPassword(String password);

	public CustomerRegForm getByCuRegAadharNum(String aadharCardNumber);

	public CustomerRegForm getByCuRegPancardNum(String pancardNumber);
	
	public List<CustomerRegForm> getFirstNameAsc();

	public List<CustomerRegForm> getLastNameAsc();

	public List<CustomerRegForm> getAgeByAsc();

	public List<CustomerRegForm> getcontactNumberByAsc();

	public List<CustomerRegForm> getEmailIdByAsc();

	public List<CustomerRegForm> getaadharCardNumberByAsc();

	public List<CustomerRegForm> getPancardNumberByAsc();

	public List<CustomerRegForm> getFirstNameDesc();

	public List<CustomerRegForm> getLastNameDesc();

	public List<CustomerRegForm> getAgeByDesc();

	public List<CustomerRegForm> getcontactNumberByDesc();

	public List<CustomerRegForm> getEmailIdByDesc();

	public List<CustomerRegForm> getaadharCardNumberByDesc();

	public List<CustomerRegForm> getPancardNumberByDesc();
	
}
