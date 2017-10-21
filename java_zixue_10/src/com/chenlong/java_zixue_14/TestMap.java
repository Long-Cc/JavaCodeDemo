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
 * Collection�ӿ�
 * 
 * Map�ӿ� HashMap��Map����Ҫʵ���࣬key����Set����ţ������ظ���value����Collection��ŵģ����ظ�
 * һ��key-value��һ��Entry�����е�Entry����Set��ţ�Ҳ�ǲ����ظ��ġ� LinkedHashMap TreeMap Hashtable
 * Properties
 */
public class TestMap {
	/*
	 *TreeMap:��������ӽ�Map��Ԫ�ص�keyָ�����Խ�������Ҫ��key������ͬһ�����
	 */
	@Test
	public void test4(){
		//��Ȼ����
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
	 * LinkedHashMap:ʹ������ά����ӽ�Map�е�˳�򣬹ʱ���Mapʱ�ǰ������˳�������
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
	 * Map���� ����key�� Set keySet() ����value�� Collection value();
	 * ����key-value�ԣ�Entry�� Set EntrySet()
	 */
	@Test
	public void test2() {
		Map map = new HashMap();
		map.put("AA", 213);
		map.put(null, null);
		map.put("SS", 654);
		map.put(452, "YY");
		map.put(new Person("BB", 56), 987);
		// ����key��
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println(obj);
		}
		// ����value��
		Collection coll = map.values();
		for (Object obj : coll) {
			System.out.println(obj);
		}
		// ����key-value��1��ʽ
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "--------->" + map.get(obj));
		}
		System.out.println("=========================");
		// ����key-value��2��ʽ
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
