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
		System.out.println("我执行了");
		ActionContext.getContext().put("user", "yhh");
		return "hello";
	}
	public String index(){
//		User user = userservice.getById(1L);
		ActionContext.getContext().getSession().put("user", "yhh");
		System.out.println("执行了");
		return "success";
	}
}
