package com.chenlong.java_zixue_14;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.chenlong.java_zixue_14.Person;

/**
 * Collection接口
 * 
 * Map接口 HashMap：Map的主要实现类，key是用Set来存放，不可重复，value是用Collection存放的，可重复
 * 一个key-value是一个Entry。所有的Entry是用Set存放，也是不可重复的。 LinkedHashMap TreeMap Hashtable
 * Properties
 */
public class TestMap {
	/*
	 *TreeMap:按照先添加进Map中元素的key指定属性进行排序，要求：key必须是同一类对象
	 */
	@Test
	public void test4(){
		//自然排序，
		Map<Person,Integer> map=new TreeMap<>();
		map.put(new Person("dd",28), 89);
		map.put(new Person("SS",23), 35);
		map.put(new Person("AA",78), 59);
		map.put(new Person("VV",28), 79);
		
		Set<Person> set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "--------->" + map.get(obj));
		}
	} ;
	
	
	/*
	 * LinkedHashMap:使用链表维护添加进Map中的顺序，故遍历Map时是按照添加顺序遍历。
	 */
	@Test
	public void test3() {
		Map<String,Integer> map = new LinkedHashMap<>();
		map.put("AA", 213);
		map.put(null, null);
		map.put("SS", 654);
		map.put("YY",452);

		Set<String> set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "--------->" + map.get(obj));
		}
	}

	/*
	 * Map遍历 遍历key集 Set keySet() 遍历value集 Collection value();
	 * 遍历key-value对（Entry） Set EntrySet()
	 */
	@Test
	public void test2() {
		Map map = new HashMap();
		map.put("AA", 213);
		map.put(null, null);
		map.put("SS", 654);
		map.put(452, "YY");
		map.put(new Person("BB", 56), 987);
		// 遍历key集
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println(obj);
		}
		// 遍历value集
		Collection coll = map.values();
		for (Object obj : coll) {
			System.out.println(obj);
		}
		// 遍历key-value集1方式
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "--------->" + map.get(obj));
		}
		System.out.println("=========================");
		// 遍历key-value集2方式
		Set set2 = map.entrySet();
		for (Object obj : set2) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry);
		}
	}

	@Test
	public void test1() {
		Map map = new HashMap();
		map.put("AA", 213);
		map.put(null, null);
		map.put("SS", 654);
		map.put(452, "YY");
		map.put("SS", 4);
		map.put(new Person("BB", 56), 987);
		System.out.println(map.size());
		map.remove("SS");
		System.out.println(map);
		Object value = map.get(42);
		System.out.println(value);
	}
}
