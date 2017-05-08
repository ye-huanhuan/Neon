package com.neon.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.User;
import com.neon.util.Md5;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends ActionBase<User>{

	/**
	 * 用户设置自己的信息
	 * @return
	 */
	public String setUp(){
		//准备回显数据
		User user = (User) ActionContext.getContext().getSession().get("user");
		ActionContext.getContext().getValueStack().push(user);
		return "setUp";
	}
	
	public String toSetUp(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(model.getPassword() != ""){
			user.setPassword(Md5.getMD5(model.getPassword()));
		}
		user.setEmail(model.getEmail());
		user.setUsername(model.getUsername());
		userService.update(user);
		return "setUp";
	}
	
	
}
