package com.chenlong.java_zixue_9;

public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		System.out.println(s1==s2);
	}
}
//����ģʽ��ʹ��һ����ֻ�ܴ���һ������
//ʵ��1234����
//ֻ�ܹ�����Singleton�ĵ���ʵ��
//����ʽ
class Singleton{
	//1.˽�л���������ʹ��������ⲿ���ܵ��ô˹�����
	private Singleton(){	
	}
	//2.������ڲ�����һ�����ʵ��
	private static Singleton instance=new Singleton();
	//3.˽�л��˶���ͨ�������ķ���������
	//4.�˹����ķ���ֻ��ͨ���������ã��������Ϊ��̬����static,ͬʱ���ʵ��Ҳ������static����
	public static Singleton getInstance(){
		return instance;
	}
}
