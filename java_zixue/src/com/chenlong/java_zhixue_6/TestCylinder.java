package com.chenlong.java_zhixue_6;

public class TestCylinder {

	public static void main(String[] args) {
		Cylinder c=new Cylinder();
		c.setRadius(3.5);
		c.setLength(3);
		
		double area=c.findArea();
		System.out.println("Բ�������"+area);
		System.out.println("Բ�������"+c.findVolume());
	}

}
