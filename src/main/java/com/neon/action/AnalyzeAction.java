package com.neon.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.Dvalue;
import com.neon.domain.Input;
import com.neon.util.ListToArray;

@Controller
@Scope("prototype")
public class AnalyzeAction extends ActionBase<Input>{
	private int y_quarter_1;
	private int y_quarter_2;
	private int m;
	private int y;
	private int y2;
	private int quarter_quarter_3;
	private int year_year_3;
	private Map<String,Object> result = new HashMap<String,Object>(); 
	private Map<String,Object> result1 = new HashMap<String,Object>(); 
	private Map<String,Object> result2 = new HashMap<String,Object>(); 
	//准备月份分析数据
	
	public String month(){
		
		return "month";
	}

	
	public String month_1(){
		//准备dvalue_double数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double dvalue_double = dva.getDdvalue();

		double[] range = {-10,20};


		List<Double> input_totlemoney_month = inputService.getInputTotleMoneyWithMonth(y);
		List<Double> output_totlemoney_month = outputService.getOutputTotleMoneyWithMonth(y);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_month,output_totlemoney_month);
		
		double[] input_totlemoney_month_array = ListToArray.getDoubleArray(input_totlemoney_month);
		double[] output_totlemoney_month_array = ListToArray.getDoubleArray(output_totlemoney_month);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		
		result.put("data_difference",dvalue_array);
 		result.put("data_input", input_totlemoney_month_array);
 		result.put("data_output", output_totlemoney_month_array);
 		result.put("dvalue_double", range);
		return "success";
	}
	
	public String month_2(){
		//第二张表的数据   output_everyGoodsTotleMoney_year
		System.out.println("m2");
		System.out.println(y2);
		int i=0;
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(y2);

		Map<String , double[]> output_everyGoodsTotleMoney_year = new HashMap<>();
		
		
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		int size = output_everyGoodsTotleMoney_year.keySet().size();
		String[] productName = new String[size];
		double[][] productVlaue = new double[size][12];
		Set<String> name = output_everyGoodsTotleMoney_year.keySet();
		
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_year.entrySet()){
			productName[i] = p.getKey();
			productVlaue[i] = p.getValue();
			
			i+=1;
		}
		
		result.put("productName", productName);
		result.put("productVlaue", productVlaue);
		return "success";
	}
	
	public String month_3(){
		System.out.println("month3");
		//第三张表的数据   output_percent_month_array
		System.out.println("月份："+m);
		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsTotleMoney(m, 2017);
		String output_percent_month_array[][] = ListToArray.getString2Array(output_percent_month);
		String test[][] = {{"猪肉罐头","50"},{"鱼肉罐头","20"},{"鸡肉罐头","30"}};
		result.put("test", test);
		return "success";

	}
	
	//准备季度分析数据
	public String quarter(){
		return "quarter";
	}

	public String quarter_1(){
		//准备dvalue_double数据
		System.out.println("年份："+y_quarter_1);
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double dvalue_double = dva.getDdvalue();
		double[] test = {20,60};		
		List<Double> input_totlemoney_quarter = inputService.getInputTotleMoneyWithQuarter(y_quarter_1);
		List<Double> output_totlemoney_quarter = outputService.getOutputTotleMoneyWithQuarter(y_quarter_1);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_quarter, output_totlemoney_quarter);
		
		double[] input_totlemoney_quarter_array = ListToArray.getDoubleArray(input_totlemoney_quarter);
		double[] output_totlemoney_quarter_array = ListToArray.getDoubleArray(output_totlemoney_quarter);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		for(double d:output_totlemoney_quarter_array){
			System.out.println(d);
		}
		result1.put("data_input_quarter", input_totlemoney_quarter_array);
		result1.put("data_output_quarter", output_totlemoney_quarter_array);
		result1.put("data_difference_quarter", dvalue_array);
		result1.put("dvalue_double", test);
		return "success_quarter";
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
		Map<String, Double> output_percent_quarter = outputService.getThisQuarterOutputGoodsTotleMoney(quarter_quarter_3, 2017);
		String output_percent_quarter_array[][] = ListToArray.getString2Array(output_percent_quarter);
		String test[][] = {{"猪肉罐头","25"},{"鱼肉罐头","25.5"},{"鸡肉罐头","49.5"}};
		result1.put("data_out_quarter_3", test);
		return "success_quarter";
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
		double[] range={-10,20};				
		System.out.println("year_1");		
		List<Double> input_totlemoney_year = inputService.getInputTotleMoneyWithYear();
		List<Double> output_totlemoney_year = outputService.getOutputTotleMoneyWithYear();
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_year, output_totlemoney_year);
				
		double[] input_totlemoney_year_array = ListToArray.getDoubleArray(input_totlemoney_year);
		double[] output_totlemoney_year_array = ListToArray.getDoubleArray(output_totlemoney_year);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		result2.put("data_difference_year", dvalue_array);
		result2.put("data_input_year", input_totlemoney_year_array);
		result2.put("data_output_year", output_totlemoney_year_array);
		result2.put("dvalue_double_year", range);
		return "success_year";
	}
	
	public String year_2(){
		System.out.println("year_2");
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getRecentYearsOutputGoodsTotleMoney();
		Map<String , double[]> output_everyGoodsTotleMoney_year = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		int i=0;
		int size = output_everyGoodsTotleMoney_year.keySet().size();
//		String[] productName = new String[size];
//		double[][] productVlaue = new double[size][6];
		String[] productName = {"猪肉罐头","鱼肉罐头","鸡肉罐头"};
		double[][] productVlaue = {{16, 18, 11, 13, 14, 8},{14, 8, 16, 18, 11, 13},{8, 16, 18, 11, 13, 14}};
		
//		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_year.entrySet()){
//			productName[i] = p.getKey();
//			productVlaue[i] = p.getValue();
//			for(double d:p.getValue()){
//				System.out.println(d);
//			}
//			i+=1;
//		}
		
		result2.put("productName", productName);
		result2.put("productVlaue", productVlaue);
		return "success_year";
	}

	public String year_3(){
		String test[][] = {{"猪肉罐头","10"},{"鱼肉罐头","25.5"},{"鸡肉罐头","64.5"}};
		result2.put("data_output_year_3", test);
		
		return "success_year";
//		Map<String, Double> output_percent_year = outputService.getThisYearOutputGoodsTotleMoney(2017);
//		System.out.println("hello");
//		String output_percent_year_array[][] = ListToArray.getString2Array(output_percent_year);
		
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
	
	
	public Map<String, Object> getResult1() {
		return result1;
	}


	public void setResult1(Map<String, Object> result1) {
		this.result1 = result1;
	}


	public Map<String, Object> getResult2() {
		return result2;
	}


	public void setResult2(Map<String, Object> result2) {
		this.result2 = result2;
	}


	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}


	public int getY2() {
		return y2;
	}


	public void setY2(int y2) {
		this.y2 = y2;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public int getY_quarter_1() {
		return y_quarter_1;
	}


	public void setY_quarter_1(int y_quarter_1) {
		this.y_quarter_1 = y_quarter_1;
	}


	public int getQuarter_quarter_3() {
		return quarter_quarter_3;
	}


	public void setQuarter_quarter_3(int quarter_quarter_3) {
		this.quarter_quarter_3 = quarter_quarter_3;
	}


	public int getY_quarter_2() {
		return y_quarter_2;
	}


	public void setY_quarter_2(int y_quarter_2) {
		this.y_quarter_2 = y_quarter_2;
	}


	public int getYear_year_3() {
		return year_year_3;
	}


	public void setYear_year_3(int year_year_3) {
		this.year_year_3 = year_year_3;
	}
	
}
