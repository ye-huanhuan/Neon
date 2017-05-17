package com.neon.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.User;
import com.neon.util.ListToArray;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TestAction extends ActionBase<User>{
	private Map<String,Object> result = new HashMap<String,Object>();
	private int year;
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
	
	public String testJson(){
		System.out.println(year);
		List<Double> input_totlemoney_month = inputService.getInputTotleMoneyWithMonth(year);
		List<Double> output_totlemoney_month = outputService.getOutputTotleMoneyWithMonth(year);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_month,output_totlemoney_month);
		int[] data_difference = {1,2,-1,4,5,-3};
		double[] data_input = { 15.5, 16, 15.3, 11, 12, 8};
		int[] data_output = { 16, 18, 11, 13, 14, 8};
		double[] test = ListToArray.getDoubleArray(output_totlemoney_month);
		result.put("data_difference", data_difference);
		result.put("data_input", data_input);
 		result.put("data_output", data_output);
 		System.out.println(data_difference);
//		result.put("2",-2);
//		result.put("3",2);
//		result.put("4",-1);
//		result.put("5",4);
//		result.put("6",6);
//		result.put("7",-5);
//		result.put("8",6);
//		result.put("9",-5);
//		result.put("10",6);
//		result.put("11",-5);
//		result.put("12", 2);
		return "success";
	}
	public Map getResult() {
		return result;
	}
	public void setResult(Map result) {
		this.result = result;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
