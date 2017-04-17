package com.neon.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TestAction extends ActionBase<User>{

	public String hello(){   
		User user = userservice.getById(1L);
		ActionContext.getContext().put("user", user);
		return "hello";
	}
}
