package com.neon.util;

import java.util.List;
import java.util.Map;

public class ListToArray {

	/**
	 * 将list转换为double类型的一维数组
	 * @param list
	 * @return
	 */
	public static double[] getDoubleArray(List<Double> list){
		double[] array = new double[list.size()];  
        for(int i = 0 ; i < list.size() ; i++){  
            array[i] = list.get(i);  
        }  
		return array;
	}
	
	/**
	 * 将list转换为double类型的一维数组(倒序)
	 * @param list
	 * @return
	 */
	public static double[] getDoubleArray2(List<Double> list){
		double[] array = new double[list.size()];
		int j = list.size()-1;
	       for(int i = 0 ; i < list.size() ; i++ , j--){  
	           array[j] = list.get(i);
	       }  
		return array;
	}
	
	/**
	 * 将list转换为Long类型的一维数组
	 * @param list
	 * @return
	 */
	public static Long[] getLongArray(List<Long> list){
		Long[] array = new Long[list.size()];  
        for(int i = 0 ; i < list.size() ; i++){  
            array[i] = list.get(i);  
        }  
		return array;
	}
	
	/**
	 * 将map转换为String类型的二位数组
	 */
	public static String[][] getString2Array(Map<String, Double> map){
		String s2a[][] = new String[map.size()][2];
		int temp = 0;
		for(Map.Entry<String, Double> m :map.entrySet()){
			for(int i = 0 ; i < 2 ; i++ ){
				if(i == 0){
					s2a[temp][i] = m.getKey().toString();
				}else{
					s2a[temp][i] = m.getValue().toString();
				}
			}
			temp++;
		}
		return s2a;
	}
}
