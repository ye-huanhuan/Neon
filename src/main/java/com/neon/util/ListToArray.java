package com.neon.util;

import java.util.List;

public class ListToArray {

	public static double[] getDoubleArray(List<Double> list){
		double[] array = new double[list.size()];  
        for(int i = 0 ; i < list.size() ; i++){  
            array[i]= list.get(i);  
        }  
		return array;
	}
}
