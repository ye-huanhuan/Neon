package com.neon.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Constant {
	
	//常量

	public static int MONTH = 12;

	static Calendar cal = Calendar.getInstance();
	/**
	 * 当前月份
	 */
	public static int CURRENTMONTH = cal.get(Calendar.MONTH) + 1;
	
	/**
	 * 当前季度
	 */
	public static int CURRENTQUARTER = getCurrentQuarter(CURRENTMONTH);;
	
	static Date date = new Date();
	/**
	 * 当前年份
	 */
	public static int YEAR = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));

	
	public static int scale = 2;


	private static int getCurrentQuarter(int month) {
		int quarter = 0;
		if(month == 1||month == 2||month==3){
			quarter = 1;
		}else if(month == 4||month == 5||month == 6){
			quarter = 2;
		}else if(month == 7 ||month == 8 || month ==9){
			quarter = 3;
		}else{
			quarter = 4;
		}
		return quarter;
	}
}
