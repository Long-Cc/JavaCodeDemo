package com.chenlong.java_zixue_14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	@Test
	public void test2(){
		Collection coll1=new ArrayList();
		coll1.add(123);
		coll1.add(new String("BB"));
		coll1.add(new Circle());
		coll1.add(456);
		
		for(Object i:coll1){
			System.out.println(i);
		}
	}
	@Test
	public void test1(){
		Collection coll1=new ArrayList();
		coll1.add(123);
		coll1.add(new String("BB"));
		coll1.add(new Circle());
		coll1.add(456);
		
		Iterator iterator=coll1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
