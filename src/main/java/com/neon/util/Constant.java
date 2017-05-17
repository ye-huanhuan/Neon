package com.neon.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Constant {
	
	//常量

	public static int MONTH = 12;
	
	static Date date = new Date();
	public static int YEAR = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
	
	public static int scale = 2;
}
