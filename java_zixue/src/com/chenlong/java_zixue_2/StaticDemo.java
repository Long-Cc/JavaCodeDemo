package com.chenlong.java_zixue_2;

public class StaticDemo {
	
	int num;
	static int num2;
	void m(){
//		Ststic int num3=10;
	}
	

	public static void main(String[] args) {
		StaticDemo demo1=new StaticDemo();
		demo1.num=10;
		StaticDemo.num2=10;
		StaticDemo demo2=new StaticDemo();
		demo2.num=20;
		StaticDemo.num2=20;
		System.out.println(demo1.num+","+demo2.num);
		System.out.println(StaticDemo.num2+","+StaticDemo.num2);
	}

}
