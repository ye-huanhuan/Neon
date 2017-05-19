package com.neon.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class InitListener implements ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent arg1) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext ap = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
		//LimiteService limiteService = (LimiteService) ap.getBean("limiteServiceImpl");
		//List<Limite> topLimites = limiteService.findTopList();
		//sce.getServletContext().setAttribute("topLimites", topLimites);
		System.out.println("------>已准备权限数据<------");

	}

}
