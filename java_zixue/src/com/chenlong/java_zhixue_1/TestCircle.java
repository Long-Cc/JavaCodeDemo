package com.chenlong.java_zhixue_1;

public class TestCircle {

	public static void main(String[] args) {
		Circle c=new Circle();
		c.setRadius(4.5);
		c.getArea();
	}

}
class Circle{
	double radius=1.0;
	final double PI=3.14159;
	//�ṩ������ȡԲ�����
	public void getArea(){
		System.out.println("Բ�����Ϊ��");
		System.out.println(PI*radius*radius);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
