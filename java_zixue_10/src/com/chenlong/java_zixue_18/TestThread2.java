package com.chenlong.java_zixue_18;

public class TestThread2 {
	public static void main(String[] args) {
		subThread2 st2=new subThread2();
		subThread3 st3=new subThread3();
		st2.start();
		st3.start();
	}
}

class subThread2 extends Thread {
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}
class subThread3 extends Thread {
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}

		}
	}
}
