package com.chenlong.java_zixue_17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	@Test
	public void testObjectInputStream() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("person.txt"));

			Person p1 = (Person) ois.readObject();
			System.out.println(p1);
			Person p2 = (Person) ois.readObject();
			System.out.println(p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	// 对象的序列化过程
	@Test
	public void testObjectOutputStream() {
		Person p1 = new Person("小米", 23, new Pet("小小"));
		Person p2 = new Person("红米", 22, new Pet("小红"));

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}

// 类实现可序列化,要求实现Serializable接口；
//
class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Name;
	Integer age;
	Pet pet;

	public Person(String name, Integer age, Pet pet) {
		this.Name = name;
		this.age = age;
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Person [Name=" + Name + ", age=" + age + ", pet=" + pet + "]";
	}

}

class Pet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Name;

	public Pet(String name) {
		this.Name = name;
	}

	@Override
	public String toString() {
		return "Pet [Name=" + Name + "]";
	}
}
