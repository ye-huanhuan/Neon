package com.neon.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.neon.service.DvalueService;
import com.neon.service.InputService;
import com.neon.service.LimiteService;
import com.neon.service.OutputService;
import com.neon.service.RoleService;
import com.neon.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class ActionBase<T> extends ActionSupport implements ModelDriven<T>{

	public T model;
	
	//-------------------modeldriven的支持-----------------------------------------------
	
	public ActionBase(){
		try{
			//通过反射技术获得model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			//通过反射创建model的实例
			this.model = clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T getModel(){
		return model;
	}
	
	//--------------------Service实例的声明------------------------------------------------------------
	@Resource
	public UserService userService;
	
	@Resource
	public RoleService roleService;
	
	@Resource
	public LimiteService limiteService;
	
	@Resource
	public InputService inputService;
	
	@Resource
	public OutputService outputService;
	
	@Resource
	public DvalueService dvalueService;
	
	
	
}
