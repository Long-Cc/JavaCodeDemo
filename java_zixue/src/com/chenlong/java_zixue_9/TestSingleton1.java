package com.chenlong.java_zixue_9;
//懒汉式,可能存在线程安全问题；

//解决线程安全问题：使用同步机制  	关键字synchronize
//对于静态方法:使用当前类本身充当锁
public class TestSingleton1 {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1 == s2);
	}
}

class Singleton1 {
	private Singleton1() {

	}

	private static Singleton1 instance = null;

	public static Singleton1 getInstance() {

		if (instance == null) {
			synchronized (Singleton1.class) {// 使用当前类本身充当锁

				if (instance == null) {
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
}
