package com.chenlong.java_zixue_3;

public class TestTriAngle {

	public static void main(String[] args) {
		TriAngle ta=new TriAngle();
		ta.setBase(12.3);
		System.out.println("底："+ta.getBase());
		ta.setHeight(4);
		System.out.println("高："+ta.getHeight());
		System.out.println("面积为："+ta.countArea());
	}

}
class TriAngle{
	private double base;
	private double height;
	
	public void setBase(double b){
		base=b;
	}
	public double getBase(){
		return base;
	}
	public void setHeight(double h){
		height=h;
	}
	public double getHeight(){
		return height;
	}
	public double countArea(){
		return 0.5*base*height;
	}
	
	public TriAngle(){
		
	}
	
}
