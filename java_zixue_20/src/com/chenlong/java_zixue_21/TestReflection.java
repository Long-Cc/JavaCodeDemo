package com.chenlong.java_zixue_21;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {
	@Test
	public void test5() throws Exception{
		ClassLoader loader=this.getClass().getClassLoader();
		InputStream is=loader.getResourceAsStream("com\\chenlong\\java_zixue_21\\jdbc.properties");
		
		Properties pros=new Properties();
		pros.load(is);
		String name=pros.getProperty("user");
		System.out.println(name);
		String password=pros.getProperty("password");
		System.out.println(password);
	}
	@Test
	//如何获取Class的实例（3中）
	public void test4() throws ClassNotFoundException{
		//1、调用运行时类本身的.class属性
		Class clazz1=Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz2=String.class;
		System.out.println(clazz2.getName());
		
		//2、调用运行时类本身的对象获得
		Person p=new Person();
		Class clazz3=p.getClass();
		System.out.println(clazz3.getName());
		
		//3、通过Class静态方法获取
		String className="com.chenlong.java_zixue_21.Person";
		Class clazz4=Class.forName(className);
		System.out.println(clazz4.getName());
	}
	@Test
	public void test3() throws ClassNotFoundException{
		Class clazz1=Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz2=String.class;
		System.out.println(clazz2.getName());
	}
	// 有了反射，可以通过反射创建一个类的对象，并调用其中的结构
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;
		// 1、创建clazz对应的运行时类Person类的对象
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
		//2、通过反射调用对应的运行时类的指定属性
		Field f1 = clazz.getField("name");
		f1.set(p, "LiuDeHua");
		System.out.println(p);
		
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		
		//3、通过反射调用对应的运行时类的指定方法
		Method m1=clazz.getMethod("show");
		m1.invoke(p);
		Method m2=clazz.getMethod("display",String.class);
		m2.invoke(p, "CHN");
	}

	// 再有反射以前，如何创建一个类的对象，并调用属性、方法
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		p.setName("刘德华");
		p.setAge(22);
		System.out.println(p);
		p.show();
//		p.display("HK");
	}
}
