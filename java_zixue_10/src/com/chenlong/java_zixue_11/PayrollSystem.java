package com.chenlong.java_zixue_11;

import java.util.Scanner;

public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emps=new Employee[2];
		emps[0]=new SalariedEmployee("李雷", 1001, new MyDate(1998,12,1), 8800);
		emps[1]=new HourlyEmployee("韩梅梅", 1002, new MyDate(1987,4,30), 100,6);
		Scanner s=new Scanner(System.in);
		System.out.println("输入本月的月份：");
		int month=s.nextInt();
		
		for (int i = 0; i < emps.length; i++) {
			if(month==emps[i].getBirthday().getMonth()){
				System.out.println("加工资，加100！");
			}
			System.out.println(emps[i]);
		}
		s.close();
	}
}
