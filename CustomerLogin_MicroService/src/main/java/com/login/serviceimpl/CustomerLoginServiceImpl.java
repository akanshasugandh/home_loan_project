package com.login.serviceimpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.customexceptions.EmailIdNotFoundException;
import com.login.customexceptions.EnquiryNotFoundException;
import com.login.model.CustomerRegForm;
import com.login.repository.CustomerLoginRepository;
import com.login.repository.CustomerRegFormRepository;
import com.login.servicei.CustomerLoginServiceI;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginServiceI
{
	@Autowired private CustomerRegFormRepository regFormRepository;
	
	@Autowired private CustomerLoginRepository reposLoginRepository;
	
	
	
	@Override
	public List<CustomerRegForm> getCustomerRegForm()
	{
		List<CustomerRegForm> al=regFormRepository.findAll();
		return al;
	}

	@Override
	public CustomerRegForm customerLogin(String emailId, String password,long otp) 
	{
		CustomerRegForm cr= reposLoginRepository.findByEmailIdAndPassword(emailId, password);
		if(cr!=null)
		{
			reposLoginRepository.save(cr);
			return cr;
		}
		else 
		{
			throw new EmailIdNotFoundException("Email-Id Not Found");
		}
	}


	@Override
	public CustomerRegForm getByCuId(int sanctionId) 
	{
		Optional<CustomerRegForm> cuop=reposLoginRepository.findById(sanctionId);
		if(cuop.isPresent())
		{
			CustomerRegForm cue=cuop.get();
			
			return cue;
		}
		else
		{
			throw new EnquiryNotFoundException("No enquiry found for this Id");
		}
	}

	@Override
	public CustomerRegForm getByCuIdr(int sanctionId) 
	{
		Optional<CustomerRegForm> cuop=reposLoginRepository.findById(sanctionId);
		if(cuop.isPresent())
		{
			CustomerRegForm cue=cuop.get();
			
			return cue;
		}
		else
		{
			throw new EnquiryNotFoundException("No enquiry found for this Id");
		}
	}

	@Override
	public void saveRegForm(CustomerRegForm byCuId) 
	{
		reposLoginRepository.save(byCuId);
		
	}
	

	
}


