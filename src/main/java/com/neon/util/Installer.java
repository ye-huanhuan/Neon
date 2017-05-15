package com.neon.util;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.neon.domain.Limite;

@Component
public class Installer {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		
		//==============添加权限============================
		Limite limite1 , limite2 , limite3;
		limite1 = new Limite();
		/*limite1.setLimiteName("首页");
		limite1.setActionName("home_index.action");*/
		session.save(limite1);
		/*limite2 = new Limite("分析", "#"	, null);
		limite3 = new Limite("设置数据", "#", null);
		
		session.save(limite2);
		session.save(limite3);*/
		
		/*session.save(new Limite("月份分析", "analyze_month.action", limite2));
		session.save(new Limite("季度份分析", "analyze_quarter.action", limite2));
		session.save(new Limite("年份分析", "analyze_year.action", limite2));
		session.save(new Limite("税收分析", "analyze_tax.action", limite2));
		
		session.save(new Limite("设置数据", "invoice_setDvalue.action", limite3));*/
		
		//==============================================
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}

}
