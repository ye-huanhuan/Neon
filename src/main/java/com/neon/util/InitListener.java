package com.neon.util;

import java.util.Collection;
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
		List<Privilege> topPrivilege_2 = privilegeService.getTop2List(topPrivileges.get(0));
		List<Privilege> topPrivilege_3 = privilegeService.getTop2List(topPrivileges.get(1));
		Collection<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		sce.getServletContext().setAttribute("topPrivileges", topPrivileges);
		sce.getServletContext().setAttribute("topPrivilege_2", topPrivilege_2);
		sce.getServletContext().setAttribute("topPrivilege_3", topPrivilege_3);
		sce.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("------>已准备权限数据<------");

	}

}
