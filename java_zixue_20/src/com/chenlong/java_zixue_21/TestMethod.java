package com.chenlong.java_zixue_21;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	// 获取运行时类的方法
	@Test
	public void test1() {
		Class clazz = Person.class;
		// 1、getMethods()：获取运行时类及其父类所有声明为public的方法
		Method[] m1 = clazz.getMethods();
		for (Method m : m1) {
			System.out.println(m);
		}
		System.out.println();
		// 2、getDeclaredMethods():获取运行时类本身所有的方法
		Method[] m2 = clazz.getDeclaredMethods();
		for (Method m : m2) {
			System.out.println(m);
		}
	}

	// 获取运行时类的方法的 注解 权限修饰符 返回值类型 方法名 形参列表 异常
	@Test
	public void test2() {
		Class clazz = Person.class;
		Method[] m2 = clazz.getDeclaredMethods();
		for (Method m : m2) {
			// 注解
			Annotation[] ann = m.getAnnotations();
			for (Annotation a : ann) {
				System.out.println(a);
			}

			// 权限修饰符
			String str = Modifier.toString(m.getModifiers());
			System.out.print(str + " ");

			// 返回值类型
			Class returnType = m.getReturnType();
			System.out.print(returnType.getName() + " ");

			// 方法名
			System.out.print(m.getName() + " ");

			// 形参列表
			System.out.print("(");
			Class[] para = m.getParameterTypes();
			for (int i = 0; i < para.length; i++) {
				System.out.print(para[i].getName() + " args-" + i + " ");
			}
			System.out.print(")");
			// 异常
			Class[] exps = m.getExceptionTypes();
			if (exps.length != 0) {
				System.out.print("throws ");
			}
			for (int i = 0; i < exps.length; i++) {
				System.out.print(exps[i].getName() + " ");
			}
			System.out.println();
		}
	}

	// 获取运行时类的指定的方法
	@Test
	public void test3() throws Exception {
		Class clazz = Person.class;
		Method m1 = clazz.getMethod("show");
		Person p = (Person) clazz.newInstance();
		Object returnval = m1.invoke(p);
		System.out.println(returnval);

		Method m2 = clazz.getMethod("toString");
		Object returnval1 = m2.invoke(p);
		System.out.println(returnval1);

		Method m3 = clazz.getDeclaredMethod("display", String.class, Integer.class);
		m3.setAccessible(true);// 保证可访问的private的方法
		Object obj = m3.invoke(p, "HK", 10);// 我的国籍是HK
		System.out.println(obj);// 10

		Method m4 = clazz.getMethod("info");
		m4.invoke(Person.class);
	}
}
