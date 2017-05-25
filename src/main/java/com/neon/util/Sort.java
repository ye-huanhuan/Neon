package com.neon.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sort {

	/**
	 * 返回的map中有三个元素
	 * @param maps
	 * @return
	 */
	public static Map<String, Double> SortMapByDESC3(Map<String , Double> maps){
	        List<Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(maps.entrySet());
	        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
	            //升序排序
	            public int compare(Entry<String, Double> o1,
	                    Entry<String, Double> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	            
	        });
	        
	        //将list转换成map
	        Map<String, Double> sortedMap = new LinkedHashMap<>();
	        int j = 0;
	        for (Iterator it = list.iterator(); it.hasNext();) {
	        	if(j == 3){
	        		return sortedMap;
	        	}
	            Map.Entry<String, Double> entry = (Map.Entry) it.next();
	            sortedMap.put(entry.getKey(), entry.getValue());
	            j++;
	        }
	        
	        /*for(Map.Entry<String,Double> mapping:list){ 
	               System.out.println(mapping.getKey()+":"+mapping.getValue());
	               map.put(mapping.getKey(), mapping.getValue());
	          }*/ 
		return sortedMap;
	}
}
