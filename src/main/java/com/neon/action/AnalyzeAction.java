package com.neon.action;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.Input;

@Controller
@Scope("prototype")
public class AnalyzeAction extends ActionBase<Input>{

	//准备月份分析数据
	public String month(){
		
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
		System.out.println(input_totlemoney_month);
		System.out.println(output_totlemoney_month);
		System.out.println(dvalue);
		
		//第二张表的数据
		Map<String, List<Double>> output_everyGoodsTotleMoney_year = outputService.getEveryGoodsgetOutputTotleMoneyWithYear(year);
		for(Entry<String, List<Double>> map :output_everyGoodsTotleMoney_year.entrySet()){
			System.out.println(map.getKey()+" "+map.getValue());
		}
		
		//第三张表的数据
		int month = 1;
		Map<String, Double> output_percent_month = outputService.getThisMonthOutputGoodsPercent(month, year);
		for(Map.Entry<String, Double> map :output_percent_month.entrySet()){
			System.out.println(map.getKey()+" "+map.getValue());
		}
		
		
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
}
