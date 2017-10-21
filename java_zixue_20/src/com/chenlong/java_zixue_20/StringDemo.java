package com.chenlong.java_zixue_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 去除字符串两端的空格，模拟trim方法
 */

public class StringDemo {
	public static void main(String[] args) {
		String str = " db  asd ";
		String str1 = myTrim(str);
		System.out.println(str1);
		
		String str2 = "abcdefjh";
		String str3 = reverseString1(str2, 1, 5);
		System.out.println(str3);// afedcbjh
		
		String str4 = "abcdefabfdasabkjab";
		int i = getTime(str4, "ab");
		System.out.println(i);
		
		List<String> str5=getMaxSubString("adshelloafas","sgdhellodf");
		System.out.println(str5);
		
		String str6="fsadfshjdbehw";
		String str7=sort(str6);
		System.out.println(str7);
	}
	//对字符串中字符进行自然顺序排序；
	public static String sort(String str){
		char[] c=str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	// 获取两个字符串中最大相同子串
	public static List<String> getMaxSubString(String str1, String str2) {
		String maxStr = (str1.length() > str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int len=minStr.length();
		List<String> list=new ArrayList<>();
		for(int i=0;i<len;i++){
			for(int x=0,y=len-i;y<=len;x++,y++){
				String str=minStr.substring(x, y);
				if(maxStr.contains(str)){
					list.add(str);
				}
			}
			if(list.size()!=0){
				return list;
			}
		}
		return null;
	}

	// 子字符串在母字符串中出现的次数,ab,abcdefabfdasabkjab
	public static int getTime(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len + str2.length());
		}
		return count;
	}

	// 去除字符串两端的空格，模拟trim方法
	public static String myTrim(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end && str.charAt(start) == ' ') {
			start++;
		}
		while (start < end && str.charAt(end) == ' ') {
			end--;
		}
		return str.substring(start, end + 1);
	}

	// 将字符串指定部分进行反转
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start);
		for (int i = end; i >= start; i--) {
			char c = str.charAt(i);
			str1 += c;
		}
		str1 += str.substring(end + 1);
		return str1;
	}

	public static String reverseString(String str, int start, int end) {
		char[] c = str.toCharArray();
		return reverseArray(c, start, end);
	}

	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		// 字符数组--->字符串
		return new String(c);
	}
}
