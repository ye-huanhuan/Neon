package com.neon.service.impl;

import org.springframework.stereotype.Service;

import com.neon.base.DaoSupportImpl;
import com.neon.domain.Privilege;
import com.neon.service.PrivilegeService;
@Service
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService{

	@Override
	public Long[] getIdsByItems(String[] privilegeItems_1) {
		Long[] ids = new Long[privilegeItems_1.length];
		for(int i = 0 ; i < privilegeItems_1.length ; i++){
			ids[i] = getIdByItem(privilegeItems_1[i]);
			System.out.println(getIdByItem(privilegeItems_1[i]));
		}
		return null;
	}

	private Long getIdByItem(String string) {
		return (Long) getSession().createQuery(//
				"SELECT id FROM Privilege p WHERE p.limiteName=?")
				.setParameter(0, string)
				.uniqueResult();
	}

}
