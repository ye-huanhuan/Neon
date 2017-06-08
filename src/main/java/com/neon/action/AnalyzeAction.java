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
import com.neon.domain.Output;
import com.neon.util.ChangeLength;
import com.neon.util.Constant;
import com.neon.util.ListToArray;
import com.zyujie.dm.LinearRegression;

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
	private String outputItem;
	private Map<String,Object> result = new HashMap<String,Object>(); 
	private Map<String,Object> result1 = new HashMap<String,Object>(); 
	private Map<String,Object> result2 = new HashMap<String,Object>();
	private Map<String,Object> result3 = new HashMap<String,Object>();
	//获取当前日期
	Calendar cal = Calendar.getInstance();
	int current_year = cal.get(Calendar.YEAR);
	//准备月份分析数据
	
	public String month(){
		return "month";
	}

	public String month_1(){
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
		//将零值去除
		if(y == current_year){
			input_totlemoney_month_array = ChangeLength.changeLength(input_totlemoney_month_array);
			output_totlemoney_month_array = ChangeLength.changeLength(output_totlemoney_month_array);
		}
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
		//将零值去除
		input_totlemoney_month_array = ChangeLength.changeLength(input_totlemoney_month_array);
		output_totlemoney_month_array = ChangeLength.changeLength(output_totlemoney_month_array);
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
		//将零值去除
		if(y2 == current_year){
			for(int j=0;j<productVlaue.length;j++){
				productVlaue[j] = ChangeLength.changeLength(productVlaue[j]);
			}
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
		System.out.println(output_everyGoodsTotleMoney_year_2.size() + "===");
		int size = output_everyGoodsTotleMoney_year_2.keySet().size();
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
			System.out.println(i);
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
		//第三张表的数据   output_percent_month_array
		//如果是大于等于当前月份就查询去年的值
		int query_year = Constant.YEAR;
		if(m>=Constant.CURRENTMONTH){
			query_year -= 1;
		}
		Map<String, Double> output_top3_month = outputService.getThisMonthTop3GoodsMoney(m, query_year);
		//准备数据
		String[] output_top3_key = outputService.getItemByMap(output_top3_month);
		double[] output_top3_value = outputService.getValueByMap(output_top3_month);
		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsTotleMoney(m, query_year);
		String output_percent_month_array[][] = ListToArray.getString2Array(output_percent_month);
		result.put("data_output_month_3_key", output_top3_key);
		result.put("data_output_month_3_value", output_top3_value);
		result.put("data_output_month_3", output_percent_month_array);
		return "success";
	}
	
	//出项同比数据 
	public String month_4(){
		int query_month = Constant.CURRENTMONTH;
		int query_year = Constant.YEAR;
		if(Constant.CURRENTMONTH == 1){
			query_month = 13;
			query_year = Constant.YEAR - 1;
		}
		Map<String, Double> map_thisYear = outputService.getThisMonthOutputGoodsTotleMoney(query_month - 1, query_year);
		Map<String, Double> map_lastYear = outputService.getThisMonthOutputGoodsTotleMoney(query_month - 1, query_year - 1);
		//bug
		String[] items = ListToArray.getItemsArray(map_thisYear , map_lastYear);
		double[] thisYear_moeny = outputService.getThisMonthOutputGoodsTotleMoney(query_month - 1 , query_year , items);
		double[] lastYear_money = outputService.getThisMonthOutputGoodsTotleMoney(query_month - 1, query_year - 1 , items);
		
//		for(int i = 0 ; i < items.length ; i++){
//			System.out.println(items[i] + "今年" + thisYear_moeny[i] + "  去年" + lastYear_money[i]);
//		}
		result.put("items_month_4", items);
		result.put("thisYear_moeny_month_4", thisYear_moeny);
		result.put("lastYear_money_month_4", lastYear_money);
		return "success";
	}
	
	//进项同比数据 
	public String month_5(){
		int query_month = Constant.CURRENTMONTH;
		int query_year = Constant.YEAR;
		if(Constant.CURRENTMONTH == 1){
			query_month = 13;
			query_year = Constant.YEAR - 1;
		}
		Map<String, Double> map_thisYear = inputService.getThisMonthOutputGoodsTotleMoney(query_month - 1, query_year);
		Map<String, Double> map_lastYear = inputService.getThisMonthOutputGoodsTotleMoney(query_month - 1, query_year - 1);
		String[] item = ListToArray.getItemsArray(map_thisYear , map_lastYear);
		String[] items = inoutService.getInputItemByOutputItem(item);
		//进项同比数据
		double[] thisYear_moeny = inputService.getThisMonthInputGoodsTotleMoney(query_month - 1, query_year , items);
		double[] lastYear_money = inputService.getThisMonthInputGoodsTotleMoney(query_month - 1, query_year - 1 , items);
		
		//测试
		for(int i = 0 ; i < items.length ; i++){
			System.out.println(items[i] + "今年" + thisYear_moeny[i] + "  去年" + lastYear_money[i]);
		}
		result.put("input_items_month_4", items);
		result.put("input_thisYear_moeny_month_4", thisYear_moeny);
		result.put("input_lastYear_money_month_4", lastYear_money);

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
		List<Double> input_totlemoney_quarter = inputService.getInputTotleMoneyWithQuarter(y_quarter_1);
		List<Double> output_totlemoney_quarter = outputService.getOutputTotleMoneyWithQuarter(y_quarter_1);
		List<Double> dvalue = outputService.getDvalue(input_totlemoney_quarter, output_totlemoney_quarter);
		double[] input_totlemoney_quarter_array = ListToArray.getDoubleArray(input_totlemoney_quarter);
		double[] output_totlemoney_quarter_array = ListToArray.getDoubleArray(output_totlemoney_quarter);
		double[] dvalue_array = ListToArray.getDoubleArray(dvalue);
		//去除零值
		if(y_quarter_1 == current_year){
			input_totlemoney_quarter_array = ChangeLength.changeLength(input_totlemoney_quarter_array);
			output_totlemoney_quarter_array = ChangeLength.changeLength(output_totlemoney_quarter_array);
		}
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
		System.out.println("quarter_range"+range[0]);
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
		System.out.println(y_quarter_2);
		Map<String, List<Double>> output_everyGoodsTotleMoney = outputService.getEveryGoodsgetOutputQuarterTotleMoneyWithYear(y_quarter_2);
		for( Entry<String, List<Double>> map_1 : output_everyGoodsTotleMoney.entrySet()){
			System.out.println(map_1.getKey());
		}
		Map<String , double[]> output_everyGoodsTotleMoney_quarter = new HashMap<>();
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney.entrySet()){
			output_everyGoodsTotleMoney_quarter.put(map.getKey(), ListToArray.getDoubleArray(map.getValue()));
		}
		/*for( Entry<String, double[]> map : output_everyGoodsTotleMoney_quarter.entrySet()){
			System.out.println(map.getKey());
			for(double d : map.getValue()){
				System.out.println(d);
			}
		}*/
		int i=0;
		int size = output_everyGoodsTotleMoney_quarter.keySet().size();
		String[] productName = new String[size];
		double[][] productVlaue = new double[size][4];
		for(Map.Entry<String, double[]> p : output_everyGoodsTotleMoney_quarter.entrySet()){
			productName[i] = p.getKey();
			productVlaue[i] = p.getValue();
			i+=1;
		}
		//去除零值
		if(y_quarter_2 == current_year){
			for(int j=0;j<productVlaue.length;j++){
				productVlaue[j] = ChangeLength.changeLength(productVlaue[j]);
			}
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
		int size = output_everyGoodsTotleMoney_quarter_2.keySet().size();
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
		int query_year = Constant.YEAR;
		if(quarter_quarter_3>Constant.CURRENTQUARTER){
			query_year -= 1;
		}
		
		Map<String, Double> output_percent_quarter = outputService.getThisQuarterOutputGoodsTotleMoney(quarter_quarter_3, query_year);
		String output_percent_quarter_array[][] = ListToArray.getString2Array(output_percent_quarter);
		Map<String, Double> output_top3_quarter = outputService.getThisQuarterTop3GoodsMoney(quarter_quarter_3, query_year);
		//准备数据
		String[] output_top3_key = outputService.getItemByMap(output_top3_quarter);
		double[] output_top3_month_1 = outputService.getMomthValueByMap(output_top3_key , quarter_quarter_3, query_year).get(0);
		double[] output_top3_month_2 = outputService.getMomthValueByMap(output_top3_key, quarter_quarter_3, query_year).get(1);
		double[] output_top3_month_3 = outputService.getMomthValueByMap(output_top3_key, quarter_quarter_3, query_year).get(2);
		String[] months = outputService.getMomthByQuarter(quarter_quarter_3);
		/*for(int i = 0 ; i < 3 ; i++){
			System.out.println(output_top3_key[i]);
		}
		System.out.println("第一个月：");
		for(double d : output_top3_month_1){
			System.out.println(d);
		}
		System.out.println("第二个月：");
		for(double d : output_top3_month_2){
			System.out.println(d);
		}
		System.out.println("第三个月：");
		for(double d : output_top3_month_3){
			System.out.println(d);
		}*/
		//饼图数据
		result1.put("data_out_quarter_3", output_percent_quarter_array);
		//top3图数据
		result1.put("data_output_month_3_key", output_top3_key);
		result1.put("data_output_month_3_1", output_top3_month_1);
		result1.put("data_output_month_3_2", output_top3_month_2);
		result1.put("data_output_month_3_3", output_top3_month_3);
		result1.put("data_output_month_3_months", months);
		//result1.put("data_output_month_3_value", output_top3_value);
		return "success_quarter";
	}
	
	public String quarter_4(){
		int query_quarter = Constant.CURRENTQUARTER;
		int query_year = Constant.YEAR;
		if(Constant.CURRENTQUARTER == 1){
			query_quarter = 5;
			query_year -= 1;
		}
		Map<String, Double> map_thisQuarter = outputService.getThisQuarterOutputGoodsTotleMoney(query_quarter - 1, query_year);
		Map<String, Double> map_lastQuarter = outputService.getThisQuarterOutputGoodsTotleMoney(query_quarter - 1, query_year - 1);
		//销项名称
		String[] items = ListToArray.getItemsArray(map_thisQuarter , map_lastQuarter);
		//准备数据  今年这个季度的总和
		double[] thisYear_Quarter = outputService.getThisQuarterOutputGoodsTotleMoney(query_quarter - 1, query_year , items);
		//准备数据  去年这个季度的总和
		double[] lastYear_Quarter = outputService.getThisQuarterOutputGoodsTotleMoney(query_quarter - 1,query_year - 1 , items);
		//该季度包含的月份
		String[] months = outputService.getMomthByQuarter(query_quarter - 1);
		//去年该季每个月份的销售额
		double[][] data_last_month = outputService.getMonthMoneyByQuarterAndYearAnditems(query_year - 1 , query_quarter - 1, items);
		//前年该季每个月份的销售额
		double[][] data_now_month  = outputService.getMonthMoneyByQuarterAndYearAnditems(query_year , query_quarter - 1, items);
		//测试
		System.out.println("去年和前年这个季度的总和");
		for(int i = 0 ; i < items.length ; i++){
			System.out.println(items[i] + "今年" + thisYear_Quarter[i] + "  去年" + lastYear_Quarter[i]);
		}
		System.out.println("该季度包含月份");
		for(int i = 0 ; i < months.length ; i++){
			System.out.println(months[i]);
		}
		System.out.println("去年和前年这个季度的每个月的销售额");
		for(int i = 0 ; i < items.length ; i++){
			System.out.println("第"+	(i+1) +"个月份");
			for(int j = 0 ; j < 3 ; j++){
				System.out.println("前年"+ data_last_month[i][j] + "  去年" +data_now_month[i][j]);
			}
		}
		result1.put("items_quarter_4", items);
		result1.put("thisYear_Quarter_quarter_4", thisYear_Quarter);
		result1.put("lastYear_Quarter_quarter_4", lastYear_Quarter);
		result1.put("months_quarter_4", months);
		result1.put("lastYear_Month_quarter_4", data_last_month);
		result1.put("thisYear_Month_quarter_4", data_now_month);
		return "success_quarter";
	}
	
	public String quarter_5(){
		int query_quarter = Constant.CURRENTQUARTER;
		int query_year = Constant.YEAR;
		if(Constant.CURRENTQUARTER == 1){
			query_quarter = 5;
			query_year -= 1;
		}
		Map<String, Double> map_thisQuarter = outputService.getThisQuarterOutputGoodsTotleMoney(query_quarter - 1, query_year);
		Map<String, Double> map_lastQuarter = outputService.getThisQuarterOutputGoodsTotleMoney(query_quarter - 1, query_year - 1);
		String[] item = ListToArray.getItemsArray(map_thisQuarter , map_lastQuarter);
		//销项名称
		String[] items = inoutService.getInputItemByOutputItem(item);
		//准备数据  今年这个季度的总和
		double[] thisYear_Quarter = inputService.getThisQuarterInputGoodsTotleMoney(query_quarter - 1, query_year , items);
		//准备数据  去年这个季度的总和
		double[] lastYear_Quarter = inputService.getThisQuarterInputGoodsTotleMoney(query_quarter - 1, query_year - 1 , items);
		//该季度包含的月份
		String[] months = outputService.getMomthByQuarter(query_quarter - 1);
		//去年该季每个月份的销售额
		double[][] data_last_month = inputService.getMonthMoneyByQuarterAndYearAnditems(query_year - 1 , query_quarter - 1, items);
		//前年该季每个月份的销售额
		double[][] data_now_month  = inputService.getMonthMoneyByQuarterAndYearAnditems(query_year , query_quarter - 1, items);
		
		//测试
				System.out.println("今年和去年这个季度的总和");
				for(int i = 0 ; i < items.length ; i++){
					System.out.println(items[i] + "今年" + thisYear_Quarter[i] + "  去年" + lastYear_Quarter[i]);
				}
				System.out.println("该季度包含月份");
				for(int i = 0 ; i < months.length ; i++){
					System.out.println(months[i]);
				}
				System.out.println("今年和去年这个季度的每个月的销售额");
				for(int i = 0 ; i < items.length ; i++){
					System.out.println("第"+	(i+1) +"个月份");
					for(int j = 0 ; j < 3 ; j++){
						System.out.println("去年"+ data_last_month[i][j] + "  今年" +data_now_month[i][j]);
					}
				}
		result1.put("input_items_quarter_4", items);
		result1.put("input_thisYear_Quarter_quarter_4", thisYear_Quarter);
		result1.put("input_lastYear_Quarter_quarter_4", lastYear_Quarter);
		result1.put("input_months_quarter_4", months);
		result1.put("input_lastYear_Month_quarter_4", data_last_month);
		result1.put("input_thisYear_Month_quarter_4", data_now_month);
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
		Map<String, Double> output_top3_year = outputService.getThisYearTop3GoodsMoney(year_year_3);
		//准备数据
		String[] output_top3_key = outputService.getItemByMap(output_top3_year);
		for(int i = 0 ; i < 3 ; i++){
			System.out.println(output_top3_key[i] + "=======");
		}
		//double[] output_top3_value = outputService.getValueByMap(output_top3_year);
		//准备数据
		double[] output_Quarter_1 = outputService.getQuarterValueByMap(output_top3_key , year_year_3).get(0);
		double[] output_Quarter_2 = outputService.getQuarterValueByMap(output_top3_key , year_year_3).get(1);
		double[] output_Quarter_3 = outputService.getQuarterValueByMap(output_top3_key , year_year_3).get(2);
		double[] output_Quarter_4 = outputService.getQuarterValueByMap(output_top3_key , year_year_3).get(3);
		String[] quarters = {"第一季度","第二季度","第三季度","第四季度"};
		
		/*for(int i = 0 ; i < 3 ; i++){
			System.out.println(output_top3_key[i]);
		}
		System.out.println("第一季度");
		for(double d : output_Quarter_1){
			System.out.println(d);
		}
		System.out.println("第二季度");
		for(double d : output_Quarter_2){
			System.out.println(d);
		}
		System.out.println("第三季度");
		for(double d : output_Quarter_3){
			System.out.println(d);
		}
		System.out.println("第四季度");
		for(double d : output_Quarter_4){
			System.out.println(d);
		}*/
		
		String output_percent_year_array[][] = ListToArray.getString2Array(output_percent_year);
		//top3数据
		result2.put("data_output_year_3_key", output_top3_key);
		result2.put("data_output_quarter_3_1", output_Quarter_1);
		result2.put("data_output_quarter_3_2", output_Quarter_2);
		result2.put("data_output_quarter_3_3", output_Quarter_3);
		result2.put("data_output_quarter_3_4", output_Quarter_4);
		result2.put("data_output_year_3_quarters", quarters);
		//饼图数据
		result2.put("data_output_year_3", output_percent_year_array);
		return "success_year";

	}
	
	public String tax(){
		return "tax";
	}
	
	//准备税收分析数据
	public String tax_1(){
		List<Output> outputs = outputService.findAll();
		//销项数组
		String[] items = outputService.getAllItems();
		
		String[] inputItems = inoutService.getInputItemByOutputItem(items);
		//三维
		double[][][] item_in_out = outputService.getInputAndOutputByItems(outputs , items , inputItems);
		//测试
		/*for(int i = 0 ; i < items.length ; i++){
			System.out.println(inputItems[i] + "  " + items[i]);
			for(int j = 0 ; j < 10 ; j++){
					System.out.println(item_in_out[i][j][0] + "  " + item_in_out[i][j][1]);
			}
		}*/
		result3.put("items", items);
		result3.put("data_in_out", item_in_out);
		return "success_tax";
	}
	
	
	//明细分析
	public String detail(){
		
		return "detail";
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

	public String getOutputItem() {
		return outputItem;
	}

	public void setOutputItem(String outputItem) {
		this.outputItem = outputItem;
	}

	public Map<String,Object> getResult3() {
		return result3;
	}

	public void setResult3(Map<String,Object> result3) {
		this.result3 = result3;
	}

	
	
}
