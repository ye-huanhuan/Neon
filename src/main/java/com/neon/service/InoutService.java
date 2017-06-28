package com.neon.service;

import com.neon.base.DaoSupport;
import com.neon.domain.Inout_;

public interface InoutService extends DaoSupport<Inout_>{

	String[] getInputItemByOutputItem(String[] item);

}
