package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Inout;
import com.neon.service.InoutService;

@Service
public class InoutServiceImpl extends DaoSupportImpl<Inout> implements InoutService{

	@Override
	public String[] getInputItemByOutputItem(String[] item) {
		String[] str = new String[item.length];
		for(int i = 0 ; i < item.length ; i++){
			str[i] = getInoutByOutput(item[i]);
		}
		return str;
	}

	private String getInoutByOutput(String string) {
		return (String) getSession().createQuery(//
				"SELECT input FROM Inout inout WHERE inout.output=?")
				.setParameter(0, string)
				.uniqueResult();
	}

}
