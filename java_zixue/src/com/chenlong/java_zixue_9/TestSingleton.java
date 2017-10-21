package com.chenlong.java_zixue_9;

public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		System.out.println(s1==s2);
	}
}
//单例模式，使得一个类只能创建一个对象；
//实现1234步；
//只能够创建Singleton的单个实例
//饿汉式
class Singleton{
	//1.私有化构造器，使得在类的外部不能调用此构造器
	private Singleton(){	
	}
	//2.在类的内部创建一个类的实例
	private static Singleton instance=new Singleton();
	//3.私有化此对象，通过公共的方法来调用
	//4.此公共的方法只能通过类来调用，因此设置为静态方法static,同时类的实例也必须是static声明
	public static Singleton getInstance(){
		return instance;
	}
}
