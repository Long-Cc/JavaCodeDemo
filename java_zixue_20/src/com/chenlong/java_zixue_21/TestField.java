package com.chenlong.java_zixue_21;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;
//获取对的运行时类的属性
public class TestField {
	@Test
	public void test1(){
		Class<Person> clazz=Person.class;
		//1、getFields()只能获取运行时类的及其父类的public的属性
		Field[] fields=clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		//2、getDeclaredFields(),获取运行时类的本身所有属性
		Field[] fields1=clazz.getDeclaredFields();
		for (Field f:fields1) {
			System.out.println(f.getName());
		}
	}
	//权限修饰符  变量类型  变量名
	@Test
	public void test2(){
		Class<Person> clazz=Person.class;
		Field[] fields1=clazz.getDeclaredFields();
		for (Field f:fields1) {
			//获取每个属性的权限修饰符
			int i=f.getModifiers();
			String str=Modifier.toString(i);
			System.out.print(str+" ");
			//获取每个属性的类型
			Class type=f.getType();
			System.out.println(type);
			//获取每个属性的名
			System.out.println(f.getName());
			System.out.println();
		}
	}
	//调用运行时类中指定属性
	@Test
	public void test3() throws Exception{
		Class<Person> clazz=Person.class;
		//1、获取指定属性
		Field name=clazz.getField("name");
		//2、创建运行时类的对象
		Person p=(Person)clazz.newInstance();
		System.out.println(p);
		//将运行时类指定的属性赋值
		name.set(p, "Jey");
		System.out.println(p);
		Field age=clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(p, 10);
		System.out.println(p);
	}
}
