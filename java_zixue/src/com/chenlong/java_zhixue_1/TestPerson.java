package com.chenlong.java_zhixue_1;

public class TestPerson{
	public static void main(String[] args){
		Person s=new Person();
		s.study();
		s.showAge();
		s.addAge(3);
		s.showAge();
	}
}
 class Person {
	//属性
	String name;
	int age;
	int sex;
	//方法
	public void study(){
		System.out.println("Studying");
	}
	public void showAge(){
		System.out.println(age);
	}
	//给调用此方法的对象的age属性增加一岁，并返回新的age；
	public int addAge(int i){
		age+=i;
		return age;
	}
}
