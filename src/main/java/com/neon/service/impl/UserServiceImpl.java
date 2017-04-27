package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.User;
import com.neon.service.UserService;

@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

	@Override
	public boolean isNull(String username, String password) {
		// TODO Auto-generated method stub
		if(username == null|| password == null || "".equals(username) || "".equals(password)){
			return false;
		}else{
			return true;
		}
		
	}
		
	
}
