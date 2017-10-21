package com.chenlong.java_zhixue_6;

public class Cylinder extends Circle{
	private double length;
	
	public Cylinder(){
		this.length=1;
	}
	public void setLength(double length){
		this.length=length;
	}
	public double getLength(){
		return length;
	}
	
	public double findVolume(){
			return length*Math.PI*getRadius()*getRadius();
			//		return length*findArea();
	}
	public double findArea(){
		return Math.PI*getRadius()*getRadius()*2+Math.PI*2*getRadius()*getLength();
	}
}
