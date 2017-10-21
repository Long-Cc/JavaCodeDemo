package com.chenlong.java_zixue_20;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDate {
	/*
	 * 两天打渔三天晒网 1990-01-01 XXX-XX-XX 打渔？ 晒网？
	 */
	// 返回date1与date2之间的天数 date1早于date2
	public int getDays(String date1, String date2) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long miliTime = d2.getTime() - d1.getTime();
		return (int) miliTime / 1000 / 360 / 24 + 1;
	}

	@Test
	public void test3() throws Exception {
		String str1 = "1990-01-01";
		String str2 = "1990-01-06";
		int dates = getDays(str1, str2);
		if (dates % 5 == 0 || dates % 5 == 4) {
			System.out.println("晒网");
		} else {
			System.out.println("打渔");
		}
	}

	@Test
	public void test2() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(new Date()));// 16-7-29 下午2:10

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf1.format(new Date());
		System.out.println(date);// 2016-07-29 02:17:23
		// 解析
		Date date1 = sdf.parse("16-7-29 下午2:10");
		System.out.println(date1);

		date1 = sdf1.parse("2016-07-29 02:17:23");
		System.out.println(date1);

	}

	@Test
	public void test1() {
		Date d1 = new Date();
		System.out.println(d1.toString());// Fri Jul 29 13:25:24 CST 2016
		System.out.println(d1.getTime());// 1469770140314
		Date d3 = new Date(1469770140314L);
		System.out.println(d3.toString());

		// java.sql.Date d2=new java.sql.Date(12346466L);
		// System.out.println(d2.toString());//1970-01-01
	}
}
