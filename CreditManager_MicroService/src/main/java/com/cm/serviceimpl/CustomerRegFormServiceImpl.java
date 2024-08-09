package com.cm.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.CustomerRegForm;
import com.cm.repository.CustomerRegFormRepository;
import com.cm.servicei.CustomerRegFormServiceI;

@Service
public class CustomerRegFormServiceImpl implements CustomerRegFormServiceI
{

	@Autowired CustomerRegFormRepository cr;
	
	@Override
	public void saveRegForm(CustomerRegForm crf) {
		
		cr.save(crf);
	}

	@Override
	public CustomerRegForm getByCuRegId(int customerRegId) {
		
		return cr.findById(customerRegId).get();
	}
	
	

}
