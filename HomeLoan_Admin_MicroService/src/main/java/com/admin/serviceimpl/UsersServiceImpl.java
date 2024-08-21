package com.admin.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.customexceptions.EnquiryNotFoundException;
import com.admin.model.CustomerRegForm;
import com.admin.model.Users;
import com.admin.repository.UsersRepository;
import com.admin.servicei.UsersServiceI;


@Service
public class UsersServiceImpl implements UsersServiceI
{

	@Autowired
	private UsersRepository userepositiory;
	
	@Override
	public void saveDetails(Users u) 
	{
		userepositiory.save(u);
		
	}

	@Override
	public Users findByUserName(String userName) 
	{
		
		return userepositiory.findByUserName(userName);
	}

	@Override
	public Users getByUId(int userId) 
	{
		Optional<Users>ou=userepositiory.findById(userId);
		if(ou.isPresent())
		{
			return ou.get();	
		}else
		{
			throw new EnquiryNotFoundException("Enquiry Not found For  This Id");	
		}
		
	}

	@Override
	public Users userLogin(int userId, String upassword) {
		Users ur=userepositiory.findByUserIdAndUpassword(userId,upassword);
		if(ur!=null && ur.getUpassword().equals(upassword))
		{
			return ur;
		}
		return null;
	}

	
	

	


}
