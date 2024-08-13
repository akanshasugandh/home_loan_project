package com.cm.servicei;

import com.cm.model.CustomerRegForm;
import com.cm.model.SanctionLetter;

public interface SanctionLServiceI {

	public void saveSanction(SanctionLetter sl);
	
	public CustomerRegForm saveSanctionLetter(SanctionLetter sl, int customerRegId);

}
