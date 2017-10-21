package com.chenlong.java_zixue_5;

class SuperClass{
	double calc(double x,double y){
		return x*y;
	}
}
class DerivdeClass extends SuperClass{
	double calc(double x,double y){
		return x+y;
	}
}
public class OverridMethod {
	public static void main(String[] args) {
		DerivdeClass dc=new DerivdeClass();
		System.out.println("The object is"+dc.toString());
		System.out.println("Invoke method of derived class,output is "+dc.calc(4, 6));
	}

}
