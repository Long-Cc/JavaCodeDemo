package com.chenlong.java_zhixue_6;

public class Kids extends Mankind {
	private int yeasOld;
	
	public int getYeasOld() {
		return yeasOld;
	}

	public void setYeasOld(int yeasOld) {
		this.yeasOld = yeasOld;
	}

	public void printAge(){
		System.out.println(this.yeasOld+"yeas Old");
	}
}
