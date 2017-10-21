package com.chenlong.java_zixue_20;

import org.junit.Test;

public class TestString {
	/*
	 *1、字符串与基本数据类型、包装类的转换
	 *	字符串-->基本数据类型、包装类:调用相应的包装类的parseXxx(String str)
	 *	基本数据类型、包装类-->字符串:调用字符串重载的valueOf()方法
	 *
	 *2、 字符串与字节数组间的转换
	 *	字符串-->字节数组：调用getBytes()
	 *	字节数组-->字符串:调用字符串的构造器
	 *
	 *3、 字符串与字符数组间的转换
	 *	字符串-->字符数组：调用字符串toCharArray
	 *	字符数组-->字符串：调用字符串的构造器 
	 */
	@Test
	public void test1(){
		String str="1553";
		int i=Integer.parseInt(str);
		System.out.println(i);
		String str1=i+"";
		str1=String.valueOf(i);
		System.out.println(str1);
		
		String str2="12sadagf";
		byte[] b=str2.getBytes();
		for (int j = 0; j < b.length; j++) {
			System.out.print((char)b[j]);
		}
		System.out.println();
		String str3=new String(b);
		System.out.println(str3);
		String str4="asd45只";
		char[] c=str4.toCharArray();
		for (int j = 0; j < c.length; j++) {
			System.out.print(c[j]);
		}
		String str5=new String(c);
		System.out.println(str5);
	}
}
