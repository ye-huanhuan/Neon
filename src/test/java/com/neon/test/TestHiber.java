package com.neon.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neon.domain.Dvalue;
import com.neon.domain.User;
import com.neon.service.DvalueService;
import com.neon.service.OutputService;
import com.neon.service.UserService;
import com.neon.util.Md5;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml")  
public class TestHiber extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private UserService userService;
	@Resource
	private OutputService outputService;
	@Resource
	private DvalueService dvalueService;
	
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
		
		System.out.println(dvalueService.getMaxIdInDvalues());
	}
}
