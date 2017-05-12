package com.neon.service;

import com.neon.base.DaoSupport;
import com.neon.domain.Dvalue;

public interface DvalueService extends DaoSupport<Dvalue>{

	Long getMaxIdInDvalues();

}
