package com.chenlong.java_zixue_10;

/*
 * 接口（interface）：与类并行的一个概念
 * 1)接口可以看作是一个特殊的抽象类，是常量与抽样方法的的一个集合,不能够包括变量、一般的方法
 * 2)接口是没有构造器，
 * 3)接口定义就是一种功能，此功能可被类所实现（implements）比如 
 * class Test_2 extends Test_3 implements Test_1
 * 4)实现接口的类，必须要重写所有的抽样方法，方可实例化，若没有重写所有的抽样方法，此类仍为一个抽象类
 * 5)类可以实现多个接口---java 中的类的继承是单继承
 * 6)接口与接口之间的关系是继承，而且可以实现多继承
 * >>5、6描述的是java中的继承的特点，
 */
public class TestInterface {
	public static void main(String[] args) {
		System.out.println(Test_1.FLAG);
	}
}

class Test_3 {

}

interface Test_1 {
	// 常量 所有常量都用public static final 修饰 可省略
	public static final int I = 12;
	boolean FLAG = false;

	// 抽样方法 所有抽样方法都用public abstract修饰 可省略
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
//接口与接口之间的关系是继承,可以是多继承
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
