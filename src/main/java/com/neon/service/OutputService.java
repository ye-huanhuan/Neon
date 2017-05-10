package com.neon.service;

import java.util.List;
import java.util.Map;

import com.neon.base.DaoSupport;
import com.neon.domain.Output;

public interface OutputService extends DaoSupport<Output>{

		//该年每个月的出项总钱数
		List<Double> getOutputTotleMoneyWithMonth(int year);
		
		//该年每个季度的出项总钱数
		List<Double> getOutputTotleMoneyWithQuarter(int year);
		
		//每年出项的总钱数  key为 年份  value为 该年的出项总钱数
		Map<Integer, Double> getOutputTotleMoneyWithYear();
}
