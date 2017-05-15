package com.neon.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Limite;
import com.neon.service.LimiteService;

@Service
public class LimiteServiceImpl extends DaoSupportImpl<Limite> implements LimiteService{

	@Override
	public List<Limite> findTopLimite(List<Limite> limites) {
		// TODO Auto-generated method stub
		List<Limite> tops = new ArrayList<>();
		for(Limite lim : limites){
			if(lim.getParent() == null){
				tops.add(lim);
			}
		}
		return tops;
	}

	@Override
	public List<Limite> findTopList() {
		return getSession().createQuery(//
				"FROM Limite limite	WHERE limite.parent IS NULL")
				.list();
	}


}
