package com.chenlong.java_zixue_3;

public class WrapDemo {

	public static void main(String[] args) {
		Integer i1=new Integer(100);
		int num1=i1.intValue();
		Double d1=new Double("12.4");
		double num2=d1.doubleValue();
		
		int num3=Integer.parseInt("123");
		Double num4=Double.parseDouble("12.345");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Character.isDigit('a'));
	}

}
