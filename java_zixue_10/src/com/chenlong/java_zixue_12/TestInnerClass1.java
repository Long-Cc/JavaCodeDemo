package com.chenlong.java_zixue_12;

public class TestInnerClass1 {

}
interface Comparable{
	int compareTO();
}
class OuterClass{
	//�ֲ��ڲ���  ʹ�÷�ʽ����
	public void method1(){
		
	}
	public Comparable getComparable(){
		class MyComparable implements Comparable{

			@Override
			public int compareTO() {
				return 0;
			}
		}
		return new MyComparable();

	}
}
