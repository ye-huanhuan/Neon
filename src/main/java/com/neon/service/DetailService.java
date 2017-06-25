package com.neon.service;

import java.util.List;
import java.util.Map;

import com.neon.base.DaoSupport;
import com.neon.domain.Detail;

public interface DetailService extends DaoSupport<Detail>{

	//得到按时间排序的明细
	List<Detail> getDetailByTimeSort();

	//得到按钱由多到少排序
	List<Detail> getDetailByMoneySort();

	//根据要搜索的字段 来搜索
	List<Detail> searchDetail(String search);

	//得到 同比报报表的数据 
	List<Map<String, List<List<String>>>> getDataToTheSame();

	//得到 产品报表的数据
	List<Map<String, List<List<String>>>> getDataToProdect();

	//得到 指定产品的报表数据
	List<Map<String, List<List<String>>>> getDataToProdect(String[] products);

	//得到 指定年份的报表的数据
	List<Map<String, List<List<String>>>> getDataToTheSame(int[] years);

}
