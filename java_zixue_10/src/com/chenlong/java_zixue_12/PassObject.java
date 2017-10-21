package com.chenlong.java_zixue_12;

public class PassObject {
	public static void main(String[] args) {
		PassObject p1=new PassObject();
		p1.printAreas(new Circle(), 5);
	}
	public void printAreas(Circle c, int time){
		System.out.println("Radius\t"+"\tArea");
		int i=1;
		while(i<=time){
			c.setRadius(i);
			System.out.println(c.getRadius()+"\t\t"+c.findArea());
			i++;
		}
	}
}

class Circle {
	double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double findArea() {
		return Math.PI * radius * radius;
	}
}