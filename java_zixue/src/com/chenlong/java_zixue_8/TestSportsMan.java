package com.chenlong.java_zixue_8;

public class TestSportsMan {
	public static void main(String[] args) {
		SportsMan s1=new SportsMan("½ğÁú",23);
		SportsMan s2=new SportsMan("ÒøÁú",21);
		s1.name = "ÁúÍõ";
		s1.nation ="china";
		System.out.println(s1);
		System.out.println(s2);
	}
}
class SportsMan{
	String name;
	int age;
	static String nation;
	
	public SportsMan(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "SportsMan [name=" + name + ", age=" + age + ", nation=" + nation + "]";
	}
}
