package com.neon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Inout;
import com.neon.domain.Input;
import com.neon.service.InoutService;
import com.neon.service.InputService;
import com.neon.util.Arith;
import com.neon.util.Constant;

@Service
public class InputServiceImpl extends DaoSupportImpl<Input> implements InputService{

	@Override
	public List<Double> getInputTotleMoneyWithMonth(int year) {
		List<Double> list = new ArrayList<>();
		for(int month = 1 ; month <= Constant.MONTH ; month++ ){
			List<Input> inputs = getInputDataByMonth(month,year);

			double d = 0.0;
			for(Input inp : inputs){
				d = Arith.add(d, inp.getMoney());
			}
			list.add(d);
		}
		return list;
	}
	

	@Override
	public List<Double> getInputTotleMoneyWithQuarter(int year) {
		// TODO Auto-generated method stub
		double d = 0.0;
		List<Double> list = new ArrayList<>();

		for(int month=1; month<=Constant.MONTH;month++){

			List<Input> inputs = getInputDataByMonth(month,year);
			for(Input inp :inputs){
				d = Arith.add(d, inp.getMoney());
			}
			if(month%3 ==0){
				list.add(d);
				d=0.0;
			}
		}
		return list;
	}

	@Override
	public List<Double> getInputTotleMoneyWithYear() {
		// TODO Auto-generated method stub
		List<Double> list = new ArrayList<>();
		for(int year = Constant.YEAR ; year > Constant.YEAR - 6 ; year--){
			Double money =  getInputMoneyWithYear(year);
			list.add(money);
		}
		return list; 
	}
	
	@Override
	public Map<String, Double> getThisMonthOutputGoodsTotleMoney(int month, int year) {
		Map<String, Double> map = new HashMap<>();
		List<String> items = getThisMonthGoodsItem(month , year);
		for(String item : items){
			map.put(item, 0.0);
		}
		return map;
	}
	
	@Override
	public double[] getThisMonthInputGoodsTotleMoney(int month, int year, String[] items) {
		double[] strs = new double[items.length];
		for(int i = 0 ; i < items.length ; i++){
			try{
				strs[i] = getThisItemTotleMoney(items[i],month,year);
			}catch (Exception e) {
				strs[i] = 0.0;
			}
		}
		return strs;
	}
	
	public List<Input> getInputDataByMonth(int month,int year){
		return getSession().createQuery(//
				"FROM Input input WHERE input.month=? AND input.year=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.list();
	}
	
	
	private double getThisItemTotleMoney(String item, int month, int year) {
		return (Double) getSession().createQuery(//
				"SELECT money FROM Input output WHERE output.item=? AND output.month=? AND output.year=?")
				.setParameter(0, item)
				.setParameter(1, month)
				.setParameter(2, year)
				.uniqueResult();
	}


	private List<String> getThisMonthGoodsItem(int month, int year) {
		return getSession().createQuery(//
				"SELECT DISTINCT item FROM Output input WHERE input.month=? AND input.year=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.list();
	}


	private List<Integer> getInputYear(){
		return getSession().createQuery(//
				"SELECT DISTINCT year FROM Input input")//
				.list();
	}

	public double getInputMoneyWithYear(int year) {
		double d = 0.0;

		for(int month = 1 ; month <= Constant.MONTH ; month++ ){
			List<Input> inputs = getInputDataByMonth(month,year);
			for(Input inp :inputs ){
				d = Arith.add(d, inp.getMoney());	
			}
			
		}
		return d;
	}


}


