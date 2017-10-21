package com.chenlong.java_zixue_12;

public class TestInnerClass {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Person.Dog d = new Person.Dog();

		Person p = new Person();// ¾²Ì¬µÄ
		Person.Bird b = p.new Bird();// ·Ç¾²Ì¬µÄ

		b.info();
		b.setName("¶Å¾é");
	}

}

class Person {
	String name = "º«Ã·Ã·";
	int age;

	class Bird {
		String name = "Lily";
		int id;

		public Bird() {

		}

		public void setName(String name) {
			System.out.println(name);// ¶Å¾é
			System.out.println(this.name);// Lily
			System.out.println(Person.this.name);// º«Ã·Ã·
		}

		public void info() {
			show();
		}
	}

	static class Dog {

	}

	public void show() {
		System.out.println("ÎÒÊÇshow·½·¨");
	}

}
