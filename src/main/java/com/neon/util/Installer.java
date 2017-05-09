package com.neon.util;

import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.neon.domain.Limite;
import com.neon.domain.Role;
import com.neon.domain.User;

@Component
public class Installer {
	
/*	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		Role role1 = new Role();
		role1.setRoleName("");
		
		Role role2 = new Role();
		role2.setRoleName("");
		
		//==============添加权限============================
		Set<Role> roles1 = null;
		Set<Limite> limites1 = null;
		roles1.add(role1);
		roles1.add(role2);
		Limite limite = new Limite("首页","", roles1);
		session.save(limite);
		
		//==============================================
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}*/

}
