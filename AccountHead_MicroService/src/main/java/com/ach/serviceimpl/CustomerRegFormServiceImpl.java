package com.ach.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ach.model.CustomerRegForm;
import com.ach.repository.CustomerRegFormRepository;
import com.ach.servicei.CustomerRegFormServiceI;

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
