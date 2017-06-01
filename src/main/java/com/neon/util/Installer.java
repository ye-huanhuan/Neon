package com.neon.util;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.neon.domain.Privilege;
import com.neon.service.PrivilegeService;


@Component
public class Installer {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		
		//==============添加权限============================
		Privilege  privilege2 , privilege3;
		//privilege1 = new Privilege("首页","#",null);
		//session.save(privilege1);
		
		privilege2 = new Privilege("分析","#",null);
		session.save(privilege2);
		
		privilege3 = new Privilege("设置","#",null);
		session.save(privilege3);
		
		session.save(new Privilege("月份分析","analyze_month.action",privilege2));
		session.save(new Privilege("季度分析","analyze_quarter.action",privilege2));
		session.save(new Privilege("年度分析","analyze_year.action",privilege2));
		session.save(new Privilege("税收分析","analyze_tax.action",privilege2));
		session.save(new Privilege("明细分析","analyze_detail.action",privilege2));

		session.save(new Privilege("设置数据","invoice_setDvalue.action",privilege3));
		
		//==============================================
		
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}

}
