package com.neon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

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
	public Map<String, Double> getThisMonthOutputGoodsPercent(int month , int year) {
		Map<String, Double> map = new HashMap<>();
		List<String> items = getThisMonthGoodsItem(month , year);
		Double totleMoney = getThisMonthTotleMoney(month , year);
		for(String item : items){
			Double percent = Arith.div(getThisItemTotleMoney(item , month , year), totleMoney, Constant.scale);
			map.put(item, percent);
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
	public Map<Integer, Double> getOutputTotleMoneyWithYear() {
		Map<Integer, Double> map = new HashMap<>();
		List<Integer> years = getOutputYear();
		for(Integer year : years){
			Double money = getOutputTotleMoneyWithThisYear(year);
			map.put(year, money);
		}
		return map;
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

