package com.chenlong.java_zixue_4;

public class Son extends Parent{
	public Son(){
		super(100);//���ø������Ӧ���췽��
		System.out.println("Son�Ĺ��췽��");
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