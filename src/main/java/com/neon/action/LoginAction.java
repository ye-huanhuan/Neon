package com.neon.action;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.MailInfo;
import com.neon.domain.User;
import com.neon.service.impl.MailUtil;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class LoginAction extends ActionBase<User>{
	
	public String toLogin(){
		System.out.println(1);
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
		
	//jcaptcha
		String userCaptchaResponse = request.getParameter("jcaptcha");
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
		if(captchaPassed && userService.login(model.getUsername(),model.getPassword())){
			User user = userService.findUserByUsername(model.getUsername());
			ActionContext.getContext().getSession().put("user", user);
			return "success";
		}else{
			addFieldError("loginerror", "用户名或密码或验证码错误");
			return "login";
		}
	}
	
	public String login(){
		return "login";
		
	}
	
	public String passwordBack(){
		return "passwordBack";
	}
	
	public String toPasswordBack(){
		//产生一个长度为6的字符串
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < 6; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }
		//发送邮件	
	    Map<String,Object> session  = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String email = request.getParameter("email") + "@163.com";
		MailInfo info;  
	    String hostName = "smtp.163.com";  
	    info = new MailInfo(hostName, "13244237736@163.com", "ye7536830875");  
	    MailUtil.getMailFromList().add(info);  
	    boolean r = MailUtil.send("重置密码", MailInfo.MailType.HTML, "<h3>新密码为:"+sb.toString()+"</h3>"+"<a href='http://localhost:8080/Neon/'>返回登录</a>", email, "", "");  
	    MailUtil.getLogger().info(r);
	    if(r){
	    	addFieldError("sendMessage", "发送成功请及时查收！");
	    	return "sendSuccess";
	    }else{
	    	addFieldError("sendMessage", "发送失败请输入正确的邮箱！");
	    	return "sendFail";
	    }
	    
	}
}
