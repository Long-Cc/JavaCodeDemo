package com.chenlong.java_zixue_14;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class TestList {
	@Test
	public void testList(){
		ArrayList<Integer> list=new ArrayList<>();
		list.add(123);
		list.add(456);
		list.add(564);
		list.add(458);
		//��������Ԫ��---��ʽһ
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//��ʽ������ǿforѭ��
		for(Object o:list){
			System.out.println(o);
		}
	}
}
