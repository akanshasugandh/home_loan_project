package com.admin.servicei;


import com.admin.model.Users;

public interface UsersServiceI 
{

	public void saveDetails(Users u);

	public Users findByUserName(String userName);

	public Users getByUId(int userId);

	public Users userLogin(int userId, String upassword);

	

	

	
}
