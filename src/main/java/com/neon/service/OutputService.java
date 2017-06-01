package com.neon.service;

import java.util.List;
import java.util.Map;

import com.neon.base.DaoSupport;
import com.neon.domain.Output;

public interface OutputService extends DaoSupport<Output>{

		//==============月份==========================
	
		//该年每个月的出项总钱数
		List<Double> getOutputTotleMoneyWithMonth(int year);
		
		//该年的每个出售商品 在每个月的销售的总钱数
		Map<String, List<Double>> getEveryGoodsgetOutputTotleMoneyWithYear(int year);
		
		//该年某个月的商品销售的所占的百分比
		Map<String, Double> getThisMonthOutputGoodsTotleMoney(int month , int year);
		
		//=============季度===========================
		
		//该年每个季度的出项总钱数
		List<Double> getOutputTotleMoneyWithQuarter(int year);
		
		//该年的每个出售的商品 在每个季度的销售的总钱数
		Map<String, List<Double>> getEveryGoodsgetOutputQuarterTotleMoneyWithYear(int year);

		//该年某个季度的商品销售的所占的百分比
		Map<String, Double> getThisQuarterOutputGoodsTotleMoney(int quarter, int year);
		

		//================年份==========================
		
		//每年出项的总钱数  key为 年份  value为 该年的出项总钱数
		List<Double> getOutputTotleMoneyWithYear();
		
		//每个出售的商品 在近6年的销售的总钱数
		Map<String, List<Double>> getRecentYearsOutputGoodsTotleMoney();
		
		//该年的商品销售的所占的百分比
		Map<String, Double> getThisYearOutputGoodsTotleMoney(int year);
		
		//得到差值
		List<Double> getDvalue(List<Double> input_totlemoney_month, List<Double> output_totlemoney_month);

		//在该月份中得到top3商品
		Map<String, Double> getThisMonthTop3GoodsMoney(int m, int yEAR);

		//在该季度中得到top3商品
		Map<String, Double> getThisQuarterTop3GoodsMoney(int quarter_quarter_3, int yEAR);
		
		//在该年中得到top3商品
		Map<String, Double> getThisYearTop3GoodsMoney(int year_year_3);

		String[] getItemByMap(Map<String, Double> output_top3_month);

		double[] getValueByMap(Map<String, Double> output_top3_month);

		double[] getThisMonthOutputGoodsTotleMoney(int cURRENTMONTH, int yEAR, String[] items);

		double[] getThisQuarterOutputGoodsTotleMoney(int cURRENTMONTH, int yEAR, String[] items);

		//得到该季度的每个月的销售额
		List<double[]> getMomthValueByMap(String[] output_top3_quarter, int quarter_quarter_3);

		//得到该年的每个季度的销售额
		List<double[]> getQuarterValueByMap(String[] output_top3_key , int year);
		
		//根据季度得到月分的值
		String[] getMomthByQuarter(int quarter_quarter_3);


		
}
