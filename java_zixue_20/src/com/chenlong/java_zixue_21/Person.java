package com.chenlong.java_zixue_21;

@MyAnnotation(value = { "chenlong" })
public class Person extends Creature<String> implements Comparable,MyInterface{
	public String name;
	private int age;
	//创建类时，尽量保留一个空参的构造器
	public Person() {
		super();
	}
	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@MyAnnotation(value = { "chenlong" })
	public void show() throws Exception{
		System.out.println("我是一个人");
	}
	private Integer display(String nation,Integer i){
		System.out.println("我的国籍是:"+nation);
		return i;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void info(){
		System.out.println("中国人");
	}
	class bird{
		
	}
	
}
