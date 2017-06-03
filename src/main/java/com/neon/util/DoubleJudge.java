package com.neon.util;

/**
 
 * @author hao
 *
 */
public class DoubleJudge {

	/**
	 * 判断是否为double类型
	 * 是 返回double
	 * 不是 返回0.0
	 * @param d
	 * @return
	 */
	public static double isDouble(Double d){
		if(d == null){
			return 0.0;
		}
		return d;
	}
	
}
