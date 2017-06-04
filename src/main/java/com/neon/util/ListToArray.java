package com.neon.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	 * 将list转换为String类型的一维数组
	 * @param list
	 * @return
	 */
	public static String[] getStringArray(Set<String> set){
		String[] array = new String[set.size()];
		Iterator<String> itr = set.iterator();
		int i = 0;
	    while(itr.hasNext()){  
	        array[i] = itr.next();  
	        i++;
	    }  
     
		return array;
	}
	
	public static String[] getStringArray_2(List<String> list){
		String[] array = new String[list.size()];
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
	
	/**
	 * 得到商品的名字
	 * @param map
	 * @return
	 */
	public static String[] getItemsArray(Map<String, Double> map , Map<String, Double> map2){
		String[] items_1 = new String[map.size()];
		String[] items_2 = new String[map2.size()];
		int temp = 0;
		for(Map.Entry<String, Double> m : map.entrySet()){
			items_1[temp] = m.getKey();
			temp++;
		}
		temp = 0;
		for(Map.Entry<String, Double> m : map2.entrySet()){
			items_2[temp] = m.getKey();
			temp++;
		}
		/*Set<String> set = new HashSet<>();
		
		for(String s : items_1){
			System.out.println(s);
		}
		
		System.out.println("=========");
		
		for(String s : items_2){
			System.out.println(s);
		}*/
		
		/*int size = (items_1.length <= items_2.length) ? items_1.length : items_2.length;
		
		System.out.println(size);
		
		for(int index = 0 ; index < size ; index++){
			if(items_1[index].equals(items_2[index])){
				set.add(items_1[index]);
				index++;
			}else{
				set.add(items_1[index]);
				set.add(items_2[index]);
			}
		}
		if(items_1.length > size){
			for( ; size < items_1.length ; size++){
				set.add(items_1[size]);
			}
		}else{
			for( ; size < items_2.length ; size++){
				System.out.println(items_2[size] + "--");
				set.add(items_2[size]);
			}
		}*/
		
		return items_1;
	}
	
	/**
	 * 得到商品的销售额
	 * @param map
	 * @return
	 */
	public static double[] getDoubleArray(Map<String, Double> map){
		double[] items = new double[map.size()];
		int temp = 0;
		for(Map.Entry<String, Double> m : map.entrySet()){
			items[temp] = m.getValue();
		}
		return items;
	}
}
