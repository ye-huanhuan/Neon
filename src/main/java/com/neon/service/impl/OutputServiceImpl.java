package com.neon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Output;
import com.neon.service.OutputService;
import com.neon.util.Arith;
import com.neon.util.Constant;
import com.neon.util.DoubleJudge;
import com.neon.util.ListToArray;
import com.neon.util.Sort;
import com.zyujie.dm.LinearRegression;

@Service
public class OutputServiceImpl extends DaoSupportImpl<Output> implements OutputService{

	@Override
	public List<Double> getOutputTotleMoneyWithMonth(int year) {
		List<Double> list = new ArrayList<>();
		if(year == Constant.YEAR){
			for(int month = 1 ; month <= Constant.CURRENTMONTH - 1 ; month++ ){
				List<Output> outputs = getOutputsWithMonthAndYear(month,year);
				Double money = 0.0;
				for(Output out : outputs){
					money += out.getMoney();
				}
				list.add(money);
			}
			
			list.add(LinearRegression.predict(getAllMonthAndMoney(), Constant.CURRENTMONTH));
		}else{
			for(int month = 1 ; month <= Constant.MONTH ; month++ ){
				List<Output> outputs = getOutputsWithMonthAndYear(month,year);
				Double money = 0.0;
				for(Output out : outputs){
					money += out.getMoney();
				}
				list.add(money);
			}
		}
		
		return list;
	}


	@Override
	public List<Double> getOutputTotleMoneyWithQuarter(int year) {
		List<Double> list = new ArrayList<>();
		Double money = 0.0;
		for(int month = 1 ; month <= Constant.MONTH ; month++ ){
			List<Output> outputs = getOutputsWithMonthAndYear(month,year);
			for(Output out : outputs){
				money = Arith.add(money, out.getMoney());
			}
			if(month%3 == 0){
				list.add(money);
				money = 0.0;
			}
		}
		return list;
	}

	@Override
	public Map<String, List<Double>> getEveryGoodsgetOutputTotleMoneyWithYear(int year) {
		Map<String, List<Double>> maps = new HashMap<>();
		List<String> items = getEveryGoodsItem();
		for(String item : items){
			List<Double> moneys = new ArrayList<>();
			for(int month = 1 ; month <= Constant.MONTH ; month++){
				List<Output> outputs = getOutputsWithMonthAndYearAndItem(month , year ,item);
				Double money = 0.0;
				for(Output output : outputs){
					money = Arith.add(money, output.getMoney());
				}
				moneys.add(money);
			}
			maps.put(item, moneys);
		}
		return maps;
	}
	
	@Override
	public Map<String, List<Double>> getEveryGoodsgetOutputQuarterTotleMoneyWithYear(int year) {
		Map<String, List<Double>> maps = new HashMap<>();
		List<String> items = getEveryGoodsItem();
		Double money = 0.0;
		for(String item : items){
			List<Double> moneys = new ArrayList<>();
			for(int month = 1 ; month <= Constant.MONTH ; month++){
				List<Output> outputs = getOutputsWithMonthAndYearAndItem(month , year ,item);
				for(Output output : outputs){
					money = Arith.add(money, output.getMoney());
				}
				if(month%3 == 0){
					moneys.add(money);
					money = 0.0;
				}
			}
			maps.put(item, moneys);
		}
		return maps;
	}


	@Override
	public Map<String, Double> getThisMonthOutputGoodsTotleMoney(int month , int year) {
		Map<String, Double> map = new HashMap<>();
		List<String> items = getThisMonthGoodsItem(month , year);
		Double totleMoney = getThisMonthTotleMoney(month , year);
		for(String item : items){
			Double percent = Arith.div(getThisItemTotleMoney(item , month , year), totleMoney , 4);
			map.put(item, percent*100);
		}
		return map;
	}
	
	@Override
	public double[] getThisMonthOutputGoodsTotleMoney(int month, int year, String[] items) {
		double[] strs = new double[items.length];
		for(int i = 0 ; i < items.length ; i++){
			strs[i] = getThisItemTotleMoney(items[i],month,year);
		}
		return strs;
	}
	
	@Override
	public Map<String, Double> getThisQuarterOutputGoodsTotleMoney(int quarter, int year) {
		Map<String, Double> map = new HashMap<>();
		switch(quarter){
		case 1 : 
			int i[] = {1 , 2 , 3};
			List<String> items = getThisMonthGoodsItemByMonth( i , year);
				for(String item : items){
				double money = 0.0;	
				for(int month = 1 ; month <= 3 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				map.put(item, money);
			};
			break;
		case 2 :
			int i_2[] = {4 , 5 , 6};
			List<String> items_2 = getThisMonthGoodsItemByMonth( i_2 , year);
				for(String item : items_2){
				double money = 0.0;	
				for(int month = 4 ; month <= 6 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				map.put(item, money);
			};
			break;
		case 3 :
			int i_3[] = {7 , 8 , 9};
			List<String> items_3 = getThisMonthGoodsItemByMonth( i_3 , year);
				for(String item : items_3){
				double money = 0.0;	
				for(int month = 7 ; month <= 9 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				map.put(item, money);
			};
			break;
		case 4 :
			int i_4[] = {10 , 11 , 12};
			List<String> items_4 = getThisMonthGoodsItemByMonth( i_4 , year);
				for(String item : items_4){
				double money = 0.0;	
				for(int month = 10 ; month <= 12 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d) ;
				}
				map.put(item, money);
			};
			break;
		}
		
		return Sort.SortMapByDESC3(map);
	}
	
	@Override
	public double[] getThisQuarterOutputGoodsTotleMoney(int quarter, int year, String[] items) {
		double[] dou = new double[items.length];
		switch(quarter){
		case 1 : 
			int temp = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 1 ; month <= 3 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				dou[temp] = money;
				temp++;
			};
			break;
		case 2 :
			int temp_2 = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 4 ; month <= 6 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				dou[temp_2] = money;
				temp_2++;
			};
			break;
		case 3 :
			int temp_3 = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 7 ; month <= 9 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				dou[temp_3] = money;
				temp_3++;
			};
			break;
		case 4 :
			int temp_4 = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 10 ; month <= 12 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d);
				}
				dou[temp_4] = money;
				temp_4++;
			};
			break;
		}
		return dou;
	}
		
	@Override
	public List<Double> getDvalue(List<Double> input_totlemoney_month, List<Double> output_totlemoney_month) {
		List<Double> dvalue = new ArrayList<>();
		for(int index = 0 ; index < input_totlemoney_month.size() ; index++){
			dvalue.add(Arith.sub(output_totlemoney_month.get(index), input_totlemoney_month.get(index)));
		}
		return dvalue;
	}


	@Override
	public Map<String, List<Double>> getRecentYearsOutputGoodsTotleMoney() {
		Map<String, List<Double>> maps = new HashMap<>();
		List<String> items = getEveryGoodsItem();
		for(String item : items){
			List<Double> moneys = new ArrayList<>();
			for(int year = Constant.YEAR ; year > Constant.YEAR - 6 ; year--){
				Double money = 0.0;
				List<Output> outputs = getOutputsWithYearAndItem(year ,item);
				for(Output output : outputs){
					money = Arith.add(money, output.getMoney());
				}
				moneys.add(money);
			}
			maps.put(item, moneys);
			
		}
		
		return maps;
	}
	
	
	@Override
	public Map<String, Double> getThisYearOutputGoodsTotleMoney(int year) {
		
		Map<String, Double> maps = new HashMap<>();
		List<String> items = getEveryGoodsItem();
		Double totleMoney = 0.0;
		List<Output> outputs_year = getOutputsWithYear(year);
		for(Output o : outputs_year){
			totleMoney = Arith.add(totleMoney, o.getMoney());
		}
		for(String item : items){
			Double money = 0.0;
			List<Output> outputs = getOutputsWithYearAndItem(year ,item);
			for(Output output : outputs){
				money = Arith.add(money, output.getMoney());
			}
			Double persent = Arith.div(money, totleMoney, 4);
			maps.put(item, persent*100);
		}
		return maps;
	}
	
	@Override
	public Map<String, Double> getThisMonthTop3GoodsMoney(int m, int year) {
		Map<String, Double> maps = new HashMap<String, Double>();
		List<Output> list = getTop3Goods(m , year);
		for(int i = 0 ; i < 3 ; i++){
			maps.put(list.get(i).getItem(), list.get(i).getMoney());
		}
		return Sort.SortMapByDESC3(maps);
	}
	

	@Override
	public List<Double> getOutputTotleMoneyWithYear() {
		List<Double> list = new ArrayList<>();
		for(int year = Constant.YEAR ; year > Constant.YEAR - 6 ; year--){
			Double money =  getOutputTotleMoneyWithThisYear(year);
			list.add(money);
		}
		return list;
	}
	
	@Override
	public String[] getItemByMap(Map<String, Double> output_top3_month) {
		String[] str = new String[output_top3_month.size()];
		int i = 0;
		for(Entry<String, Double> map : output_top3_month.entrySet()){
			str[i] = map.getKey();
			i++;
		}
		return str;
	}
	
	@Override
	public double[] getValueByMap(Map<String, Double> output_top3_month) {
		double[] str = new double[output_top3_month.size()];
		int i = 0;
		for(Entry<String, Double> map : output_top3_month.entrySet()){
			str[i] = map.getValue();
			i++;
		}
		return str;
	}
	
	@Override
	public Map<String, Double> getThisQuarterTop3GoodsMoney(int quarter_quarter_3, int year) {
		Map<String, Double> map = new HashMap<>();
		double totleMoney = 0.0;
		switch(quarter_quarter_3){
		case 1 :
			int i[] = {1 , 2 , 3};
			totleMoney = Arith.add(Arith.add(getThisMonthTotleMoney(1 , year) , getThisMonthTotleMoney(2 , year)),getThisMonthTotleMoney(3 , year));
			List<String> items = getThisMonthGoodsItemByMonth( i , year);
				for(String item : items){
				double money = 0.0;	
				for(int month = 1 ; month <= 3 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d) ;
				}
				map.put(item, Arith.div(money, totleMoney, 4)*100);
			};
			break;
		case 2 :
			int i_2[] = {4 , 5 , 6};
			totleMoney = Arith.add(Arith.add(getThisMonthTotleMoney(1 , year) , getThisMonthTotleMoney(2 , year)),getThisMonthTotleMoney(3 , year));
			List<String> items_2 = getThisMonthGoodsItemByMonth( i_2 , year);
				for(String item : items_2){
				double money = 0.0;	
				for(int month = 4 ; month <= 6 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d) ;
				}
				map.put(item, Arith.div(money, totleMoney, 4)*100);
			};
			break;
		case 3 :
			int i_3[] = {7 , 8 , 9};
			totleMoney = Arith.add(Arith.add(getThisMonthTotleMoney(1 , year) , getThisMonthTotleMoney(2 , year)),getThisMonthTotleMoney(3 , year));
			List<String> items_3 = getThisMonthGoodsItemByMonth( i_3 , year);
				for(String item : items_3){
				double money = 0.0;	
				for(int month = 7 ; month <= 9 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d) ;
				}
				map.put(item, Arith.div(money, totleMoney, 4)*100);
			};
			break;
		case 4 :
			int i_4[] = {10 , 11 , 12};
			totleMoney = Arith.add(Arith.add(getThisMonthTotleMoney(1 , year) , getThisMonthTotleMoney(2 , year)),getThisMonthTotleMoney(3 , year));
			List<String> items_4 = getThisMonthGoodsItemByMonth( i_4 , year);
				for(String item : items_4){
				double money = 0.0;	
				for(int month = 10 ; month <= 12 ; month++){
					double d = 0.0;
					if(getThisItemTotleMoney(item,month,year) != null){
						d = getThisItemTotleMoney(item,month,year);
					}
					money = Arith.add(money , d) ;
				}
				map.put(item, Arith.div(money, totleMoney, 4)*100);
			};
			break;
		}
		
		return Sort.SortMapByDESC3(map);
	}
	
	@Override
	public Map<String, Double> getThisYearTop3GoodsMoney(int year_year_3) {
		Map<String, Double> maps = new HashMap<>();
		List<String> items = getEveryGoodsItem();
		for(String item : items){
			double money = 0.0;
			List<Output> outputs = getOutputsWithYearAndItem(year_year_3 ,item);
			for(Output output : outputs){
				money = Arith.add(money, output.getMoney());
			}
			maps.put(item, money);
		}
		return Sort.SortMapByDESC3(maps);
	}
	
	@Override
	public List<double[]> getMomthValueByMap(String[] output_top3_quarter, int quarter_quarter_3,int year) {
		List<double[]> list = new ArrayList<>();
		double[] month_1 = new double[output_top3_quarter.length];
		double[] month_2 = new double[output_top3_quarter.length];
		double[] month_3 = new double[output_top3_quarter.length];
		
		switch(quarter_quarter_3){
		case 1 :
				for(int month = 1 ; month <= 3 ; month++){
					int index = 0;
					for(String str : output_top3_quarter){
						if(month == 1){
							month_1[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
						}else if(month == 2){
							month_2[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
						}else if(month == 3){
							month_3[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
						}
						index++;
					}
					 
				}
			list.add(month_1);
			list.add(month_2);
			list.add(month_3);
			break;
		case 2 :
			for(int month = 4 ; month <= 6 ; month++){
				int index = 0;
				for(String str : output_top3_quarter){
					if(month == 4){
						month_1[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}else if(month == 5){
						month_2[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}else if(month == 6){
						month_3[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}
					index++;
				}
				 
			}
			list.add(month_1);
			list.add(month_2);
			list.add(month_3);
			break;
		case 3 :
			for(int month = 7 ; month <= 9 ; month++){
				int index = 0;
				for(String str : output_top3_quarter){
					if(month == 7){
						month_1[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}else if(month == 8){
						month_2[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}else if(month == 9){
						month_3[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}
					index++;
				}
				 
			}
			list.add(month_1);
			list.add(month_2);
			list.add(month_3);
			break;
		case 4 :
			for(int month = 10 ; month <= 12 ; month++){
				int index = 0;
				for(String str : output_top3_quarter){
					if(month == 10){
						month_1[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}else if(month == 11){
						month_2[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}else if(month == 12){
						month_3[index] = DoubleJudge.isDouble(getThisItemTotleMoney(str,month,year));
					}
					index++;
				}
				 
			}
			list.add(month_1);
			list.add(month_2);
			list.add(month_3);
			break;
		}
		
		return list;
	}
	

	@Override
	public String[] getMomthByQuarter(int quarter_quarter_3) {
		String[] str = new String[3];
		switch(quarter_quarter_3){
		case 1 :
			str[0] = "第一月";
			str[1] = "第二月";
			str[2] = "第三月";
		break;
		case 2 :
			str[0] = "第四月";
			str[1] = "第五月";
			str[2] = "第六月";
		break;
		case 3 :
			str[0] = "第七月";
			str[1] = "第八月";
			str[2] = "第九月";
		break;
		case 4 :
			str[0] = "第十月";
			str[1] = "第十一月";
			str[2] = "第十二月";
		break;
		}
		return str;
	}
	
	@Override
	public List<double[]> getQuarterValueByMap(String[] output_top3_key , int year) {
		List<double[]> list = new ArrayList<>();
		double[] quarter_1 = new double[output_top3_key.length];
		double[] quarter_2 = new double[output_top3_key.length];
		double[] quarter_3 = new double[output_top3_key.length];
		double[] quarter_4 = new double[output_top3_key.length];
		
		int index = 0;
		
		for(String str : output_top3_key){
			quarter_1[index] = DoubleJudge.isDouble(getThisQuarterThisGoodsTotleMoney(str , 1 , year));
			quarter_2[index] = DoubleJudge.isDouble(getThisQuarterThisGoodsTotleMoney(str , 2 , year));
			quarter_3[index] = DoubleJudge.isDouble(getThisQuarterThisGoodsTotleMoney(str , 3 , year));
			quarter_4[index] = DoubleJudge.isDouble(getThisQuarterThisGoodsTotleMoney(str , 4 , year));
			index++;
		}
		
		list.add(quarter_1);
		list.add(quarter_2);
		list.add(quarter_3);
		list.add(quarter_4);
		
		return list;
	}

	
	private double getThisQuarterThisGoodsTotleMoney(String item , int i, int year) {
		List<Output> output_1 = new ArrayList<>();
		List<Output> output_2 = new ArrayList<>();
		List<Output> output_3 = new ArrayList<>();
		switch(i){
		case 1 :
			output_1 = getOutputsWithMonthAndYearAndItem(1, year, item);
			output_2 = getOutputsWithMonthAndYearAndItem(2, year, item);
			output_3 = getOutputsWithMonthAndYearAndItem(3, year, item);
		break;
		case 2 :
			output_1 = getOutputsWithMonthAndYearAndItem(4, year, item);
			output_2 = getOutputsWithMonthAndYearAndItem(5, year, item);
			output_3 = getOutputsWithMonthAndYearAndItem(6, year, item);
		break;
		case 3 :
			output_1 = getOutputsWithMonthAndYearAndItem(7, year, item);
			output_2 = getOutputsWithMonthAndYearAndItem(8, year, item);
			output_3 = getOutputsWithMonthAndYearAndItem(9, year, item);
		break;
		case 4 :
			output_1 = getOutputsWithMonthAndYearAndItem(10, year, item);
			output_2 = getOutputsWithMonthAndYearAndItem(11, year, item);
			output_3 = getOutputsWithMonthAndYearAndItem(12, year, item);
		break;
		}
		double d_1 = 0.0;
		double d_2 = 0.0;
		double d_3 = 0.0;
		try{
			if(output_1 != null){
				d_1 = output_1.get(0).getMoney();
			}
			
		}catch(Exception e){
			d_1 = 0.0;
		}
		try{
			
			if(output_2 != null){
				d_2 = output_2.get(0).getMoney();
			}
		}catch(Exception e){
			d_2 = 0.0;
		}
		try{
			if(output_3 != null){
				d_3 = output_3.get(0).getMoney();
			}
		}catch(Exception e){
			d_3 = 0.0;
		}
		
		return Arith.add(Arith.add(d_1, d_2) , d_3);
	}
	
	@Override
	public double[][] getMonthMoneyByQuarterAndYearAnditems(int year, int quarter, String[] items) {
		double[][] d = new double[items.length][];
		for(int q = 0 ; q < items.length ; q++){
			d[q] = new double[3];
		}
		
		switch (quarter) {
		case 1:
			int temp = 0;
			for(String item : items){
				int j = 0;
				for(int i = 1 ; i <= 3 ; i++){
					try {
						d[temp][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp][j] = 0.0;
					}
					j++;
				}
				temp++;
			}
			break;
		case 2:
			int temp_2 = 0;
			for(String item : items){
				int j = 0;
				for(int i = 4 ; i <= 6 ; i++){
					try {
						d[temp_2][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp_2][j] = 0.0;
					}
					j++;
				}
				temp_2++;
			}
			break;
		case 3:
			int temp_3 = 0;
			for(String item : items){
				int j = 0;
				for(int i = 7 ; i <= 9 ; i++){
					try {
						d[temp_3][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp_3][j] = 0.0;
					}
					j++;
				}
				temp_3++;
			}
			break;
		case 4:
			int temp_4 = 0;
			for(String item : items){
				int j = 0;
				for(int i = 10 ; i <= 12 ; i++){
					try {
						d[temp_4][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp_4][j] = 0.0;
					}
					j++;
				}
				temp_4++;
			}
			break;
		}
		return d;
	}


	@Override
	public String[] getAllItems() {
		List<String> items = getItemsAll();
		return ListToArray.getStringArray_2(items);
	}
	
	
	@Override
	public double[][][] getInputAndOutputByItems(List<Output> outputs, String[] items, String[] inputItems) {
		double[][][] d = new double[items.length][][];
		int temp = 0;
		for(String str : items){
			List<Output> output = new ArrayList<>();
			for(Output out : outputs){
				if(out.getItem().equals(str)){
					output.add(out);
				}
			}
			d[temp] = getInputAndOutputByOutput(output , inputItems[temp]);
			temp++;
		}
		return d;
	}
	
	
	@Override
	public List<Output> getOutputsByItem(String outputItem) {
		return getSession().createQuery(//
				"FROM Output out WHERE out.item=?")
				.setParameter(0, outputItem)
				.list();
	}


	@Override
	public List<double[][]> getAllMonthAndMoney() {
		List<double[][]> list = new ArrayList<>();
		int[] years = ListToArray.getIntArray(getOutputYear());
		for(int year : years){
			if(year == Constant.YEAR){
				for(int month = 1 ; month <= Constant.CURRENTMONTH - 1; month++ ){
					List<Output> outputs = getOutputsWithMonthAndYear(month,year);
					Double money = 0.0;
					for(Output out : outputs){
						money += out.getMoney();
					}
					double[][] d = {{0 , 0}};
					d[0][0] = month;
					d[0][1] = money;
					list.add(d);
				}
			}else{
				for(int month = 1 ; month <= 12 ; month++ ){
					List<Output> outputs = getOutputsWithMonthAndYear(month,year);
					Double money = 0.0;
					for(Output out : outputs){
						money += out.getMoney();
					}
					double[][] d = {{0 , 0}};
					d[0][0] = month;
					d[0][1] = money;
					list.add(d);
				}
			}
		}
		return list;
	}
	

	private double[][] getInputAndOutputByOutput(List<Output> out , String inputItem) {
		System.out.println(out.size());
		double[][] d = new double[out.size()][];
		for(int q = 0 ; q < out.size() ; q++){
			d[q] = new double[2];
		}
		int temp = 0;
		for(Output output : out){
			for(int j = 0 ; j < 2 ; j++){
				if(j == 0){
					try{
						d[temp][j] = getInputMoneyByOutput(inputItem , output.getMonth() , output.getYear());
					}catch (Exception e) {
						d[temp][j] = 0;
					}
				}else{
					d[temp][j] = output.getMoney();
				}
			}
			temp++;
		}
		return d;
	}


	private double getInputMoneyByOutput(String inputItem, int month, int year) {
		return (double) getSession().createQuery(//
				"SELECT money FROM Input input WHERE input.item=? AND input.month=? AND input.year=?")
				.setParameter(0, inputItem)
				.setParameter(1, month)
				.setParameter(2, year)
				.uniqueResult();
	}


	private List<String> getItemsAll() {
		return getSession().createQuery(//
				"SELECT DISTINCT item FROM Output out")
				.list();
	}


	private double getThisMonthThisGoodsTotleMoney(String item, int month, int year) {
		return (double) getSession().createQuery(//
				"SELECT money FROM Output out WHERE out.month=? AND out.year=? AND out.item=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.setParameter(2, item)
				.uniqueResult();
	}


	private List<Output> getTop3Goods(int m, int year) {
		return getSession().createQuery(//
				"FROM Output out WHERE out.month=? AND out.year=? ORDER BY money DESC")
				.setParameter(0, m)
				.setParameter(1, year)
				.list();
	}
	
	private List<String> getThisMonthGoodsItemByMonth(int i[] , int year){
		return getSession().createQuery(//
				"SELECT DISTINCT item FROM Output out WHERE out.year=? AND out.month=? OR out.month=? OR out.month=?")
				.setParameter(0, year)
				.setParameter(1, i[0])
				.setParameter(2, i[1])
				.setParameter(3, i[2])
				.list();
	}
	
	private List<Output> getOutputsWithYearAndItem(int year , String item){
		return getSession().createQuery(//
				"FROM Output output WHERE output.year=? AND output.item=?")
				.setParameter(0, year)
				.setParameter(1, item)
				.list();
	}

	private Double getOutputTotleMoneyWithThisYear(Integer year) {
		Double money = 0.0;
		List<Output> outputs = getOutputsWithYear(year);
		for(Output output : outputs){
			money = Arith.add(money, output.getMoney());
		}
		return money;
	}

	private Double getThisMonthTotleMoney(int month, int year) {
		List<Output> outputs = getThisMonthGoods(month , year);
		Double money = 0.0;
		for(Output output : outputs){
			money = Arith.add(money, output.getMoney());
		}
		return money;
	}

	private List<Output> getOutputsWithYear(Integer year) {
		return getSession().createQuery(//
				"FROM Output output WHERE output.year=?")
				.setParameter(0, year)
				.list();
	}
	private List<String> getEveryGoodsItem() {
		return getSession().createQuery(//
				"SELECT item FROM Output")
				.list();
	}

	private List<String> getThisMonthGoodsItem(int month, int year) {
		return getSession().createQuery(//
				"SELECT DISTINCT item FROM Output output WHERE output.month=? AND output.year=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.list();
	}
	private Double getThisItemTotleMoney(String item, int month, int year) {
		
		return (Double) getSession().createQuery(//
				"SELECT money FROM Output output WHERE output.item=? AND month=? AND year=?")
				.setParameter(0, item)
				.setParameter(1, month)
				.setParameter(2, year)
				.uniqueResult();
		
	}
	
	private List<Output> getThisMonthGoods(int month, int year) {
		return getSession().createQuery(//
				"FROM Output output WHERE output.year=? AND output.month=?")
				.setParameter(0, year)
				.setParameter(1, month)
				.list();
	}

	private List<Output> getOutputsWithMonthAndYear(int month,int year) {
		return getSession().createQuery(//
				"FROM Output output WHERE output.month=? AND output.year=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.list();
			
	}
	private List<Integer> getOutputYear() {
		
		return getSession().createQuery(//
				"SELECT DISTINCT year FROM Output output")
				.list();
	}

	private List<Output> getOutputsWithMonthAndYearAndItem(int month, int year, String item) {
		return getSession().createQuery(//
				"FROM Output output WHERE output.month=? AND output.year=? AND output.item=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.setParameter(2, item)
				.list();
	}


	


}

