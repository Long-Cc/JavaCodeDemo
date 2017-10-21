package com.chenlong.java_zixue_10;
/*
 * final:最终的，可以用来修饰类、属性、方法
 * 
 *1. final修饰类，这个类不能被继承，如String类、StringBuffer类、System类
 *2. final修饰方法，不能被重写    如Object类中getClass
 *3. final修饰属性，此属性就是个常量，一旦初始化不可再被赋值，习惯是，常量用大写字母书写
 *    此常量在哪赋值：此常量不能默认的初始化，可以显式赋值、代码块、构造器
 *  变量用static、final修饰：全局变量
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