package com.neon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Input;
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
	

	public List<Input> getInputDataByMonth(int month,int year){
		return getSession().createQuery(//
				"FROM Input input WHERE input.month=? AND input.year=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.list();
		
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
	public Map<Integer, Double> getInputTotleMoneyWithYear() {
		// TODO Auto-generated method stub
		Map<Integer,Double> map=new HashMap<Integer,Double>();
		List<Integer> syear = getInputYear();
		for(Integer year : syear){
			Double money =  getInputMoneyWithYear(year);
			map.put(year, money);
		}
		
		return map ; 
	}
	
	private List<Integer> getInputYear(){
		return getSession().createQuery(//
				"SELECT DISTINCT year FROM Input input")//
				.list();
	}

	public double getInputMoneyWithYear(int year) {
		double d = 0.0;
		for(int month = 1 ; month <= Constant.MONTH; month++ ){
			List<Input> inputs = getInputDataByMonth(month,year);
			for(Input inp :inputs ){
				d = Arith.add(d, inp.getMoney());	
			}
			
		}
		return d;
	}
	
	
	
	}


