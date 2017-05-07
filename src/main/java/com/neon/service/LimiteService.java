package com.neon.service;

import java.util.List;
import java.util.Set;

import com.neon.base.DaoSupport;
import com.neon.domain.Limite;

public interface LimiteService extends DaoSupport<Limite>{

	List<Limite> findTopLimite(Set<Limite> limites);

}
