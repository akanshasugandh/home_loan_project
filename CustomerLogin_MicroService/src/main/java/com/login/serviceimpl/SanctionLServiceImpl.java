package com.login.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.SanctionLetter;
import com.login.repository.SanctionLRepository;
import com.login.servicei.SanctionLServiceI;

@Service
public class SanctionLServiceImpl implements SanctionLServiceI {

	@Autowired
	SanctionLRepository repository;
	
	@Override
	public void saveSanction(SanctionLetter sl) {
		repository.save(sl);
	}

}
