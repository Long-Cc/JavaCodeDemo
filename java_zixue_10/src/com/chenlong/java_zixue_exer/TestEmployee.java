package com.chenlong.java_zixue_exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestEmployee {
	// 定制排序
	@SuppressWarnings("rawtypes")
	@Test
	public void test2() {
		@SuppressWarnings("unused")
		Comparator com = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee1 && o2 instanceof Employee1) {
					Employee1 e1 = (Employee1) o1;
					Employee1 e2 = (Employee1) o2;
					MyDate bith1 = e1.getBirthday();
					MyDate bith2 = e2.getBirthday();
					if (bith1.getYear() != bith2.getYear()) {
						return bith1.getYear() - bith2.getYear();
					} else {
						if (bith1.getMonth() != bith2.getMonth()) {
							return bith1.getMonth() - bith2.getMonth();
						} else
							return bith1.getDay() - bith2.getDay();
					}
				}
				return 0;
			}

		};
		Employee e1 = new Employee("AA", 24, new MyDate(4, 10, 1935));
		Employee e2 = new Employee("DD", 12, new MyDate(4, 11, 1985));
		Employee e3 = new Employee("FF", 56, new MyDate(4, 5, 1985));
		Employee e4 = new Employee("GG", 45, new MyDate(2, 6, 1955));
		Employee e5 = new Employee("NN", 32, new MyDate(4, 6, 1955));

		TreeSet<Employee> set = new TreeSet<Employee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator<Employee> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	// 自然排序
	@Test
	public void test1() {
		Employee e1 = new Employee("AA", 24, new MyDate(4, 10, 1935));
		Employee e2 = new Employee("DD", 12, new MyDate(4, 11, 1985));
		Employee e3 = new Employee("FF", 56, new MyDate(4, 5, 1945));
		Employee e4 = new Employee("GG", 45, new MyDate(4, 6, 1955));
		Employee e5 = new Employee("NN", 32, new MyDate(4, 2, 1966));

		TreeSet<Employee> set = new TreeSet<Employee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);

		Iterator<Employee> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
