package com.chenlong.java_zixue_5;

import java.util.*;

class SpecificHashSet extends HashSet<Object> {

	private static final long serialVersionUID = 1L;
	private int addCount = 0;

	public boolean add(Object o) {
		addCount++;
		return super.add(o);
	}

	public boolean addAll(Collection c) {
		addCount += c.size();
		return super.add(c);
	}

	public int getAddCount() {
		return addCount;
	}
}

public class InHeritanceTest {
	public static void main(String[] args) {
		Vector vt = new Vector();
		for (int j = 0; j < 3; j++) {
			vt.add(new Integer(j));
		}
		SpecificHashSet shs = new SpecificHashSet();
		shs.addAll((Collection) vt);
		System.out.println(shs.size());
		System.out.println(shs.getAddCount());
	}

}
