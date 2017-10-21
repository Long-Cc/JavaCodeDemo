package com.chenlong.java_zixue_9;

public class TestMain1 {
	public static void main(String[] args) {
		Main.main(new String[200]);
	}
}
class Main{
	public static void main(String[] args){
		for(int i=0;i<args.length;i++){
			args[i]="value_"+i;
			System.out.println(args[i]);
		}
	}
}
