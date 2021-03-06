package com.neon.test;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neon.domain.Privilege;
import com.neon.domain.User;
import com.neon.service.PrivilegeService;
import com.neon.service.UserService;
import com.neon.util.Arith;
import com.neon.util.Constant;
import com.neon.util.ListToArray;
import com.neon.util.Md5;
import com.neon.util.Sort;
import com.zyujie.dm.LinearRegression;

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
		

//		User user2 = new User();
//		user2.setUsername("admin");
//		user2.setPassword(Md5.getMD5("admin"));
//		user2.setEmail("neon@163.com");
//		userService.save(user2);
//		
//		User user3 = new User();
//		user3.setUsername("user");
//		user3.setPassword(Md5.getMD5("user"));
//		user3.setEmail("neon_test@163.com");
//		userService.save(user3);
		
		
		/*Privilege pri = new Privilege();
		pri.setActionName("#");
		pri.setLimiteName("首页");
		pri.setParent(null);
		
		privilegeService.save(pri);*/
		
		/*Map<String, Double> map = new HashMap<>();
		map.put("yy", 2.1);
		map.put("yh", 2.1);
		map.put("hh", 2.1);
		Map<String, Double> map2 = new HashMap<>();
		map2.put("yy", 2.1);
		map2.put("yh", 2.1);
		map2.put("hh", 2.1);
		for(String s : ListToArray.getItemsArray(map, map2)){
			System.out.println(s);
		}*/
		
		/*double[][] d = new double[1][];
		d[0] = new double[2];
		d[0][0] = 1;
		d[0][1] = 2;
		double[][] d_2 = new double[1][];
		d_2[0] = new double[2];
		d_2[0][0] = 2;
		d_2[0][1] = 3;
		
		List<double[][]> list = new ArrayList<>();
		list.add(d);
		list.add(d_2);
		
		
		System.out.println(LinearRegression.predict(list, 3));
 		System.out.println("3");*/
		
		/*List<Double> l = new ArrayList<>();
		l.add(1.0);
		l.add(2.0);
		l.add(0.5);
		System.out.println(Arith.max(l) + " " + Arith.min(l));*/
		
		
			/*String[] strs = {"a","b","c"};
			Integer[] a = {3,1,2};
			int temp = 0;
			String str = "";
			for(int i=0;i<a.length-1;i++){  
		        for(int j=0;j<a.length-1-i;j++){  
		        if(a[j]>a[j+1]){  
		            temp=a[j];  
		            a[j]=a[j+1];  
		            a[j+1]=temp;
		            
		            str = strs[j];
		            strs[j] = strs[j+1];
		            strs[j+1] = str;
		        }  
		        }  
		    }  
			
			for(String s : strs){
				System.out.println(s);
			}
			*/
		
			
		
		}
}
