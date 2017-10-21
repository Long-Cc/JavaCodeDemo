package com.chenlong.java_zixue_4;

public class TestDog {

	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.setHealth(-100);
		int health=dog.getHealth();
		System.out.println(health);
		dog.setName("Íú²Æ");
		String name=dog.getName();
		System.out.println(name);
	}

}
