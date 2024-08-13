package com.ach.servicei;

import com.ach.model.EmailDetails;
import com.ach.model.Ledger;
import com.ach.model.LoanDisbursement;

public interface EmailServiceI
{
	public void loanDisbursementEmail(LoanDisbursement loanDis, EmailDetails em);

	public void ledgerGeneratedEmail(Ledger led, EmailDetails ed);
	
}
