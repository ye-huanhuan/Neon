package com.neon.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Detail;
import com.neon.service.DetailService;

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

}
