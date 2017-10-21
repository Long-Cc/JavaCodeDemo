package com.chenlong.java_zixue_14;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet {
	/**
	 * TreeSet�������� 1������һ��ʵ����comparator()�ӿڵ������
	 * ��TreeSet�����Customer��Ķ����ڴ�compare���������У�ָ���ǰ���customer���ĸ����������
	 * 2�����˶�����Ϊ�βδ��ݸ�TreeSet�Ĺ�������
	 * 3����TreeSet�����comparator()�ӿ��е�compare()�������漰����Ķ���
	 */
	@Test
	public void testTreeSet2() {
		Comparator com = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Customer && o2 instanceof Customer) {
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					int i= c1.getId().compareTo(c2.getId());
					if(i==0){
						return c1.getName().compareTo(c2.getName());
					}
					return i;
				}
				return 0;
			}
		};
		TreeSet set = new TreeSet(com);
		set.add(new Customer("AA", 1003));
		set.add(new Customer("BB", 1005));
		set.add(new Customer("GG", 1003));
		set.add(new Customer("CC", 1002));
		set.add(new Customer("DD", 1008));

		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * TreeSet()��Ȼ���򣬴�С����˳�����
	 */
	@Test
	public void testTreeSet() {
		Set set = new TreeSet();
		set.add(new Person("AA", 23));
		set.add(new Person("FF", 22));
		set.add(new Person("SS", 20));
		set.add(new Person("GG", 20));
		set.add(new Person("MM", 24));
		set.add(new Person("BB", 25));
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testLinkedHashSet() {
		Set set = new LinkedHashSet();
		set.add(123);
		set.add(456);
		set.add(new String("AA"));
		set.add(new String("AA"));
		set.add("BB");
		set.add(null);
		// Iterator iterator=set.iterator();
		// while(iterator.hasNext()){
		// System.out.println(iterator.next());
	}
}
