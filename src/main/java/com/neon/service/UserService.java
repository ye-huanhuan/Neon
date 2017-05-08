package com.neon.service;


import com.neon.base.DaoSupport;
import com.neon.domain.User;

public interface UserService extends DaoSupport<User>{

	boolean isNull(String username, String password);

	boolean login(String username, String password);
	
	
	
	User findUserByEmail(String email);

	User findUserByUsername(String username);
	
}
