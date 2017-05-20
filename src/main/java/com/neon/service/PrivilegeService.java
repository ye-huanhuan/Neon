package com.neon.service;

import java.util.List;

import com.neon.base.DaoSupport;
import com.neon.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege>{

	Long[] getIdsByItems(String[] privilegeItems_1);

	List<Privilege> findTopList();

	List<Privilege> getTop2List(Privilege p);

}
