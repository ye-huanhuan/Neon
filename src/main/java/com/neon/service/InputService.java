package com.neon.service;

import java.util.List;
import java.util.Map;

import com.neon.base.DaoSupport;
import com.neon.domain.Input;

public interface InputService extends DaoSupport<Input>{

	//该年每个月的进项总钱数
	List<Double> getInputTotleMoneyWithMonth(int year);
	
	//该年每个季度的进项总钱数
	List<Double> getInputTotleMoneyWithQuarter(int year);
	
	//每年进项的总钱数  key为 年份  value为 该年的进项总钱数
	Map<Integer, Double> getInputTotleMoneyWithYear();
	
}
