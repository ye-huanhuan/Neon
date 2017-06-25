package com.neon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Detail;
import com.neon.domain.Output;
import com.neon.service.DetailService;
import com.neon.util.Arith;
import com.neon.util.Constant;

@Service
public class DetailServiceImpl extends DaoSupportImpl<Detail> implements DetailService{

	@Override
	public List<Detail> getDetailByTimeSort() {
		return getSession().createQuery(//
				"FROM Detail detail ORDER BY date DESC")
				.list();
	}

	@Override
	public List<Detail> getDetailByMoneySort() {
		return getSession().createQuery(//
				"FROM Detail detail ORDER BY money DESC")
				.list();
	}

	@Override
	public List<Detail> searchDetail(String search) {
		return getSession().createQuery(//
				"FROM Detail detail WHERE detail.ein=? OR detail.payUnit=? OR detail.receUnit=?")
				.setParameter(0, search)
				.setParameter(1, search)
				.setParameter(2, search)
				.list();
	}

	/**
	 * 里面的list装的是  月份 税收额 月份环比 年份同比 年内占比
	 * 外面的list装 的是里面的每个list
	 */
	@Override
	public List<Map<String, List<List<String>>>> getDataToTheSame() {
		List<Map<String, List<List<String>>>> list = new ArrayList<>();
		double this_year_money = 0;
		double last_year_money = 0;
		double this_month_money = 0;
		double last_month_money = 0;
		for(int year : getOutputYear()){
			Map<String, List<List<String>>> map = new HashMap<>();
			List<List<String>> list_1 = new ArrayList<>();
			
			//今年的总共销售额
			List<Output> this_year_outs = getOutputsWithYear(year);
			for(Output out : this_year_outs){
				this_year_money = Arith.add(this_year_money, out.getMoney());
			}
			
			//判断 是否是当前年
			if(year == Constant.YEAR){
				for(int i = 1 ; i < Constant.CURRENTMONTH ; i++){
					this_month_money = 0;
					List<String> list_2 = new ArrayList<>();
					//月份
					list_2.add(i+"");
					List<Output> outs = getOutputsWithMonthAndYear(i, year);
					for(Output out : outs){
						this_month_money =Arith.add(this_month_money, out.getMoney());
					}
					//税收额
					list_2.add(this_month_money+"");
					//月份环比
					if(i == 1){
						list_2.add("--");
						last_month_money = this_month_money;
					}else{
						//本月/上一个月
						list_2.add(Arith.mul(Arith.div(this_month_money, last_month_money , 4) , 100.0) +"%");
						last_month_money = this_month_money;
					}
					//年份同比
					if(year == getOutputYear().get(getOutputYear().size() - 1)){
						list_2.add("--");
					}else{
						List<Output> last_year_outs = getOutputsWithMonthAndYear(i, year - 1);
						for(Output out : last_year_outs){
							last_year_money = Arith.add(last_year_money, out.getMoney());
						}
						list_2.add(Arith.mul(Arith.div(this_month_money, last_year_money, 4) , 100.0) + "%");
					}
					//年份占比
					list_2.add(Arith.mul(Arith.div(this_month_money, this_year_money, 4) , 100.0) + "%");
					
					list_1.add(list_2);
				}
				
				for(int i = Constant.CURRENTMONTH ; i <= 12 ; i++){
					List<String> list_2 = new ArrayList<>();
					list_2.add("--");
					list_2.add("--");
					list_2.add("--");
					list_2.add("--");
					list_2.add("--");
					
					list_1.add(list_2);
				}
				
				map.put(year+"", list_1);
				list.add(map);
			}else{
				for(int i = 1 ; i <= 12 ; i++){
					this_month_money = 0;
					List<String> list_2 = new ArrayList<>();
					//月份
					list_2.add(i+"");
					List<Output> outs = getOutputsWithMonthAndYear(i, year);
					for(Output out : outs){
						this_month_money =Arith.add(this_month_money, out.getMoney());
					}
					//税收额
					list_2.add(this_month_money+"");
					//月份环比
					if(i == 1){
						list_2.add("--");
						last_month_money = this_month_money;
					}else{
						//本月/上一个月
						list_2.add(Arith.mul(Arith.div(this_month_money, last_month_money , 4) , 100.0) +"%");
						last_month_money = this_month_money;
					}
					//年份同比
					if(year == getOutputYear().get(getOutputYear().size() - 1)){
						list_2.add("--");
					}else{
						List<Output> last_year_outs = getOutputsWithMonthAndYear(i, year - 1);
						for(Output out : last_year_outs){
							last_year_money = Arith.add(last_year_money, out.getMoney());
						}
						list_2.add(Arith.mul(Arith.div(this_month_money, last_year_money, 4) , 100.0) + "%");
					}
					//年份占比
					list_2.add(Arith.mul(Arith.div(this_month_money, this_year_money, 4) , 100.0) + "%");
					
					list_1.add(list_2);
				}
				map.put(year+"", list_1);
				list.add(map);
			}
			
			
		}
		return list;
	}
	
	@Override
	public List<Map<String, List<List<String>>>> getDataToTheSame(int[] years) {
		List<Map<String, List<List<String>>>> list = new ArrayList<>();
		double this_year_money = 0;
		double last_year_money = 0;
		double this_month_money = 0;
		double last_month_money = 0;
		for(int year : years){
			Map<String, List<List<String>>> map = new HashMap<>();
			List<List<String>> list_1 = new ArrayList<>();
			
			//今年的总共销售额
			List<Output> this_year_outs = getOutputsWithYear(year);
			for(Output out : this_year_outs){
				this_year_money = Arith.add(this_year_money, out.getMoney());
			}
			
			//判断 是否是当前年
			if(year == Constant.YEAR){
				for(int i = 1 ; i < Constant.CURRENTMONTH ; i++){
					this_month_money = 0;
					List<String> list_2 = new ArrayList<>();
					//月份
					list_2.add(i+"");
					List<Output> outs = getOutputsWithMonthAndYear(i, year);
					for(Output out : outs){
						this_month_money =Arith.add(this_month_money, out.getMoney());
					}
					//税收额
					list_2.add(this_month_money+"");
					//月份环比
					if(i == 1){
						list_2.add("--");
						last_month_money = this_month_money;
					}else{
						//本月/上一个月
						list_2.add(Arith.mul(Arith.div(this_month_money, last_month_money , 4) , 100.0) +"%");
						last_month_money = this_month_money;
					}
					//年份同比
					if(year == getOutputYear().get(getOutputYear().size() - 1)){
						list_2.add("--");
					}else{
						List<Output> last_year_outs = getOutputsWithMonthAndYear(i, year - 1);
						for(Output out : last_year_outs){
							last_year_money = Arith.add(last_year_money, out.getMoney());
						}
						list_2.add(Arith.mul(Arith.div(this_month_money, last_year_money, 4) , 100.0) + "%");
					}
					//年份占比
					list_2.add(Arith.mul(Arith.div(this_month_money, this_year_money, 4) , 100.0) + "%");
					
					list_1.add(list_2);
				}
				
				for(int i = Constant.CURRENTMONTH ; i <= 12 ; i++){
					List<String> list_2 = new ArrayList<>();
					list_2.add("--");
					list_2.add("--");
					list_2.add("--");
					list_2.add("--");
					list_2.add("--");
					
					list_1.add(list_2);
				}
				
				map.put(year+"", list_1);
				list.add(map);
			}else{
				for(int i = 1 ; i <= 12 ; i++){
					this_month_money = 0;
					List<String> list_2 = new ArrayList<>();
					//月份
					list_2.add(i+"");
					List<Output> outs = getOutputsWithMonthAndYear(i, year);
					for(Output out : outs){
						this_month_money =Arith.add(this_month_money, out.getMoney());
					}
					//税收额
					list_2.add(this_month_money+"");
					//月份环比
					if(i == 1){
						list_2.add("--");
						last_month_money = this_month_money;
					}else{
						//本月/上一个月
						list_2.add(Arith.mul(Arith.div(this_month_money, last_month_money , 4) , 100.0) +"%");
						last_month_money = this_month_money;
					}
					//年份同比
					if(year == getOutputYear().get(getOutputYear().size() - 1)){
						list_2.add("--");
					}else{
						List<Output> last_year_outs = getOutputsWithMonthAndYear(i, year - 1);
						for(Output out : last_year_outs){
							last_year_money = Arith.add(last_year_money, out.getMoney());
						}
						list_2.add(Arith.mul(Arith.div(this_month_money, last_year_money, 4) , 100.0) + "%");
					}
					//年份占比
					list_2.add(Arith.mul(Arith.div(this_month_money, this_year_money, 4) , 100.0) + "%");
					
					list_1.add(list_2);
				}
				map.put(year+"", list_1);
				list.add(map);
			}
			
			
		}
		return list;
	}
	
	/*
	 * 产品  月份 税收额 月份环比 年份同比 月内占比 月内排名
	 * (non-Javadoc)
	 * @see com.neon.service.DetailService#getDataToProdect()
	 */
	@Override
	public List<Map<String, List<List<String>>>> getDataToProdect() {
		List<Map<String, List<List<String>>>> list = new ArrayList<>();
		List<String> outs_item = getEveryGoodsItem(Constant.YEAR);
		double last_year_money = 0;
		double this_month_money = 0;
		double last_month_money = 0;
		double totle_money = 0;
		for(String item : outs_item){
			Map<String, List<List<String>>> map = new HashMap<>();
			List<List<String>> list_1 = new ArrayList<>();
			
			for(int i = 1 ; i < Constant.CURRENTMONTH ; i++){
				List<String> list_2 = new ArrayList<>();
				try{
				
				//月份
				list_2.add(i+"");
				//税收额
				this_month_money = getThisMonthThisGoodsTotleMoney(item, i, Constant.YEAR);
				list_2.add(this_month_money + "");
				//月份环比
				if(i == 1){
					list_2.add("--");
					last_month_money = this_month_money;
				}else{
					list_2.add(Arith.mul(Arith.div(this_month_money, last_month_money, 4), 100.0) + "%");
					last_month_money = this_month_money;
				}
				
				//年内同比
				try {
					last_year_money = getThisMonthThisGoodsTotleMoney(item, i, Constant.YEAR - 1);
					list_2.add(Arith.mul(Arith.div(this_month_money, last_year_money, 4) , 100.0)+"%");
				} catch (Exception e) {
					list_2.add("--");
				}
				
				
				//月内占比
				List<Output> outs = getOutputsWithMonthAndYear(i, Constant.YEAR);
				for(Output out : outs){
					totle_money = Arith.add(totle_money, out.getMoney());
				}
				list_2.add(Arith.mul(Arith.div(this_month_money, totle_money, 4), 100.0)+"%");
				
				//月内排名
				List<Double> list_3 = new ArrayList<>();
				for(String str : outs_item){
					System.out.println("3");
					try{
						list_3.add(getThisMonthThisGoodsTotleMoney(str, i, Constant.YEAR));
					}catch (Exception e) {
						list_3.add(0.0);
					}
				}
				int temp = 1;
				for(String str : bubbleSort(outs_item, list_3)){
					if(str.equals(item)){
						break;
					}
					temp++;
				}
				list_2.add(temp+"");
				
				
				list_1.add(list_2);
			}catch (Exception e) {
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				
				list_1.add(list_2);
			}
				
			}
			for(int temp = Constant.CURRENTMONTH ; temp <= 12 ; temp++){
				List<String> list_2 = new ArrayList<>();
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				
				list_1.add(list_2);
			}
			
				map.put(item , list_1);
				list.add(map);
		}
		return list;
	}
	
	private String[] bubbleSort(List<String> list , List<Double> list_2){
		String[] strs = new String[list.size()];
		for(int i = 0 ; i < list.size() ; i++){
			strs[i] = list.get(i);
		}
		double[] a = new double[list_2.size()];
		for(int i = 0 ; i < list_2.size() ; i++){
			a[i] = list_2.get(i);
		}
		double temp = 0;
		String str = "";
		for(int i=0;i<a.length-1;i++){  
	        for(int j=0;j<a.length-1-i;j++){  
	        if(a[j]>a[j+1]){  
	            temp=a[j];  
	            a[j]=a[j+1];  
	            a[j+1]=temp;
	            
	            str = strs[j];
	            strs[j] = strs[j+1];
	            strs[j+1] = str;
	        }  
	        }  
	    }  
		return strs;
	}
	
	@Override
	public List<Map<String, List<List<String>>>> getDataToProdect(String[] products) {
		List<Map<String, List<List<String>>>> list = new ArrayList<>();
		List<String> outs_item = getEveryGoodsItem(Constant.YEAR);
		double last_year_money = 0;
		double this_month_money = 0;
		double last_month_money = 0;
		double totle_money = 0;
		for(String item : products){
			Map<String, List<List<String>>> map = new HashMap<>();
			List<List<String>> list_1 = new ArrayList<>();
			
			for(int i = 1 ; i < Constant.CURRENTMONTH ; i++){
				List<String> list_2 = new ArrayList<>();
				try{
				
				//月份
				list_2.add(i+"");
				//税收额
				this_month_money = getThisMonthThisGoodsTotleMoney(item, i, Constant.YEAR);
				list_2.add(this_month_money + "");
				//月份环比
				if(i == 1){
					list_2.add("--");
					last_month_money = this_month_money;
				}else{
					list_2.add(Arith.mul(Arith.div(this_month_money, last_month_money, 4), 100.0) + "%");
					last_month_money = this_month_money;
				}
				
				//年内同比
				try {
					last_year_money = getThisMonthThisGoodsTotleMoney(item, i, Constant.YEAR - 1);
					list_2.add(Arith.mul(Arith.div(this_month_money, last_year_money, 4) , 100.0)+"%");
				} catch (Exception e) {
					list_2.add("--");
				}
				
				
				//月内占比
				List<Output> outs = getOutputsWithMonthAndYear(i, Constant.YEAR);
				for(Output out : outs){
					totle_money = Arith.add(totle_money, out.getMoney());
				}
				list_2.add(Arith.mul(Arith.div(this_month_money, totle_money, 4), 100.0)+"%");
				
				//月内排名
				List<Double> list_3 = new ArrayList<>();
				for(String str : outs_item){
					System.out.println("3");
					try{
						list_3.add(getThisMonthThisGoodsTotleMoney(str, i, Constant.YEAR));
					}catch (Exception e) {
						list_3.add(0.0);
					}
				}
				int temp = 1;
				for(String str : bubbleSort(outs_item, list_3)){
					if(str.equals(item)){
						break;
					}
					temp++;
				}
				list_2.add(temp+"");
				
				
				list_1.add(list_2);
			}catch (Exception e) {
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				
				list_1.add(list_2);
			}
				
			}
			for(int temp = Constant.CURRENTMONTH ; temp <= 12 ; temp++){
				List<String> list_2 = new ArrayList<>();
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				list_2.add("--");
				
				list_1.add(list_2);
			}
			
				map.put(item , list_1);
				list.add(map);
		}
		return list;
	}
	
	
	
	private double getThisMonthThisGoodsTotleMoney(String item, int month, int year) {
		return (double) getSession().createQuery(//
				"SELECT money FROM Output out WHERE out.month=? AND out.year=? AND out.item=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.setParameter(2, item)
				.uniqueResult();
	}
	
	private List<String> getEveryGoodsItem(int year) {
		return getSession().createQuery(//
				"SELECT DISTINCT item FROM Output out WHERE out.year=?")
				.setParameter(0, year)
				.list();
	}
	
	private List<Integer> getOutputYear() {
		return getSession().createQuery(//
				"SELECT DISTINCT year FROM Output output")
				.list();
	}
	
	private List<Output> getOutputsWithMonthAndYear(int month,int year) {
		return getSession().createQuery(//
				"FROM Output output WHERE output.month=? AND output.year=?")
				.setParameter(0, month)
				.setParameter(1, year)
				.list();
	}
	
	private List<Output> getOutputsWithYear(Integer year) {
		return getSession().createQuery(//
				"FROM Output output WHERE output.year=?")
				.setParameter(0, year)
				.list();
	}

}
