package com.chenlong.java_zixue_13;

import java.util.Scanner;

import org.junit.Test;

/*
 *  try{
 * 	//���ܳ����쳣�Ĵ���
 *  }catch(Exception1 e1){
 *  //����ķ�ʽ1
 *  }catch(Exception2 e2){
 *  //����ķ�ʽ2
 *  }finally{
 * 	//һ��Ҫִ�е�
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
			System.out.println("���������쳣");
		}
		s.close();
	}
}
