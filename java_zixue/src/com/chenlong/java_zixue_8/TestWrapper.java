package com.chenlong.java_zixue_8;

import org.junit.Test;

public class TestWrapper {
	@Test
	public void test(){
		int i=10;
		System.out.println(i);
		Integer i1=new Integer(i);
		System.out.println(i1.toString());
		Boolean b1=new Boolean("true");
		System.out.println(b1);
		//������������<---->��װ��
		int k1=2;
		Integer k2=k1;//�Զ�װ��
		Integer k3=new Integer(56);
		int k4=k3;//�Զ�����
	}
	@Test
	public void test2(){
		//�����������͡���װ��----->String��  ����String������ص�valueOf()����
		int i1=12;
		String str=i1+"";
		Integer i2=i1;
		Boolean i3=new Boolean(true);
		String str3=String.valueOf(i3);
		String str1=String.valueOf(i1);
		String str2=String.valueOf(i2);
		System.out.println(str+" "+str1);
		System.out.println(str2+" "+str3);//"12"+"false"
		
		//String��---->�����������͡���װ��  ���ð�װ������ص�parseXxx(String str)����
		int i4=Integer.parseInt(str1);
		boolean i5=Boolean.parseBoolean(str3);
		System.out.println(i4);
		System.out.println(i5);
	}
}
