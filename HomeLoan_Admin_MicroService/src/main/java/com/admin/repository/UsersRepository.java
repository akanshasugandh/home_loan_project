package com.admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.CustomerRegForm;
import com.admin.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> 
{

	Users findByUserName(String userName);

	Users findByUserIdAndUpassword(int userId, String upassword);

	

	

}
