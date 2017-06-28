package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Inout;
import com.neon.service.InoutService;

@Service
public class InoutServiceImpl extends DaoSupportImpl<Inout> implements InoutService{

	@Override
	public String[] getInputItemByOutputItem(String[] item) {
		for(String str_1 : item){
			System.out.println(str_1);
		}
		String[] str = new String[item.length];
		for(int i = 0 ; i < item.length ; i++){
			System.out.println("==");
			str[i] = getInoutByOutput(item[i]);
			System.out.println("=====");
			System.out.println(str[i]);
		}
		for(String str_1 : str){
			System.out.println(str_1);
		}
		return str;
	}

	private String getInoutByOutput(String string) {
		System.out.println(string);
		string = "zhu";
		return (String) getSession().createQuery(//
				"SELECT input FROM `Inout` i WHERE i.output=?")
				.setParameter(0, string)
				.uniqueResult();
	}

}
