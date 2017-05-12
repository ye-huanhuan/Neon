package com.neon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Input;
import com.neon.service.InputService;

@Service
public class InputServiceImpl extends DaoSupportImpl<Input> implements InputService{

	@Override
	public List<Double> getInputTotleMoneyWithMonth(int year) {
		List<Double> list = new ArrayList<>();
		for(int month = 1 ; month <= 6 ; month++ ){
			List<Input> inputs = getInputDataByMonth(month,year);
			double d = 0.0;
			for(Input inp : inputs){
				d += inp.getMoney();
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
		return null;
	}

	@Override
	public Map<Integer, Double> getInputTotleMoneyWithYear() {
		// TODO Auto-generated method stub
		return null;
	}

}
