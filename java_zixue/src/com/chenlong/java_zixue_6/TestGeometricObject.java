package com.chenlong.java_zixue_6;

public class TestGeometricObject {

	public static void main(String[] args) {
		TestGeometricObject t=new TestGeometricObject();
		
		Circle c1=new Circle(2.3, "gr", 1.0);
		Circle c2=new Circle(2.3, "rd", 1.0);
		
		MyRectangle m1=new MyRectangle(2.3,3.0,"bl",2.0);
		
		t.displayGeometricObject(m1);
		boolean b=t.equalsArea(c1, c2);
		System.out.println(b);
	}
	
	
	
	//判断该两个对象的面积是否相等
	public boolean equalsArea(GeometricObject o1,GeometricObject o2){
//		if(o1.findArea()==o2.findArea()){
//			return true;
//		}else
//			return false;
		return o1.findArea()==o2.findArea();
	}
	public void displayGeometricObject(GeometricObject o){
		System.out.println(o.findArea());
	}
}
