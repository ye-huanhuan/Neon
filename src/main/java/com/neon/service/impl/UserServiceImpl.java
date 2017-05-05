package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.User;
import com.neon.service.UserService;
import com.neon.util.Md5;

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

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if(findByUsername(username).getPassword().equals(Md5.getMD5(password))){
			return true;
		}
		return false;
	}

	private User findByUsername(String username) {
		return (User) getSession().createQuery(//
				"FROM User user WHERE user.username=?")
				.setParameter(0, username)
				.uniqueResult();
	}

	@Override
	public User findUserByUsername(String username) {
		return (User) getSession().createQuery(//
				"FROM User user WHERE user.username=?")
				.setParameter(0, username)
				.uniqueResult();
	}
		
	
}
