package com.chenlong.java_zixue_10;
/*
 * final:���յģ��������������ࡢ���ԡ�����
 * 
 *1. final�����࣬����಻�ܱ��̳У���String�ࡢStringBuffer�ࡢSystem��
 *2. final���η��������ܱ���д    ��Object����getClass
 *3. final�������ԣ������Ծ��Ǹ�������һ����ʼ�������ٱ���ֵ��ϰ���ǣ������ô�д��ĸ��д
 *    �˳������ĸ�ֵ���˳�������Ĭ�ϵĳ�ʼ����������ʽ��ֵ������顢������
 *  ������static��final���Σ�ȫ�ֱ���
 * 
 */
public class TestFinal {

}

//class B extends A{
//	
//}
final class A{
	final int I=12;
	final double PI;
	final String NAME;
	
	public void m1(){
		System.out.println(PI);
	}
	{
		PI=3.14;
	}
	public A(){
		NAME="CD";
	}
	public A(String name){
		NAME=name;
	}
}