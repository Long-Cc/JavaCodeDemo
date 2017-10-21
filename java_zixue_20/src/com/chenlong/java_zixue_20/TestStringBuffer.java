package com.chenlong.java_zixue_20;

import org.junit.Test;

public class TestStringBuffer {
	/*
	 * StringBulider:JDK5.0,线程不安全，效率比StringBuff高(可变字符序列)
	 * 对比String StringBuffer StringBuilder三者添加效率
	 * 效率从高到低StringBulider StringBuffer String
	 */
	
	@Test
	public void test1(){
		StringBuffer sb=new StringBuffer();
		//添加：append() 删 delete(int i,int j) 修改setCharAt(int index,char ch) 查charAt(int index);
		sb.append("456").append("asdd").append(true);
		System.out.println(sb);
		//插入：insert(int index,String str)
		sb.insert(5, "hello");
		System.out.println(sb);
		//反转：reverse(),自己改变
		sb.reverse();
		System.out.println(sb);
		//长度 ：length()
		int j=sb.length();
		System.out.println(j);
		sb.charAt(5);
	}
	
}
