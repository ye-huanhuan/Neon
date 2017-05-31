package com.neon.service;

import com.neon.base.DaoSupport;
import com.neon.domain.Dvalue;

public interface DvalueService extends DaoSupport<Dvalue>{

	Long getMaxIdInDvalues();
	
	//得到利润和亏损的标准 月
	double[] getPdvalueAndNdvalue_month(Dvalue dva);
	
	//得到利润和亏损的标准 季度
	double[] getPdvalueAndNdvalue_quarter(Dvalue dva);
	
	//得到利润和亏损的标准 年
	double[] getPdvalueAndNdvalue_year(Dvalue dva);

	//得到当前（月季度年 数组）的目标
	double[] getCurrentTargets(Dvalue dva);

}
