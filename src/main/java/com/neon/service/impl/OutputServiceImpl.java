package com.neon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Output;
import com.neon.service.OutputService;
import com.neon.util.Arith;
import com.neon.util.Constant;

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
				if(month%3 == 0){
					moneys.add(money);
					money = 0.0;
				}
				List<Output> outputs = getOutputsWithMonthAndYearAndItem(month , year ,item);
				for(Output output : outputs){
					money = Arith.add(money, output.getMoney());
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
	public Map<String, Double> getThisQuarterOutputGoodsTotleMoney(int quarter, int year) {
		Map<String, Double> map = new HashMap<>();
		switch(quarter){
		case 1 : 
			for(int month = 1 ; month <= 3 ; month++){
				List<String> items = getThisMonthGoodsItem(month , year);
				for(String item : items){
					Double percent = getThisItemTotleMoney(item , month , year);
					map.put(item, percent);
				}
			};
		case 2 :
			for(int month = 4 ; month <= 6 ; month++){
				List<String> items = getThisMonthGoodsItem(month , year);
				for(String item : items){
					Double percent = getThisItemTotleMoney(item , month , year);
					map.put(item, percent);
				}
			};
			
		case 3 :
			for(int month = 7 ; month <= 9 ; month++){
				List<String> items = getThisMonthGoodsItem(month , year);
				for(String item : items){
					Double percent = getThisItemTotleMoney(item , month , year);
					map.put(item, percent);
				}
			};
			
		case 4 :
			for(int month = 10 ; month <= 12 ; month++){
				List<String> items = getThisMonthGoodsItem(month , year);
				for(String item : items){
					Double percent = getThisItemTotleMoney(item , month , year);
					map.put(item, percent);
				}
			};
		}
		
		return map;
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
		Double money = 0.0;
		for(String item : items){
			List<Double> moneys = new ArrayList<>();
			for(int year = Constant.YEAR ; year >= Constant.YEAR - 6 ; year--){
				List<Output> outputs = getOutputsWithYearAndItem(year ,item);
				for(Output output : outputs){
					money = Arith.add(money, output.getMoney());
				}
			}
			maps.put(item, moneys);
		}
		return maps;
	}
	
	
	@Override
	public Map<String, Double> getThisYearOutputGoodsTotleMoney(int year) {
		
		Map<String, Double> maps = new HashMap<>();
		List<String> items = getEveryGoodsItem();
		Double money = 0.0;
		for(String item : items){
				List<Output> outputs = getOutputsWithYearAndItem(year ,item);
				for(Output output : outputs){
					money = Arith.add(money, output.getMoney());
			}
			maps.put(item, money);
		}
		return maps;
	}
	
	@Override
	public List<Double> getOutputTotleMoneyWithYear() {
		List<Double> list = new ArrayList<>();
		for(int year = Constant.YEAR ; year >= Constant.YEAR - 6 ; year--){
			Double money =  getOutputTotleMoneyWithThisYear(year);
			list.add(money);
		}
		return list;
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

