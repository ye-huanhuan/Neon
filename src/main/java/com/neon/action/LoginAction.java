package com.neon.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.User;

@Controller
@Scope("prototype")
public class LoginAction extends ActionBase<User>{
	
	public String login(){
		
		return "login";
	}
	
	public String toLogin(){
		return "";
		
	}
		
	
}
