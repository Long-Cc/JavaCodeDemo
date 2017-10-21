package com.chenlong.java_zixue_12;

public class TestInnerClass1 {

}
interface Comparable{
	int compareTO();
}
class OuterClass{
	//局部内部类  使用方式较少
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
