package com.chenlong.java_zixue_12;

public class TestInnerClass {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Person.Dog d = new Person.Dog();

		Person p = new Person();// ��̬��
		Person.Bird b = p.new Bird();// �Ǿ�̬��

		b.info();
		b.setName("�ž�");
	}

}

class Person {
	String name = "��÷÷";
	int age;

	class Bird {
		String name = "Lily";
		int id;

		public Bird() {

		}

		public void setName(String name) {
			System.out.println(name);// �ž�
			System.out.println(this.name);// Lily
			System.out.println(Person.this.name);// ��÷÷
		}

		public void info() {
			show();
		}
	}

	static class Dog {

	}

	public void show() {
		System.out.println("����show����");
	}

}
