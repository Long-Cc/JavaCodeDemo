package com.chenlong.java_zixue_4;

public class Son extends Parent{
	public Son(){
		super(100);//调用父类的相应构造方法
		System.out.println("Son的构造方法");
	}
	@Override
	public void m1(){
		System.out.println("Son's m1");
	}
	public void m2(){
		m1();
	}
	public static void main(String[] args) {
		Son son=new Son();
		son.m2();
	}
}