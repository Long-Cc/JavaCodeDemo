package com.chenlong.java_zixue_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


/*
 * ����Collection��Map�ӿڵĹ����ࣺCollections
 * 	����Collection��Collections��
 */
public class TestCollections {
	@Test
	public void testCollectins1(){
		List<Integer> list=new ArrayList<>();
		list.add(123);
		list.add(456);
		list.add(97);
		list.add(621);
		System.out.println(list);
		Collections.reverse(list);//��ת
		System.out.println(list);
		Collections.shuffle(list);//�������
		System.out.println(list);
		Collections.sort(list);//��Ȼ����
		System.out.println(list);
		
	}
}
