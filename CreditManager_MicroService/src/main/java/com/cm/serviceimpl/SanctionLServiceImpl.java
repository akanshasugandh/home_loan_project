package com.cm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.SanctionLetter;
import com.cm.repository.SanctionLRepository;
import com.cm.servicei.SanctionLServiceI;

@Service
public class SanctionLServiceImpl implements SanctionLServiceI {

	@Autowired
	SanctionLRepository repository;
	
	@Override
	public void saveSanction(SanctionLetter sl) {
		repository.save(sl);
	}

}
