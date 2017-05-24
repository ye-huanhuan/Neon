package com.neon.test;



import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neon.domain.Privilege;
import com.neon.service.PrivilegeService;
import com.neon.service.UserService;
import com.neon.util.Arith;
import com.neon.util.Constant;
import com.neon.util.Sort;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml")  
public class TestHiber extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private UserService userService;
	
	
	@Resource
	private PrivilegeService privilegeService;
	

	@Test
	public void testH(){
		/*User user = new User();
		user.setUsername("yh");
		user.setPassword(Md5.getMD5("yh"));
		user.setEmail("hiw2012@163.com");
		userService.save(user);*/
		
		/*List<Double> moneys = outputService.getOutputTotleMoneyWithMonth(2017);
		System.out.println("该年每个月出项总金额：");
		for(Double money : moneys){
			System.out.println(money);
		}
		
		List<Double> moneys2 = outputService.getOutputTotleMoneyWithQuarter(2017);
		System.out.println("该年每个季度出项总金额：");
		for(Double money : moneys2){
			System.out.println(money);
		}
		
		Map<Integer, Double> moneys3 = outputService.getOutputTotleMoneyWithYear();
		System.out.println("每年出项总金额：");
		for(Map.Entry<Integer, Double> map : moneys3.entrySet()){
			System.out.println(map.getKey()+"年  总金额："+map.getValue());
		}*/
		
		/*Dvalue dvalue = new Dvalue();
		dvalue.setDdvalue(7.1);
		Date date = new Date();
		dvalue.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date).toString());
		dvalueService.save(dvalue);*/
		

		/*User user2 = new User();
		user2.setUsername("yhh");
		user2.setPassword(Md5.getMD5("yhh"));
		user2.setEmail("13244237736@163.com");
		userService.save(user2);*/
		
		
		/*Privilege pri = new Privilege();
		pri.setActionName("#");
		pri.setLimiteName("首页");
		pri.setParent(null);
		
		privilegeService.save(pri);*/
		
	}
	
}
