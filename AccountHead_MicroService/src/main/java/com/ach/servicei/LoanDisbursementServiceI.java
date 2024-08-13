package com.ach.servicei;

import com.ach.model.CustomerRegForm;

public interface LoanDisbursementServiceI {

	public CustomerRegForm getByCuId(int agreementId);

	public void saveRegForm(CustomerRegForm byCuId);

}
