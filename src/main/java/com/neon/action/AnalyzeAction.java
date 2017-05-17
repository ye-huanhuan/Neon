package com.neon.action;

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

	private int y;

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
		
		System.out.println(y);

		List<Double> input_totlemoney_month = inputService.getInputTotleMoneyWithMonth(y);
		List<Double> output_totlemoney_month = outputService.getOutputTotleMoneyWithMonth(y);
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
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(y);
		Map<String , double[]> output_everyGoodsTotleMoney_year = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		return "month";
	}
	
	public String month_3(){
		
		//第三张表的数据   output_percent_month_array
		int month = 1;

		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsTotleMoney(month, y);
		String output_percent_month_array[][] = ListToArray.getString2Array(output_percent_month);
		return "month";

	}
	
	//准备季度分析数据
	public String quarter(){
		return "quarter";
	}
	
	public String quarter_1(){
		//准备dvalue_double数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double dvalue_double = dva.getDdvalue();
				
		System.out.println(y);
		
		List<Double> input_totlemoney_quarter = inputService.getInputTotleMoneyWithQuarter(y);
		List<Double> output_totlemoney_quarter = outputService.getOutputTotleMoneyWithQuarter(y);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_quarter, output_totlemoney_quarter);
		
		double[] input_totlemoney_quarter_array = ListToArray.getDoubleArray(input_totlemoney_quarter);
		double[] output_totlemoney_quarter_array = ListToArray.getDoubleArray(output_totlemoney_quarter);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		
		return "quarter";
	}
	
	public String quarter_2(){
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputQuarterTotleMoneyWithYear(y);
		Map<String , double[]> output_everyGoodsTotleMoney_quarter = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_quarter.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		//测试
		/*for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_quarter.entrySet()){
			System.out.println(p.getKey());
			for(double d : p.getValue()){
				System.out.println(d);
			}
		}*/
		return "quarter";
	}
	
	public String quarter_3(){
		//第三张表的数据   output_percent_month_array
		int quarter = 1;

		Map<String, Double> output_percent_quarter = outputService.getThisQuarterOutputGoodsTotleMoney(quarter, y);
		String output_percent_quarter_array[][] = ListToArray.getString2Array(output_percent_quarter);

		return "quarter";
	}
	
	//准备年份分析数据
	public String year(){
		return "year";
	}
	
	public String year_1(){
		//准备dvalue_double数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double dvalue_double = dva.getDdvalue();
						
		System.out.println(y);
				
		List<Double> input_totlemoney_year = inputService.getInputTotleMoneyWithYear();
		List<Double> output_totlemoney_year = outputService.getOutputTotleMoneyWithYear();
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_year, output_totlemoney_year);
				
		double[] input_totlemoney_year_array = ListToArray.getDoubleArray(input_totlemoney_year);
		double[] output_totlemoney_year_array = ListToArray.getDoubleArray(output_totlemoney_year);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		
		return "success";
	}
	
	public String year_2(){
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getRecentYearsOutputGoodsTotleMoney();
		Map<String , double[]> output_everyGoodsTotleMoney_year = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		return "quarter";
	}

	public String year_3(){
		Map<String, Double> output_percent_year = outputService.getThisYearOutputGoodsTotleMoney(y);
		String output_percent_year_array[][] = ListToArray.getString2Array(output_percent_year);
		return "year";
	}
	
	//准备税收分析数据
	public String tax(){
		return "tax";
	}



	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	
}
