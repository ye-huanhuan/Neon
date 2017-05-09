package com.neon.service;

import java.util.List;

import com.neon.base.DaoSupport;
import com.neon.domain.Input;

public interface InputService extends DaoSupport<Input>{

	//每个月的进项总钱数
	List<Double> getInputTotleMoneyWithMonth();

}
