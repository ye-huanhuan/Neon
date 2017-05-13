package com.neon.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.Input;
import com.neon.util.ListToArray;

@Controller
@Scope("prototype")
public class AnalyzeAction extends ActionBase<Input>{

	private int year;
	private Map<String,Object> result = new HashMap<String,Object>(); 
	//准备月份分析数据
	
	public String month(){
		
		return "month";
	}

	
	public String month_1(){
		
		System.out.println(year);
		//第一张表的数据
		Date date = new Date();
		//今年
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date).toString());
		List<Double> input_totlemoney_month = inputService.getInputTotleMoneyWithMonth(year);
		List<Double> output_totlemoney_month = outputService.getOutputTotleMoneyWithMonth(year);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_month,output_totlemoney_month);
		Double[] input_totlemoney_month_array = (Double[]) input_totlemoney_month.toArray(new Double[input_totlemoney_month.size()]);
		Double[] output_totlemoney_month_array = (Double[]) output_totlemoney_month.toArray(new Double[output_totlemoney_month.size()]);
		Double[] dvalue_array = (Double[]) dvalue.toArray(new Double[dvalue.size()]);

		double[] test = ListToArray.getDoubleArray(input_totlemoney_month);
		result.put("data_difference",dvalue_array);
 		result.put("data_input", test);
 		result.put("data_output", output_totlemoney_month_array);
		System.out.println(input_totlemoney_month);
		System.out.println(output_totlemoney_month);
		System.out.println(dvalue);
		
		
		
		return "month";
	}
	
	public String month_2(){
		//第二张表的数据
		int year = 2017;
		Map<String, List<Double>> output_everyGoodsTotleMoney_year = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(year);
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney_year.entrySet()){
			System.out.println(map.getKey()+" "+map.getValue());
		}
		return "month";
	}
	
	public String month_3(){
		
		//第三张表的数据
		int month = 1;
		int year = 2017;
		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsPercent(month, year);
		for(Map.Entry<String, Double> map :output_percent_month.entrySet()){
			System.out.println(map.getKey()+" "+map.getValue());
		}
		
		return "success";
	}
	
	//准备季度分析数据
	public String quarter(){
		return "quarter";
	}
	
	//准备年份分析数据
	public String year(){
		return "year";
	}
	
	//准备税收分析数据
	public String tax(){
		return "tax";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
}
