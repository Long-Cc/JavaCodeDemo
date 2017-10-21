package com.chenlong.java_zixue_11;

public class TestCircle {
	public static void main(String[] args) {
		ComparableCircle c1 = new ComparableCircle(2.3);
		ComparableCircle c2 = new ComparableCircle(2.1);
		int i1=c1.compareTo(c2);
		System.out.println(i1);
		int i2=c2.compareTo(null);
		System.out.println(i2);
	}
}

interface CompareObject {
	int compareTo(Object o);
}

class Circle {
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}

class ComparableCircle extends Circle implements CompareObject, Object {
	
	public ComparableCircle(double radius) {
		super(radius);
	}

	@Override
	public int compareTo(Object o) {
		if (this == o) {
			return 0;
		} else if (o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle) o;
			if (this.getRadius() > c.getRadius()) {
				return 1;
			} else if (this.getRadius() < c.getRadius()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			// return -2;
			throw new RuntimeException("传入的非ComparableCircle得对象，不可进行比较");
		}
	}

	@Override
	public void action() {
		
	}

}