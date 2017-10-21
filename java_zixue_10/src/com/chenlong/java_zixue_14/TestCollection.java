package com.chenlong.java_zixue_14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestCollection {
	public static void main(String[] args) {
		Collection<String> coll1=new ArrayList<>();
		coll1.add("AA");
		coll1.add("56");
		coll1.add(new String("AA"));
		System.out.println(coll1);
		Iterator<String> iter=coll1.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
