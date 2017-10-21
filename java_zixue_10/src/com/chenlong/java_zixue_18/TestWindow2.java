package com.chenlong.java_zixue_18;

class Window implements Runnable {
	int ticket = 100;
//	Object obj = new Object();

	public void run() {
		synchronized (this) {//this ָ  ��ǰ����win
			while (true) {
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ����Ϊ:" + ticket--);
				}
			}
		}
	}
}

public class TestWindow2 {
	public static void main(String[] args) {
		Window win = new Window();

		Thread t1 = new Thread(win);
		Thread t2 = new Thread(win);
		Thread t3 = new Thread(win);

		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");

		t1.start();
		t2.start();
		t3.start();
	}
}
