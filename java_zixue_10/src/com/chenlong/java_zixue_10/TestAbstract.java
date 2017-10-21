package com.chenlong.java_zixue_10;

/*
 *abstract:�������������ࡢ���� 
 *  abstract�����ࣺ������
 *  1)���ɱ�ʵ����
 *  2)�������й�����(�����඼�й�����)
 *  3)���󷽷����ڵ���һ���ڳ�����
 *  4)�������п���û�г��󷽷�
 *  
 *  abstract���η��������󷽷�
 *  1)��ʽ��û�з����壬����{}���磺abstract public void eat();
 *  2)���󷽷�ֻ���������Ĺ��ܣ��������ִ�н�������������࣬��������д�˳��󷽷���
 *  3)������̳г����࣬����д�����еĳ��󷽷����������һ����ʵ���ࡱ���ȿ���ʵ����
 *  4)������̳г����࣬û�м̳����еĳ��󷽷�����ζ�Ŵ����Գ��󷽷���������������Ϊ�����
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
			System.out.println("ѧ���Է�");
		}

		public void walk() {
			System.out.println("ѧ����·");
		}

	}
class Worker extends Person{
		public void eat() {
			System.out.println("���˳Է�");
		}

		public void walk() {
			System.out.println("������·");
		}
	}

