package com.ach.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ach.customexception.CustomerDataNotFoundException;
import com.ach.model.CustomerRegForm;
import com.ach.model.LoanDisbursement;
import com.ach.model.SanctionLetter;
import com.ach.repository.CustomerRegFormRepository;
import com.ach.repository.LoanDisbursementRepository;
import com.ach.servicei.LoanDisbursementServiceI;

@Service
public class LoanDisbursementImpl implements LoanDisbursementServiceI {
	
	@Autowired LoanDisbursementRepository loanDisRepository;
	@Autowired CustomerRegFormRepository cusRegRepository;

	@Override
	public CustomerRegForm getByCuId(int agreementId) {
			Optional<CustomerRegForm> cuop=loanDisRepository.findById(agreementId);
			if(cuop.isPresent())
			{
				CustomerRegForm cue=cuop.get();
				
				return cue;
			}
			else
			{
				throw new CustomerDataNotFoundException("Loan disbursement details!");
			}
		}
	
	

	@Override
	public void saveRegForm(CustomerRegForm cuReg) {
		loanDisRepository.save(cuReg);
		
	}

	

}
