package com.neon.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neon.domain.User;
import com.neon.service.UserService;
import com.neon.util.Md5;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:applicationContext.xml")  
public class TestHiber extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private UserService userService;
	
	@Test
	public void testH(){
		User user = new User();
		user.setUsername("yh");
		user.setPassword(Md5.getMD5("yh"));
		user.setEmail("hiw2012@163.com");
		userService.save(user);
	}
}
