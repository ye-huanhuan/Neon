package com.neon.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.User;

@Controller
@Scope("prototype")
public class AnalyzeAction extends ActionBase<User>{

	public String analyze(){
		return "analyze";
	}
}
