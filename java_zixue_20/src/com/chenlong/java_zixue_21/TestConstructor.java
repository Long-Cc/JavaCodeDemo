package com.chenlong.java_zixue_21;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {	//Constructor :构造器
	@Test
	public void test1() throws Exception{
		String className="com.chenlong.java_zixue_21.Person";
		Class clazz=Class.forName(className);
		//创建对应的运行时类的对象，使用newInstance()，实际是调用类运行时类的空参构造
		Object obj=clazz.newInstance();
		Person p=(Person)obj;
		System.out.println(p);
	}
	@Test
	public void test2() throws ClassNotFoundException{
		String className="com.chenlong.java_zixue_21.Person";
		Class clazz=Class.forName(className);
		Constructor[] c=clazz.getDeclaredConstructors();
		for (Constructor constructor : c) {
			System.out.println(constructor);
		}
	}
	//调用指定的构造器
	@Test
	public void test3() throws Exception{
		String className="com.chenlong.java_zixue_21.Person";
		Class clazz=Class.forName(className);
		Constructor c=clazz.getDeclaredConstructor(String.class,int.class);
		c.setAccessible(true);
		Person p=(Person)c.newInstance("罗伟",20);
		System.out.println(p);
	}
}
