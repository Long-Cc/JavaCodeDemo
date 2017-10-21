package com.chenlong.java_zixue_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


/*
 * 操作Collection和Map接口的工具类：Collections
 * 	区分Collection与Collections；
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
		Collections.reverse(list);//反转
		System.out.println(list);
		Collections.shuffle(list);//随机排序
		System.out.println(list);
		Collections.sort(list);//自然排序
		System.out.println(list);
		
	}
}
