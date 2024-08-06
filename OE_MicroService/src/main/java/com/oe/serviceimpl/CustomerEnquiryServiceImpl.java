package com.oe.serviceimpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oe.customexceptions.CibilScoreAlreadyGeneratedExcep;
import com.oe.model.CustomerEnquiry;
import com.oe.repository.CustomerEnquiryRepository;
import com.oe.servicei.CustomerEnquiryServiceI;

@Service
public class CustomerEnquiryServiceImpl implements CustomerEnquiryServiceI 
{
	@Autowired private CustomerEnquiryRepository repository;

	@Override
	public CustomerEnquiry calculateCibilScore(int customerEnquiryId)
	{
		Optional<CustomerEnquiry> cuop=repository.findById(customerEnquiryId);
		
		if(cuop.isPresent())
		{
			CustomerEnquiry cue=cuop.get();
			if(cue.getCibilScore()>0)
			{
				throw new CibilScoreAlreadyGeneratedExcep("CibilScore is Already Claculated For This ID");
			}
			else {
				Random r=new Random();
				int cibilScore=r.nextInt(900-300)+300;
				cue.setCibilScore(cibilScore);
				cue.setCibilStatus(cibilScore>=650 ? "Good ": "Poor");
			return repository.save(cue);
			}
		}else 
		{
			throw new RuntimeException("Customer Not Found For This ID");
		}
		}
		

	}


