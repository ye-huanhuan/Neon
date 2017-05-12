package com.neon.util;

import java.math.BigDecimal;

public class Arith {

	/** 
     * 提供精确的加法运算 
     * @param v1 被加数 
     * @param v2 加数 
     * @return 两个参数的和 
     */  
    public static double add(double v1, double v2)  
    {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.add(b2).doubleValue();  
    }  
  
    /** 
     * 提供精确的减法运算 
     * @param v1 被减数 
     * @param v2 减数 
     * @return 两个参数的差 
     */  
    public static double sub(double v1, double v2)  
    {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.subtract(b2).doubleValue();  
    } 
    
    /**  
    * * 两个Double数相除，并保留scale位小数 *  
    *   
    * @param v1 *  
    * @param v2 *  
    * @param scale *  
    * @return Double  
    */    
    public static Double div(Double v1, Double v2, int scale) {    
       if (scale < 0) {    
        throw new IllegalArgumentException(    
          "The scale must be a positive integer or zero");    
       }    
       BigDecimal b1 = new BigDecimal(v1.toString());    
       BigDecimal b2 = new BigDecimal(v2.toString());    
       return new Double(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue());    
    }    
}