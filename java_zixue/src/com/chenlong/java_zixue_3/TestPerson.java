package com.chenlong.java_zixue_3;

public class TestPerson {

	public static void main(String[] args) {
		Person p = new Person("王二");
		p.setAge(120);
		System.out.println(p.getName() + "::" + p.getAge());

	}

}

class Person {
	private int age;
	private String name;

	public Person(String str) {
		age = 18;
		name = str;
	}

	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0 && age < 130) {
			this.age = age;

		} else {
			throw new RuntimeException("您输入有误！");
		}
	}

}
