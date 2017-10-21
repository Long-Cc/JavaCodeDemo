package com.chenlong.java_zixue_5;

class Circle {
	double radisu;

	public double findArea() {
		return Math.PI * radisu * radisu;
	}

	public double getRadisu() {
		return radisu;
	}

	public void setRadisu(double radisu) {
		this.radisu = radisu;
	}

}

public class PassObject {
	public void printArea(Circle c, int time) {
		System.out.println("Radisu" + "\t\t" + "Area");
		// for (int i = 1; i <= time; i++) {
		// c.setRadisu(i);
		// System.out.println(c.getRadisu() + "\t\t" + c.findArea());
		// }
		int i = 1;
		while (i <= time) {
			c.setRadisu(i);
			System.out.println(c.getRadisu() + "\t\t" + c.findArea());
			i++;
		}
		c.setRadisu(i);
	}

	public static void main(String[] args) {
		PassObject p = new PassObject();
		Circle c = new Circle();
		p.printArea(c, 5);
		System.out.println("now radisu is:" + c.getRadisu());
	}
}
