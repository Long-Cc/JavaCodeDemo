package com.chenlong.java_zixue_10;

/*
 *abstract:可以用来修饰类、方法 
 *  abstract修饰类：抽象类
 *  1)不可被实例化
 *  2)抽象类有构造器(凡是类都有构造器)
 *  3)抽象方法所在的类一定在抽象类
 *  4)抽象类中可以没有抽象方法
 *  
 *  abstract修饰方法：抽象方法
 *  1)格式：没有方法体，包括{}比如：abstract public void eat();
 *  2)抽象方法只保留方法的功能，而具体的执行交个抽象类的子类，由子类重写此抽象方法，
 *  3)若子类继承抽象类，并重写了所有的抽象方法，则此类是一个“实体类”，既可以实例化
 *  4)若子类继承抽象类，没有继承所有的抽象方法，意味着此类仍抽象方法，则此类必须声明为抽象的
 * 
 * 
 */

public class TestAbstract {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		Worker p=new Worker();
		p.eat();
		// Person p1=new Person();
		// p1.eat();
	}
}

abstract class Person {
	abstract public void eat();
	abstract public void walk();
	public Person(){
		}
	}

class Student extends Person {
		public void eat() {
			System.out.println("学生吃饭");
		}

		public void walk() {
			System.out.println("学生走路");
		}

	}
class Worker extends Person{
		public void eat() {
			System.out.println("工人吃饭");
		}

		public void walk() {
			System.out.println("工人走路");
		}
	}

