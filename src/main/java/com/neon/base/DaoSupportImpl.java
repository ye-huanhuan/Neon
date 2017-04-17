package com.neon.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DaoSupportImpl<T> implements DaoSupport<T>{

	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")//将 没有用到的警告 去掉
	private Class<T> clazz = null;
	
	/**
	 * 获取当前泛型的类型
	 */
	@SuppressWarnings("unchecked")
	public DaoSupportImpl(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	/**
	 * 单例
	 * 获取当前可用的session
	 * @return
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object obj = getById(id);
		if(obj != null){
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if(id == null){
			return null;
		}else{
			return (T)getSession().get(clazz, id);
		}
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if(ids == null && ids.length == 0){
			return Collections.EMPTY_LIST;
		}else{
		return getSession().createQuery(//
				"FROM "+ clazz.getSimpleName()+" WHERE id IN (:ids)")//
				.setParameterList("ids", ids)
				.list();
	   }
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

}
