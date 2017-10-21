package com.chenlong.java_zixue_13;

public class ReturnExceptionDemo {
	static void methodA(){
		try{
			System.out.println("进入到方法A");
			throw new RuntimeException("制造异常");
		}finally{
			System.out.println("用A方法的Finally");
		}
	}
	static void methodB(){
		try{
			System.out.println("进入方法B");
			return;
		}finally{
			System.out.println("用B方法的Finally");
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
