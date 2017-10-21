package com.chenlong.java_zhixue_6;

public class TestKids {

	public static void main(String[] args) {
		Kids someKid=new Kids();
		
		someKid.setSalary(0);
		someKid.setSex(1);
		someKid.setYeasOld(15);
		
		someKid.employeed();
		someKid.manOrWoman();
		someKid.printAge();
	}

}
