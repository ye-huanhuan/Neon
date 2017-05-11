package com.neon.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Output;
import com.neon.service.OutputService;

@Service
public class OutputServiceImpl extends DaoSupportImpl<Output> implements OutputService{

	@Override
	public List<Double> getOutputTotleMoneyWithMonth(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> getOutputTotleMoneyWithQuarter(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Double> getOutputTotleMoneyWithYear() {
		// TODO Auto-generated method stub
		return null;
	}

}
