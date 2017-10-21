package com.chenlong.java_zixue_4;

public class Dog {
	private int health;
	private String name;

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if(health<0){
			this.health=100;
			return;
		}
		this.health = health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
