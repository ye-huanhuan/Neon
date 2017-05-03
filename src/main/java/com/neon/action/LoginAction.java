package com.neon.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class LoginAction extends ActionBase<User>{
	
	public String login(){
		Cookie[] cookies ;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		if("isRemember".equals(request.getParameter("remember"))){
			Cookie c1 = new Cookie("username", model.getUsername());
			Cookie c2 = new Cookie("password",model.getPassword());
			c1.setMaxAge(60*60*24*3);
			c2.setMaxAge(60*60*24*3);
			response.addCookie(c1);;
			response.addCookie(c2);
		}else{
			cookies = request.getCookies();
			for(Cookie c : cookies){
				if("username".equals(c.getName())){
					c.setMaxAge(0);
				}else if("password".equals(c.getName())){
					c.setMaxAge(0);
				}
				response.addCookie(c);
			}
		}
		
		
		return "login";
	}
	
	public String toLogin(){
		return "login";
		
	}
		
	
}
