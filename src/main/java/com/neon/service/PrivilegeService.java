package com.neon.service;

import com.neon.base.DaoSupport;
import com.neon.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege>{

	Long[] getIdsByItems(String[] privilegeItems_1);

}
