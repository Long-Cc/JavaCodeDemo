package com.chenlong.java_zixue_3;

public class TestTriAngle {

	public static void main(String[] args) {
		TriAngle ta=new TriAngle();
		ta.setBase(12.3);
		System.out.println("�ף�"+ta.getBase());
		ta.setHeight(4);
		System.out.println("�ߣ�"+ta.getHeight());
		System.out.println("���Ϊ��"+ta.countArea());
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
