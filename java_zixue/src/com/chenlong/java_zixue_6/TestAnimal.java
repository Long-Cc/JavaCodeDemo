package com.chenlong.java_zixue_6;

public class TestAnimal {

	public static void main(String[] args) {
		TestAnimal t = new TestAnimal();
		t.func(new Animal());
		t.func(new Dog());

		t.func(new Cat());
	}

	public void func(Animal a) {
		if (a instanceof Dog) {
			Dog d = (Dog) a;
			d.wang();
		}
		if (a instanceof Cat) {
			Cat c = (Cat) a;
			c.catchMouse();
		}
		a.eat();
		a.jump();
	}

}

class Animal {
	String name;
	int age;

	public void eat() {
		System.out.println("��ʳ");
	}

	public void jump() {
		System.out.println("��");
	}
}

class Dog extends Animal {
	public void eat() {
		System.out.println("����ʳ");
	}

	public void jump() {
		System.out.println("������ǽ");
	}

	public void wang() {
		System.out.println("������");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("è����");
	}

	public void jump() {
		System.out.println("è��");
	}

	public void catchMouse() {
		System.out.println("èץ����");
	}
}
