package com.neon.action;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.neon.base.ActionBase;
import com.neon.domain.Dvalue;
import com.neon.domain.User;

@Controller
@Scope("prototype")
public class HomeAction extends ActionBase<User>{
	private Map<String,Object> result1 = new HashMap<String,Object>(); 
	
	public String index(){
		return "index";
	}
	
	public String detail(){
		System.out.println("次数");
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		//准备数据
		double[] target = dvalueService.getCurrentTargets(dva);
		result1.put("data_target", target);
		return "detail";
	}

	public Map<String, Object> getResult1() {
		return result1;
	}

	public void setResult1(Map<String, Object> result1) {
		this.result1 = result1;
	}
	
	
}
