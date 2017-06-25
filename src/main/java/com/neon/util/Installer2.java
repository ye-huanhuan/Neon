package com.neon.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neon.domain.Inout;
import com.neon.domain.Privilege;
import com.neon.domain.Role;
import com.neon.domain.User;
import com.neon.service.InoutService;
import com.neon.service.PrivilegeService;
import com.neon.service.RoleService;
import com.neon.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml") 
public class Installer2 extends AbstractJUnit4SpringContextTests{

	@Resource
	private PrivilegeService privilegeService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private UserService userService;
	
	@Resource InoutService inoutService;
	
	@Test
	public void test(){
		String[] privilegeItems_1 = {"首页","分析","报表","明细报表","同比报表","产品报表","月份分析","季度分析","年度分析","税收分析"};
		String[] privilegeItems_2 = {"首页","分析","报表","明细报表","同比报表","产品报表","月份分析","季度分析","年度分析","税收分析","设置","设置数据"};
		
		Long[] ids_1 = privilegeService.getIdsByItems(privilegeItems_1);
		Long[] ids_2 = privilegeService.getIdsByItems(privilegeItems_2);
		
		
		List<Privilege> privileges_1 =  privilegeService.getByIds(ids_1);
		List<Privilege> privileges_2 =  privilegeService.getByIds(ids_2);
		
		
		Role role_1 = new Role();
		role_1.setRoleName("accounting");
		role_1.setPrivileges(new HashSet<>(privileges_1));
		roleService.save(role_1);
		
		Role role_2 = new Role();
		role_2.setRoleName("management");
		role_2.setPrivileges(new HashSet<>(privileges_2));
		roleService.save(role_2);
		
		User user_1 = new User();
		user_1.setUsername("yh");
		user_1.setEmail("hiw2012@163.com");
		user_1.setPassword(Md5.getMD5("yh"));
		user_1.setRole(role_1);
		userService.save(user_1);
		
		User user_2 = new User();
		user_2.setUsername("yhh");
		user_2.setEmail("hiw2012@163.com");
		user_2.setPassword(Md5.getMD5("yhh"));
		user_2.setRole(role_2);
		userService.save(user_2);
		
		Inout inout_1 = new Inout();
		inout_1.setInput("猪肉");
		inout_1.setOutput("猪肉罐头");
		inoutService.save(inout_1);
		
		Inout inout_2 = new Inout();
		inout_2.setInput("鱼肉");
		inout_2.setOutput("鱼肉罐头");
		inoutService.save(inout_2);
		
		Inout inout_3 = new Inout();
		inout_3.setInput("鸡肉");
		inout_3.setOutput("鸡肉罐头");
		inoutService.save(inout_3);
		
		Inout inout_4 = new Inout();
		inout_4.setInput("牛肉");
		inout_4.setOutput("牛肉罐头");
		inoutService.save(inout_4);
		
	}
}
