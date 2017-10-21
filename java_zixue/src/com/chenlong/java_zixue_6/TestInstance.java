package com.chenlong.java_zixue_6;

//∂‡Ã¨¡∑œ∞
public class TestInstance {
	public static void main(String[] args) {
		TestInstance t=new TestInstance();
		t.method1(new Student());
		
		System.out.println();
		
		t.method1(new Graduate());
	}
	
	public void method1(Person e){
		System.out.println(e.getInfo());
		if(e instanceof Graduate){
			System.out.println("a Graduate");
		}
		if(e instanceof Student){
			System.out.println("a Student");
		}
		if(e instanceof Person){
			System.out.println("a Person");
		}
	}
}

class Person {
	protected String name = "person";
	protected int age = 50;

	public String getInfo() {
		return "Name: " + name + "\n" + "age: " + age;
	}
}

class Student extends Person {
	protected String school = "pku";

	public String getInfo() {
		return "Name: " + name + "\nage: " + age + "\nschool: " + school;
	}
}

class Graduate extends Student {
	public String major = "IT";

	public String getInfo() {
		return "Name: " + name + "\nage: " + age + "\nschool: " + school + "\nmajor:" + major;
	}
}
