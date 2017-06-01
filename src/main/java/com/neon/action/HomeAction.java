package com.neon.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.neon.base.ActionBase;
import com.neon.domain.Dvalue;
import com.neon.domain.User;

@Controller
@Scope("prototype")
public class HomeAction extends ActionBase<User>{

	public String index(){
		return "index";
	}
	
	public String detail(){
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		//准备数据
		double[] target = dvalueService.getCurrentTargets(dva);
		for(double d : target){
			
			System.out.println(d);
		}
		return "detail";
	}
}
