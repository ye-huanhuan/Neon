package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Inout_;
import com.neon.service.InoutService;

@Service
public class InoutServiceImpl extends DaoSupportImpl<Inout_> implements InoutService{

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
				"SELECT input FROM Inout_ i WHERE i.output=?")
				.setParameter(0, string)
				.uniqueResult();
	}

}
