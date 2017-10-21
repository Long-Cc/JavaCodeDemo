package com.chenlong.java_zixue_20;

public class TestString2 {

	public static void main(String[] args) {
		String str="abcdefgh";
		System.out.println(reverse1(str));
		System.out.println(reverse2(str));
		System.out.println(reverse3(str));
	}

	// 实现字符串的反转
	// 方法一、
	public static String reverse1(String str) {
		char[] c = str.toCharArray();
		for (int x = 0, y = c.length - 1; x < y; x++, y--) {
			char temp = c[x];
			c[x] = c[y];
			c[y] = temp;
		}
		return new String(c);
	}

	// 方法二、
	public static String reverse2(String str) {
		StringBuffer sb=new StringBuffer(str);
		StringBuffer sb1=sb.reverse();
		return sb1.toString();
	}
	//方法三
	public static String reverse3(String str) {
		StringBuffer sb=new StringBuffer();
		for(int i=str.length()-1;i>=0;i--){
			sb.append(str.charAt(i));//String.charAt() 方法返回指定索引处的char值，append()方法追加子串的功能
		}
		return sb.toString();
	}
}
