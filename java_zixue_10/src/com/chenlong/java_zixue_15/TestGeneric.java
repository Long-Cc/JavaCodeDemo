package com.chenlong.java_zixue_15;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {
	/*
	 * 通配符的使用
	 */
	@Test
	public void test7(){
		List<String> list=new ArrayList<String>();
		list.add("AA");
		list.add("RR");
		List<?> list1=list;
		
		Iterator<?> iterator=list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	/*
	 * 通配符：?
	 * List<A>、List<B>....都是List<?>的子类
	 * ? extends A:可以存放A及其子类
	 * ? super B:可以存放B及其父类
	 */
	@Test
	public void test6(){
		List<?> list=null;
		List<String> list1=new ArrayList<String>();
		list=list1;
		List<Object> list2=new ArrayList<Object>();
		list=list2;
		list.size();
	}
	public void show(List<?> list){
		
	}
	@Test
	public void test5(){
		Order<Boolean> o=new Order<Boolean>();
//		Integer i=o.getE(5);
		System.out.println(o.getE(5.6));
		
		Integer[] in=new Integer[]{1,2,3};
		List<Integer> list=new ArrayList<>();
		List<Integer> l=o.fromArrayToList(in, list);
		System.out.println(l);
	}
	/*
	 * 自定义泛型类的使用
	 */
	@Test
	public void test4(){
		Order<Boolean> o=new Order<>();
		o.setT(true);
		System.out.println(o.getT());
//		o.add();
		List<Boolean> list=o.list;
		System.out.println(list);
		
	}
	@Test
	public void test3(){
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("AA", 65);
		map.put("CC", 25);
		map.put("SS", 68);
		map.put("DD", 95);
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		for(Map.Entry<String, Integer> o:set){
			System.out.println(o.getKey());
		}
	}
	@Test
	public void test2(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(45);
		list.add(88);
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test
	public void test1(){
		List<Integer> list=new ArrayList<>();
		list.add(12);
		list.add(45);
		list.add(88);
		list.add(98);
//		list.add(new String("BB"));
		
		for(int i=0;i<list.size();i++){
		int score=(Integer)list.get(i);
		System.out.println(score);
		}
		
	}
}
