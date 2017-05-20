package com.neon.service;

import com.neon.base.DaoSupport;
import com.neon.domain.Dvalue;

public interface DvalueService extends DaoSupport<Dvalue>{

	Long getMaxIdInDvalues();
	
	//得到利润和亏损的标准
	double[] getPdvalueAndNdvalue(Dvalue dva);

}
