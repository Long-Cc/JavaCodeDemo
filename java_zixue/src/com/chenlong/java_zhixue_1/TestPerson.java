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
	//����
	String name;
	int age;
	int sex;
	//����
	public void study(){
		System.out.println("Studying");
	}
	public void showAge(){
		System.out.println(age);
	}
	//�����ô˷����Ķ����age��������һ�꣬�������µ�age��
	public int addAge(int i){
		age+=i;
		return age;
	}
}
