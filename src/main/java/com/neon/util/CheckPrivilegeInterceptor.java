package com.neon.util;

import com.neon.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckPrivilegeInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*System.out.println("--------->之前");
		String str = invocation.invoke(); //放行
		System.out.println("--------->之后");
		return str;*/
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		String privil_url = invocation.getProxy().getActionName()+".action";
		if(user == null){
			if(privil_url.equals("log_toLogin.action")){
				return invocation.invoke();
			}else{
				return "login";
			}
		}else{
			if(user.hasPrivilegeByAction(privil_url)){
				return invocation.invoke();
			}else{
				return "noPrivilege";
			}
		}
	}

}
