package com.neon.util;

public class ChangeLength {
	public static double[] changeLength(double[] before){
		int number_zero = 0;
		for(int i=before.length-1;i>=0;i--){
			if(before[i] == 0){
				number_zero++;
			}else{
				break;
			}
		}
		double[] after = new double[before.length-number_zero];
		System.arraycopy(before, 0, after, 0, before.length-number_zero);
		return after;
	}
	
	public static double[] deleteTheLast(double[] d){
		d[d.length-1] = 0.0;
		return d;
	}
	
	public static void main(String[] args) {
		double[] a = {1,2,3,4,0,5,6,0,0,0,0};
		double[] c = ChangeLength.changeLength(a);
		for(double d:c){
			System.out.println(d);
		}
	}
	
}
