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
import com.neon.domain.Dvalue;
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
		

		//准备dvalue_double数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double dvalue_double = dva.getDdvalue();
		
		System.out.println(year);

		List<Double> input_totlemoney_month = inputService.getInputTotleMoneyWithMonth(year);
		List<Double> output_totlemoney_month = outputService.getOutputTotleMoneyWithMonth(year);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_month,output_totlemoney_month);

		double[] input_totlemoney_month_array = ListToArray.getDoubleArray(input_totlemoney_month);
		double[] output_totlemoney_month_array = ListToArray.getDoubleArray(output_totlemoney_month);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		
		result.put("data_difference",dvalue_array);
 		result.put("data_input", input_totlemoney_month_array);
 		result.put("data_output", output_totlemoney_month_array);

		
		
		return "month";
	}
	
	public String month_2(){
		//第二张表的数据   output_everyGoodsTotleMoney_year
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(year);
		Map<String , double[]> output_everyGoodsTotleMoney_year = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		return "month";
	}
	
	public String month_3(){
		
		//第三张表的数据   output_percent_month_array
		int month = 1;

		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsTotleMoney(month, year);
		String output_percent_month_array[][] = ListToArray.getString2Array(output_percent_month);
		return "month";

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
