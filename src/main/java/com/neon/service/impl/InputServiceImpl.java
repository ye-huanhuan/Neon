package com.neon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Input;
import com.neon.service.InputService;

@Service
public class InputServiceImpl extends DaoSupportImpl<Input> implements InputService{

	@Override
	public List<Double> getInputTotleMoneyWithMonth() {
		List<Double> list = new ArrayList<>();
		for(int month = 1 ; month <= 6 ; month++ ){
			List<Input> inputs = getInputDataByMonth(month);
			double d = 0;
			for(Input inp : inputs){
				System.out.println(inp.getItem());
				d += inp.getMoney();
			}
			System.out.println(d);
			list.add(d);
		}
		return list;
	}
	
	public List<Input> getInputDataByMonth(int month){
		return getSession().createQuery(//
				"FROM Input input WHERE input.month=?")
				.setParameter(0, month)
				.list();
	}

}
