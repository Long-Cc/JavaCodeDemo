package com.chenlong.java_zixue_3;

public class User {
	int age;
	String name;
	public User(int a){
		System.out.println("User���췽��");
	}
	public User(){
		
	}

	public static void main(String[] args) {
		User user=new User(); 
		user.age=20;
		user.name="Tom";
	}

}
