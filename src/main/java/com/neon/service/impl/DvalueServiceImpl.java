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
	public double[] getPdvalueAndNdvalue_month(Dvalue dva) {
		double[] pAndNdvalue = new double[2];
		pAndNdvalue[0] = dva.getPdvalue_month();
		pAndNdvalue[1] = dva.getNdvalue_month();
		return pAndNdvalue;
	}
	
	@Override
	public double[] getPdvalueAndNdvalue_quarter(Dvalue dva) {
		double[] pAndNdvalue = new double[2];
		pAndNdvalue[0] = dva.getPdvalue_quarter();
		pAndNdvalue[1] = dva.getNdvalue_quarter();
		return pAndNdvalue;
	}
	
	@Override
	public double[] getPdvalueAndNdvalue_year(Dvalue dva) {
		double[] pAndNdvalue = new double[2];
		pAndNdvalue[0] = dva.getPdvalue_year();
		pAndNdvalue[1] = dva.getNdvalue_year();
		return pAndNdvalue;
	}


	@Override
	public double[] getCurrentTargets(Dvalue dva) {
		double[] target = new double[3];
		target[0] = dva.getTarget_month();
		target[1] = dva.getTarget_quarter();
		target[2] = dva.getTarget_year();
		return target;
	}

}
