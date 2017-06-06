package com.neon.service;

import java.util.List;

import com.neon.base.DaoSupport;
import com.neon.domain.Detail;

public interface DetailService extends DaoSupport<Detail>{

	//得到按时间排序的明细
	List<Detail> getDetailByTimeSort();

	//得到按钱由多到少排序
	List<Detail> getDetailByMoneySort();

	//根据要搜索的字段 来搜索
	List<Detail> searchDetail(String search);

}
