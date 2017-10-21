package com.chenlong.java_zixue_13;

public class ReturnExceptionDemo {
	static void methodA(){
		try{
			System.out.println("���뵽����A");
			throw new RuntimeException("�����쳣");
		}finally{
			System.out.println("��A������Finally");
		}
	}
	static void methodB(){
		try{
			System.out.println("���뷽��B");
			return;
		}finally{
			System.out.println("��B������Finally");
		}
	}
	public static void main(String[] args){
		try{
			methodA();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		methodB();
	}
}
