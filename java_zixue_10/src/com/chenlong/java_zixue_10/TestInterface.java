package com.chenlong.java_zixue_10;

/*
 * �ӿڣ�interface�������ಢ�е�һ������
 * 1)�ӿڿ��Կ�����һ������ĳ����࣬�ǳ�������������ĵ�һ������,���ܹ�����������һ��ķ���
 * 2)�ӿ���û�й�������
 * 3)�ӿڶ������һ�ֹ��ܣ��˹��ܿɱ�����ʵ�֣�implements������ 
 * class Test_2 extends Test_3 implements Test_1
 * 4)ʵ�ֽӿڵ��࣬����Ҫ��д���еĳ�������������ʵ��������û����д���еĳ���������������Ϊһ��������
 * 5)�����ʵ�ֶ���ӿ�---java �е���ļ̳��ǵ��̳�
 * 6)�ӿ���ӿ�֮��Ĺ�ϵ�Ǽ̳У����ҿ���ʵ�ֶ�̳�
 * >>5��6��������java�еļ̳е��ص㣬
 */
public class TestInterface {
	public static void main(String[] args) {
		System.out.println(Test_1.FLAG);
	}
}

class Test_3 {

}

interface Test_1 {
	// ���� ���г�������public static final ���� ��ʡ��
	public static final int I = 12;
	boolean FLAG = false;

	// �������� ���г�����������public abstract���� ��ʡ��
	public abstract void method1();

	void method2();
}

interface Test_4 {
	void method3();
}

class Test_2 extends Test_3 implements Test_1, Test_4 {
	public void method1() {

	}

	public void method2() {

	}

	public void method3() {

	}

}
//�ӿ���ӿ�֮��Ĺ�ϵ�Ǽ̳�,�����Ƕ�̳�
interface Test_5 extends Test_4,Test_1 {
	void method4();
}
class Test_6 implements Test_5{
	public void method3(){
		
	}
	public void method4(){
		
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
}
