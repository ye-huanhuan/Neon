package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Dvalue;
import com.neon.service.DvalueService;

@Service
public class DvalueServiceImpl extends DaoSupportImpl<Dvalue> implements DvalueService{

	@Override
	public Long getMaxIdInDvalues() {
		
		return (Long) getSession().createQuery(//
				"SELECT MAX(id) FROM Dvalue")
				.uniqueResult();
	}

	@Override
	public double[] getPdvalueAndNdvalue(Dvalue dva) {
		double[] pAndNdvalue = new double[2];
		pAndNdvalue[0] = dva.getPdvalue();
		pAndNdvalue[1] = dva.getNdvalue();
		return pAndNdvalue;
	}

}
