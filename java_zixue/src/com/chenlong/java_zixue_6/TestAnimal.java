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
		System.out.println("½øÊ³");
	}

	public void jump() {
		System.out.println("Ìø");
	}
}

class Dog extends Animal {
	public void eat() {
		System.out.println("¹·½øÊ³");
	}

	public void jump() {
		System.out.println("¹·¼±ÌøÇ½");
	}

	public void wang() {
		System.out.println("ÍôÍô½Ğ");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("Ã¨³ÔÓã");
	}

	public void jump() {
		System.out.println("Ã¨Ìø");
	}

	public void catchMouse() {
		System.out.println("Ã¨×¥ÀÏÊó");
	}
}
