package com.neon.action;

import java.util.Calendar;
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
import com.neon.util.Constant;
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
		System.out.println("month_1");
		//准备dvalue_double数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double[] range = dvalueService.getPdvalueAndNdvalue_month(dva);
		
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
	//近十二个月数据
	public String month_1_other(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		//准备dvalue_double数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		System.out.println("dva:"+dva);
		double[] range = dvalueService.getPdvalueAndNdvalue_month(dva);
		
		for(double d : range){
			
			System.out.println(d);
		}
		/*System.out.println("test");
		System.out.println("min:"+range[0]);
		System.out.println(y);*/
		List<Double> input_totlemoney_month = inputService.getInputTotleMoneyWithMonth(year-1);
		List<Double> output_totlemoney_month = outputService.getOutputTotleMoneyWithMonth(year-1);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_month,output_totlemoney_month);
		double[] input_totlemoney_month_array = ListToArray.getDoubleArray(input_totlemoney_month);
		double[] output_totlemoney_month_array = ListToArray.getDoubleArray(output_totlemoney_month);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		List<Double> input_totlemoney_month_2 = inputService.getInputTotleMoneyWithMonth(year);
		List<Double> output_totlemoney_month_2 = outputService.getOutputTotleMoneyWithMonth(year);
		List<Double> dvalue_2 = outputService.getDvalue(input_totlemoney_month_2,output_totlemoney_month_2);
		double[] input_totlemoney_month_array_2 = ListToArray.getDoubleArray(input_totlemoney_month_2);
		double[] output_totlemoney_month_array_2 = ListToArray.getDoubleArray(output_totlemoney_month_2);
		double[] dvalue_array_2 = ListToArray.getDoubleArray(dvalue_2);
		String[] months = {"第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月"};
		if(month == 1){
			String[] replace = {"第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月"};
			months = replace;
		}else if(month == 2){
			String[] replace = {"第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月"};
			months = replace;
		}else if(month == 3){
			String[] replace = {"第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月"};
			months = replace;
		}else if(month == 4){
			String[] replace = {"第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月"};
			months = replace;
		}else if(month == 5){
			String[] replace = {"第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月"};
			months = replace;
		}else if(month == 6){
			String[] replace = {"第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月"};
			months = replace;
		}else if(month == 7){
			String[] replace = {"第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月"};
			months = replace;
		}else if(month == 8){
			String[] replace = {"第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月"};
			months = replace;
		}else if(month == 9){
			String[] replace = {"第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月"};
			months = replace;
		}else if(month == 10){
			String[] replace = {"第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月"};
			months = replace;
		}else if(month == 11){
			String[] replace = {"第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月"};
			months = replace;
		}else{
			String[] replace = {"第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月"};
			months = replace;
		}
		for(int i=0,j=0;i<input_totlemoney_month_array.length;i++){
			if(i>=month){
				input_totlemoney_month_array[j] = input_totlemoney_month_array[i];
				output_totlemoney_month_array[j] = output_totlemoney_month_array[i];
				dvalue_array[j] = dvalue_array[i];
				j++;
			}
		}
		for(int i=0,j=12-month;i<input_totlemoney_month_array_2.length;i++){
			if(i<=month-1){
				input_totlemoney_month_array[j] = input_totlemoney_month_array_2[i];
				output_totlemoney_month_array[j] = output_totlemoney_month_array_2[i];
				dvalue_array[j] = dvalue_array_2[i];
				j++;
			}
		}
		result.put("data_difference",dvalue_array);
 		result.put("data_input", input_totlemoney_month_array);
 		result.put("data_output", output_totlemoney_month_array);
 		result.put("dvalue_double", range);
 		result.put("data_month", months);
		return "success";
	}
	
	public String month_2(){
		//第二张表的数据   output_everyGoodsTotleMoney_year
		System.out.println("month_2");
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
		//产品名称数组
		result.put("productName", productName);
		//产品值数组
		result.put("productVlaue", productVlaue);
		return "success";
	}
	
	public String month_2_other(){
		//第二张表的数据   output_everyGoodsTotleMoney_year
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int i=0;
		String[] months = {"第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月"};
		if(month == 1){
			String[] replace = {"第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月"};
			months = replace;
		}else if(month == 2){
			String[] replace = {"第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月"};
			months = replace;
		}else if(month == 3){
			String[] replace = {"第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月"};
			months = replace;
		}else if(month == 4){
			String[] replace = {"第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月"};
			months = replace;
		}else if(month == 5){
			String[] replace = {"第六月","第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月"};
			months = replace;
		}else if(month == 6){
			String[] replace = {"第七月","第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月"};
			months = replace;
		}else if(month == 7){
			String[] replace = {"第八月","第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月"};
			months = replace;
		}else if(month == 8){
			String[] replace = {"第九月","第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月"};
			months = replace;
		}else if(month == 9){
			String[] replace = {"第十月","第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月"};
			months = replace;
		}else if(month == 10){
			String[] replace = {"第十一月","第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月"};
			months = replace;
		}else if(month == 11){
			String[] replace = {"第十二月","第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月"};
			months = replace;
		}else{
			String[] replace = {"第一月","第二月","第三月","第四月","第五月","第六月","第七月","第八月","第九月","第十月","第十一月","第十二月"};
			months = replace;
		}
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(year-1);
		Map<String , double[]> output_everyGoodsTotleMoney_year = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		Map<String, List<Double>> output_everyGoodsTotleMoney_2 = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(year);
		Map<String , double[]> output_everyGoodsTotleMoney_year_2 = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney_2.entrySet()){
			output_everyGoodsTotleMoney_year_2.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		int size = output_everyGoodsTotleMoney_year.keySet().size();
		String[] productName = new String[size];
		double[][] productVlaue = new double[size][12];
		Set<String> name = output_everyGoodsTotleMoney_year.keySet();
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_year.entrySet()){
			for(int m=0,n=0;m<p.getValue().length;m++){
				if(m>=month){
					productVlaue[i][n] = p.getValue()[m];
					n++;
				}
			}
			i+=1;
		}
		i=0;
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_year_2.entrySet()){
			productName[i] = p.getKey();
			for(int m=0,n=12-month;m<p.getValue().length;m++){
				if(m<=month-1){
					productVlaue[i][n] = p.getValue()[m];
					n++;
				}
			}
			i+=1;
		}
		//产品名称数组
		result.put("productName", productName);
		//产品值数组
		result.put("productVlaue", productVlaue);
		//月份
		result.put("months", months);
		return "success";
	}
	
	public String month_3(){
		System.out.println("month_3");
		//第三张表的数据   output_percent_month_array
		System.out.println("月份："+m);
		Map<String, Double> output_top3_month = outputService.getThisMonthTop3GoodsMoney(m, Constant.YEAR);
		//准备数据
		String[] output_top3_key = outputService.getItemByMap(output_top3_month);
		double[] output_top3_value = outputService.getValueByMap(output_top3_month);
		//测试
		//		for(int i = 0 ; i < 3 ; i++){
//			System.out.println(output_top3_key[i] + " " + output_top3_value[i] );
//		}
		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsTotleMoney(m, Constant.YEAR);
		String output_percent_month_array[][] = ListToArray.getString2Array(output_percent_month);
		result.put("data_output_month_3", output_percent_month_array);
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
		System.out.println("dva:"+dva);
		double[] range = dvalueService.getPdvalueAndNdvalue_quarter(dva);
//		double[] test = {20,60};		
		List<Double> input_totlemoney_quarter = inputService.getInputTotleMoneyWithQuarter(y_quarter_1);
		List<Double> output_totlemoney_quarter = outputService.getOutputTotleMoneyWithQuarter(y_quarter_1);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_quarter, output_totlemoney_quarter);
		double[] input_totlemoney_quarter_array = ListToArray.getDoubleArray(input_totlemoney_quarter);
		double[] output_totlemoney_quarter_array = ListToArray.getDoubleArray(output_totlemoney_quarter);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		result1.put("data_input_quarter", input_totlemoney_quarter_array);
		result1.put("data_output_quarter", output_totlemoney_quarter_array);
		result1.put("data_difference_quarter", dvalue_array);
		result1.put("dvalue_double", range);
		return "success_quarter";
	}
	//近四个季度的数据
	public String quarter_1_other(){
		//准备dvalue_double数据
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int quarter = 1;
		if(month == 1||month == 2||month==3){
			quarter = 1;
		}else if(month == 4||month == 5||month == 6){
			quarter = 2;
		}else if(month == 7 ||month == 8 || month ==9){
			quarter = 3;
		}else{
			quarter = 4;
		}
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dva = dvalueService.getById(id);
		double[] range = dvalueService.getPdvalueAndNdvalue_quarter(dva);
		List<Double> input_totlemoney_quarter = inputService.getInputTotleMoneyWithQuarter(year-1);
		List<Double> output_totlemoney_quarter = outputService.getOutputTotleMoneyWithQuarter(year-1);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_quarter, output_totlemoney_quarter);
		double[] input_totlemoney_quarter_array = ListToArray.getDoubleArray(input_totlemoney_quarter);
		double[] output_totlemoney_quarter_array = ListToArray.getDoubleArray(output_totlemoney_quarter);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		List<Double> input_totlemoney_quarter_2 = inputService.getInputTotleMoneyWithQuarter(year);
		List<Double> output_totlemoney_quarter_2 = outputService.getOutputTotleMoneyWithQuarter(year);
		List<Double> dvalue_2 = outputService.getDvalue(input_totlemoney_quarter_2, output_totlemoney_quarter_2);
		double[] input_totlemoney_quarter_array_2 = ListToArray.getDoubleArray(input_totlemoney_quarter_2);
		double[] output_totlemoney_quarter_array_2 = ListToArray.getDoubleArray(output_totlemoney_quarter_2);
		double[] dvalue_array_2 = ListToArray.getDoubleArray(dvalue_2);
		String[] quarters = {"第一季度","第二季度","第三季度","第四季度"};
		
		if(quarter == 1){
			String[] replace = {"第二季度","第三季度","第四季度","第一季度"};
			quarters = replace;
		}else if(quarter == 2){
			String[] replace = {"第三季度","第四季度","第一季度","第二季度"};
			quarters = replace;
		}else if(quarter == 3){
			String[] replace = {"第四季度","第一季度","第二季度","第三季度"};
			quarters = replace;
		}else{
			String[] replace = {"第一季度","第二季度","第三季度","第四季度"};
			quarters = replace;
		}
		for(int i=0,j=0;i<input_totlemoney_quarter_array.length;i++){
			if(i>=quarter){
				input_totlemoney_quarter_array[j] = input_totlemoney_quarter_array[i];
				output_totlemoney_quarter_array[j] = output_totlemoney_quarter_array[i];
				dvalue_array[j] = dvalue_array[i];
				j++;
			}
		}
		for(int i=0,j=4-quarter;i<input_totlemoney_quarter_array_2.length;i++){
			if(i<=quarter-1){
				input_totlemoney_quarter_array[j] = input_totlemoney_quarter_array_2[i];
				output_totlemoney_quarter_array[j] = output_totlemoney_quarter_array_2[i];
				dvalue_array[j] = dvalue_array_2[i];
				j++;
			}
		}
		result1.put("data_input_quarter", input_totlemoney_quarter_array);
		result1.put("data_output_quarter", output_totlemoney_quarter_array);
		result1.put("data_difference_quarter", dvalue_array);
		result1.put("dvalue_double", range);
		result1.put("data_quarters", quarters);
		return "success_quarter";
	}
	
	public String quarter_2(){
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputQuarterTotleMoneyWithYear(y_quarter_2);
		Map<String , double[]> output_everyGoodsTotleMoney_quarter = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_quarter.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		int i=0;
		int size = output_everyGoodsTotleMoney_quarter.keySet().size();
		String[] productName = new String[size];
		double[][] productVlaue = new double[size][4];
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_quarter.entrySet()){
			productName[i] = p.getKey();
			productVlaue[i] = p.getValue();
			i+=1;
		}
		result1.put("productName", productName);
		result1.put("productVlaue", productVlaue);
		return "success_quarter";
	}
	//准备近四个季度的数据
	public String quarter_2_other(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int quarter = 1;
		if(month == 1||month == 2||month==3){
			quarter = 1;
		}else if(month == 4||month == 5||month == 6){
			quarter = 2;
		}else if(month == 7 ||month == 8 || month ==9){
			quarter = 3;
		}else{
			quarter = 4;
		}
		String[] quarters = {"第一季度","第二季度","第三季度","第四季度"};
		
		if(quarter == 1){
			String[] replace = {"第二季度","第三季度","第四季度","第一季度"};
			quarters = replace;
		}else if(quarter == 2){
			String[] replace = {"第三季度","第四季度","第一季度","第二季度"};
			quarters = replace;
		}else if(quarter == 3){
			String[] replace = {"第四季度","第一季度","第二季度","第三季度"};
			quarters = replace;
		}else{
			String[] replace = {"第一季度","第二季度","第三季度","第四季度"};
			quarters = replace;
		}
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputQuarterTotleMoneyWithYear(year-1);
		Map<String , double[]> output_everyGoodsTotleMoney_quarter = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_quarter.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		Map<String, List<Double>> output_everyGoodsTotleMoney_2 = outputService.getEveryGoodsgetOutputQuarterTotleMoneyWithYear(year);
		Map<String , double[]> output_everyGoodsTotleMoney_quarter_2 = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney_2.entrySet()){
			output_everyGoodsTotleMoney_quarter_2.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		int i=0;
		int size = output_everyGoodsTotleMoney_quarter.keySet().size();
		String[] productName = new String[size];
		double[][] productVlaue = new double[size][4];
		
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_quarter.entrySet()){
			for(int m=0,n=0;m<p.getValue().length;m++){
				if(m>=quarter){
					productVlaue[i][n] = p.getValue()[m];
					n++;
				}
			}
			i+=1;
		}
		i=0;
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_quarter_2.entrySet()){
			productName[i] = p.getKey();
			for(int m=0,n=4-quarter;m<p.getValue().length;m++){
				if(m<=quarter-1){
					productVlaue[i][n] = p.getValue()[m];
					n++;
				}
			}
			i+=1;
		}
		result1.put("productName", productName);
		result1.put("productVlaue", productVlaue);
		result1.put("data_quarters", quarters);
		return "success_quarter";
	}
	
	//所有季度数据一样
	public String quarter_3(){
		//第三张表的数据   output_percent_month_array
		System.out.println(quarter_quarter_3);
		Map<String, Double> output_percent_quarter = outputService.getThisQuarterOutputGoodsTotleMoney(quarter_quarter_3, Constant.YEAR);
		String output_percent_quarter_array[][] = ListToArray.getString2Array(output_percent_quarter);
		String test[][] = {{"猪肉罐头","25"},{"鱼肉罐头","100"},{"鸡肉罐头","49.5"}};
		result1.put("data_out_quarter_3", output_percent_quarter_array);
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
		double[] range = dvalueService.getPdvalueAndNdvalue_year(dva);
		System.out.println("year_1");		

		List<Double> input_totlemoney_year = inputService.getInputTotleMoneyWithYear();
		List<Double> output_totlemoney_year = outputService.getOutputTotleMoneyWithYear();
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_year, output_totlemoney_year);
				
		double[] input_totlemoney_year_array = ListToArray.getDoubleArray2(input_totlemoney_year);
		double[] output_totlemoney_year_array = ListToArray.getDoubleArray2(output_totlemoney_year);
		double[] dvalue_array = ListToArray.getDoubleArray2(dvalue);
		
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
			output_everyGoodsTotleMoney_year.put(map.getKey(), ListToArray.getDoubleArray2(map.getValue()));
		}
		int i=0;
		int size = output_everyGoodsTotleMoney_year.keySet().size();
		String[] productName = new String[size];
		double[][] productVlaue = new double[size][6];
//		String[] productName = {"猪肉罐头","鱼肉罐头","鸡肉罐头","牛肉罐头"};
//		double[][] productVlaue = {{16, 18, 11, 13, 14, 8},{14, 8, 16, 18, 11, 13},{8, 16, 18, 11, 13, 14},{18,14, 8, 16, 11, 13}};
		
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_year.entrySet()){
			productName[i] = p.getKey();
			productVlaue[i] = p.getValue();
			for(double d:p.getValue()){
				System.out.println(d);
			}
			i+=1;
		}
		result2.put("productName", productName);
		result2.put("productVlaue", productVlaue);
		return "success_year";
	}
	
	public String year_3(){
		System.out.println("year3:"+year_year_3);
		Map<String, Double> output_percent_year = outputService.getThisYearOutputGoodsTotleMoney(year_year_3);
		System.out.println(output_percent_year.size());
		String output_percent_year_array[][] = ListToArray.getString2Array(output_percent_year);
		for(int i = 0 ; i < output_percent_year.size() ; i++){
			for(int j = 0 ; j< 2 ; j++){
				System.out.println(output_percent_year_array[i][j]);
			}
		}
		result2.put("data_output_year_3", output_percent_year_array);
		return "success_year";

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
