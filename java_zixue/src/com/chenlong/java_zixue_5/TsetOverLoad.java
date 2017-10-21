package com.chenlong.java_zixue_5;

public class TsetOverLoad {
	public static void main(String[] args) {
		TsetOverLoad to=new TsetOverLoad();
		to.mOL(12);
		to.mOL("sdasf");
		to.mOL(62, 89);
	}
	//三个方法构成重载
		public void mOL(int i){
			System.out.println(i*i);
		}
		public void mOL(int i,int j){
			System.out.println(i*j);
		}
		public void mOL(String str){
		System.out.println(str);	
		}

}
