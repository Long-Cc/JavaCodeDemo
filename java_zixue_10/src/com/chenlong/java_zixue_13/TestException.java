package com.chenlong.java_zixue_13;

import java.util.Scanner;

import org.junit.Test;

/*
 *  try{
 * 	//可能出现异常的代码
 *  }catch(Exception1 e1){
 *  //处理的方式1
 *  }catch(Exception2 e2){
 *  //处理的方式2
 *  }finally{
 * 	//一定要执行的
 *  }
 */
public class TestException {
	@Test
	public void method1(){
		Scanner s=new Scanner(System.in);
		try{
		int m1=s.nextInt();
		System.out.println(m1);
		}catch(Exception e){
			System.out.println("输入类型异常");
		}
		s.close();
	}
}
