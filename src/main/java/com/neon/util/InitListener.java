package com.neon.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.neon.domain.Privilege;
import com.neon.service.PrivilegeService;


public class InitListener implements ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent arg1) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext ap = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService) ap.getBean("privilegeServiceImpl");
		List<Privilege> topPrivileges = privilegeService.findTopList();
		List<Privilege> topPrivilege_2 = privilegeService.getTop2List(topPrivileges.get(1));
		for(Privilege p : topPrivilege_2){
			System.out.println(p.getLimiteName());
		}
		sce.getServletContext().setAttribute("topPrivileges", topPrivileges);
		sce.getServletContext().setAttribute("topPrivilege_2", topPrivilege_2);
		System.out.println("------>已准备权限数据<------");

	}

}
