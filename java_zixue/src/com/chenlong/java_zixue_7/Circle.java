package com.chenlong.java_zixue_7;

public class Circle extends GeometricObject{
	private double radius;
	
	public Circle(){
		this.radius=1.0;
	}
	public Circle(double radius){
		this.radius=radius;
	}
	public Circle(double radius,String color,double weight){
		super(color,weight);
		this.radius=radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//Բ�����
	public double findArea(){
		return Math.PI*radius*radius;
	}
//	//��дequals��������
//	public boolean equals(Object obj){
//		if(obj==this){
//			return true;
//		}
//		else if(obj instanceof Circle){
//			Circle c1=(Circle)obj;
//			return this.radius==c1.radius;
//		}else{
//			return false;
//		}
//			
//	}
//	//��дtoString��������
//	public String toString(){
//		return radius+"";
//	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

}
