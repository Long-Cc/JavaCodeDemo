package com.chenlong.java_zixue_22;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();

	void fly();
}

// 被代理类
class SuperMan implements Human {

	@Override
	public void info() {
		System.out.println("我是超人！");
	}

	@Override
	public void fly() {
		System.out.println("I believe I can fly!");
	}
}

class HumenUtil {
	public void method1() {
		System.out.println("====方法一=====");
	}

	public void method2() {
		System.out.println("====方法二=====");
	}
}

//
class MyinvcationHandler implements InvocationHandler {
	Object obj;// 被代理类的对象声明

	public void setObject(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		HumenUtil h = new HumenUtil();
		h.method1();

		Object returnval = method.invoke(obj, args);

		h.method2();
		return returnval;
	}
}

class MyProxy {
	// 动态的创建一个代理类的对象
	public static Object getProxyInstance(Object obj) {
		MyinvcationHandler handler = new MyinvcationHandler();
		handler.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}

}

public class TestAOP {
	public static void main(String[] args) {
		SuperMan man=new SuperMan();
		Object obj=MyProxy.getProxyInstance(man);
		Human hu=(Human)obj;
		hu.info();//通过代理类的对象调用重写的抽样方法
		System.out.println();
		hu.fly();
		
		System.out.println();
		
		NikeClothFactory nike=new NikeClothFactory();
		Object obj1=MyProxy.getProxyInstance(nike);
		ClothFactory cloth=(ClothFactory)obj1;
		cloth.productCloth();
	}
}
