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
import com.neon.util.Sort;

@Service
public class OutputServiceImpl extends DaoSupportImpl<Output> implements OutputService{

	@Override
	public List<Double> getOutputTotleMoneyWithMonth(int year) {
		List<Double> list = new ArrayList<>();
		for(int month = 1 ; month <= Constant.MONTH ; month++ ){
			List<Output> outputs = getOutputsWithMonthAndYear(month,year);
			Double money = 0.0;
			for(Output out : outputs){
				money += out.getMoney();
			}
			list.add(money);
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year));
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year));
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year));
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year));
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year));
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
					money = Arith.add(money , getThisItemTotleMoney(item,month,year)) ;
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
	public List<double[]> getMomthValueByMap(String[] output_top3_quarter, int quarter_quarter_3) {
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
							month_1[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
						}else if(month == 2){
							month_2[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
						}else if(month == 3){
							month_3[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
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
						month_1[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
					}else if(month == 5){
						month_2[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
					}else if(month == 6){
						month_3[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
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
						month_1[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
					}else if(month == 8){
						month_2[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
					}else if(month == 9){
						month_3[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
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
						month_1[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
					}else if(month == 11){
						month_2[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
					}else if(month == 12){
						month_3[index] = getThisItemTotleMoney(str,month,Constant.YEAR);
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

