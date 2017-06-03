package com.neon.service;

import com.neon.base.DaoSupport;
import com.neon.domain.Inout;

public interface InoutService extends DaoSupport<Inout>{

	String[] getInputItemByOutputItem(String[] item);

}
