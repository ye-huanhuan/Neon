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
import com.neon.util.Sort;

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
	
	@Override
	public double[] getThisQuarterInputGoodsTotleMoney(int quarter, int year, String[] items) {
		double[] dou = new double[items.length];
		switch(quarter){
		case 1 : 
			int temp = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 1 ; month <= 3 ; month++){
					double d = 0.0;
					try{
						d = getThisItemTotleMoney(item,month,year);
					}catch (Exception e) {
						d = 0.0;
					}
					money = Arith.add(money , d);
				}
				dou[temp] = money;
				temp++;
			};
			break;
		case 2 :
			int temp_2 = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 4 ; month <= 6 ; month++){
					double d = 0.0;
					try{
						d = getThisItemTotleMoney(item,month,year);
					}catch (Exception e) {
						d = 0.0;
					}
					money = Arith.add(money , d);
				}
				dou[temp_2] = money;
				temp_2++;
			};
			break;
		case 3 :
			int temp_3 = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 7 ; month <= 9 ; month++){
					double d = 0.0;
					try{
						d = getThisItemTotleMoney(item,month,year);
					}catch (Exception e) {
						d = 0.0;
					}
					money = Arith.add(money , d);
				}
				dou[temp_3] = money;
				temp_3++;
			};
			break;
		case 4 :
			int temp_4 = 0;
			for(String item : items){
				double money = 0.0;	
				for(int month = 10 ; month <= 12 ; month++){
					double d = 0.0;
					try{
						d = getThisItemTotleMoney(item,month,year);
					}catch (Exception e) {
						d = 0.0;
					}
					money = Arith.add(money , d);
				}
				dou[temp_4] = money;
				temp_4++;
			};
			break;
		}
		return dou;
	}
	
	@Override
	public double[][] getMonthMoneyByQuarterAndYearAnditems(int year, int quarter, String[] items) {
		double[][] d = new double[items.length][];
		for(int q = 0 ; q < items.length ; q++){
			d[q] = new double[3];
		}
		
		switch (quarter) {
		case 1:
			int temp = 0;
			for(String item : items){
				int j = 0;
				for(int i = 1 ; i <= 3 ; i++){
					try {
						d[temp][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp][j] = 0.0;
					}
					j++;
				}
				temp++;
			}
			break;
		case 2:
			int temp_2 = 0;
			for(String item : items){
				int j = 0;
				for(int i = 4 ; i <= 6 ; i++){
					try {
						d[temp_2][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e){
						d[temp_2][j] = 0.0;
					}
					j++;
				}
				temp_2++;
			}
			break;
		case 3:
			int temp_3 = 0;
			for(String item : items){
				int j = 0;
				for(int i = 7 ; i <= 9 ; i++){
					try {
						d[temp_3][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp_3][j] = 0.0;
					}
					j++;
				}
				temp_3++;
			}
			break;
		case 4:
			int temp_4 = 0;
			for(String item : items){
				int j = 0;
				for(int i = 10 ; i <= 12 ; i++){
					try {
						d[temp_4][j] = getThisMonthThisGoodsTotleMoney(item, i, year);
					} catch (Exception e) {
						d[temp_4][j] = 0.0;
					}
					j++;
				}
				temp_4++;
			}
			break;
		}
		return d;
	}
	
	private double getThisMonthThisGoodsTotleMoney(String item, int month, int year) {
		return (double) getSession().createQuery(//
				"SELECT money FROM Input out WHERE out.month=? AND out.year=? AND out.item=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.setParameter(2, item)
				.uniqueResult();
	}


	private List<String> getThisMonthGoodsItemByMonth(int[] i, int year) {
		return getSession().createQuery(//
				"SELECT DISTINCT item FROM Input out WHERE out.year=? AND out.month=? OR out.month=? OR out.month=?")
				.setParameter(0, year)
				.setParameter(1, i[0])
				.setParameter(2, i[1])
				.setParameter(3, i[2])
				.list();
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


