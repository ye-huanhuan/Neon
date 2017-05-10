package com.neon.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.Input;

@Controller
@Scope("prototype")
public class AnalyzeAction extends ActionBase<Input>{

	public String analyze(){
	/*	List<Double> totlemoney = inputService.getInputTotleMoneyWithMonth();
		for(Double money : totlemoney){
			System.out.println(money);
		}*/
		return "analyze";
	}
}
