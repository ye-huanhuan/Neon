package com.neon.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neon.service.InputService;
import com.neon.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml")  
public class TestHiber extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private UserService userService;
	
	@Resource
	private InputService inputService;
	@Test
	public void testH(){
		/*User user = new User();
		user.setUsername("yh");
		user.setPassword(Md5.getMD5("yh"));
		user.setEmail("hiw2012@163.com");
		userService.save(user);
		
		User user2 = new User();
		user2.setUsername("yhh");
		user2.setPassword(Md5.getMD5("yhh"));
		user2.setEmail("13244237736@163.com");
		userService.save(user);*/
		List<Double> money1=inputService.getInputTotleMoneyWithMonth(2017);
		for(Double money:money1){
			System.out.println(money);
		}
		System.out.println("-------------------------------------");
		List<Double> money2 = inputService.getInputTotleMoneyWithQuarter(2017);
				for(Double money :money2){
					System.out.println(money);
				}
				
		Map<Integer,Double> money3=inputService.getInputTotleMoneyWithYear();
			for(Map.Entry<Integer, Double> entry :money3.entrySet() ){
				System.out.println("Key="+entry.getKey()+",Value="+entry.getValue());
			}
		
	}
}
