package com.oe.serviceimpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oe.customexceptions.CibilScoreAlreadyGeneratedExcep;
import com.oe.customexceptions.EnquiryNotFoundException;
import com.oe.model.CustomerEnquiry;
import com.oe.model.EmailDetails;
import com.oe.repository.CustomerEnquiryRepository;
import com.oe.servicei.CustomerEnquiryServiceI;
import com.oe.servicei.EmailServiceI;

@Service
public class CustomerEnquiryServiceImpl implements CustomerEnquiryServiceI 
{
	@Autowired private CustomerEnquiryRepository repository;

	@Autowired private EmailServiceI em;

	@Override
	public CustomerEnquiry calculateCibilScore(int customerEnquiryId)
	{
		Optional<CustomerEnquiry> cuop=repository.findById(customerEnquiryId);
		
		if(cuop.isPresent())
		{
			CustomerEnquiry cue=cuop.get();
			if(cue.getCibilScore()>0)
			{
			
				throw new CibilScoreAlreadyGeneratedExcep("CibilScore is Already calculated For This ID");
			}
			else if(cue.getLoanStatus().equalsIgnoreCase("fwdToOE"))
			{
				Random r=new Random();
				EmailDetails ed = new EmailDetails();
				int cibilScore=r.nextInt(900-300)+300;
				cue.setCibilScore(cibilScore);
				cue.setCibilStatus(cibilScore>=650 ? "Good ": "Poor");
				cue.setLoanStatus(cibilScore>=650 ? "CIBIL_approved":"CIBIL_rejected");
				ed.setToEmail(cue.getEmailId());
				if(cibilScore>=650)
				{
					ed.setSubject("YourCIBIL score is Approved => " +cibilScore);
					ed.setTxtMsg("You can procede to Registration process");
					em.sendEmailToCustomer(ed);
				}
				else
				{
					ed.setSubject("YourCIBIL score is Rejected => " +cibilScore);
					ed.setTxtMsg("Not eligible for Registration process");
					em.sendEmailToCustomer(ed);
				}
				
				return repository.save(cue);
			}
			else
			{
				 throw new EnquiryNotFoundException("This enquiry is not forwarded to OE");
			}
		}else 
		{
			throw new EnquiryNotFoundException("Enquiry not found for this ID");
		}
		}
		

	}


