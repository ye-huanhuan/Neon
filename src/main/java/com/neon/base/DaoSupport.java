package com.neon.base;

import java.util.List;

/**
 * 
 * @author 昊仔很忙
 *
 */
public interface DaoSupport<T>{
/**
 * 保存实体
 * @param entity
 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更改实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 按id  查找
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 按 ids 查找
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * 查找所有
	 * @return
	 */
	List<T> findAll();
}
