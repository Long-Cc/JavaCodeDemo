package com.chenlong.java_zixue_18;
//ģ�����Ʊ���ڣ�����������Ʊ���ڣ�����Ϊ100��

//�˳�������̵߳İ�ȫ����

class Window1 extends Thread {
	static int ticket = 100;
	static Object obj = new Object();

	public void run() {
		synchronized (obj) {
			while (true) {
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ����Ϊ:" + ticket--);
				} else {
					break;
				}
			}
		}
	}
}

public class TestWindow {
	public static void main(String[] args) {
		Window1 win1 = new Window1();
		Window1 win2 = new Window1();
		Window1 win3 = new Window1();

		win1.setName("����1");
		win2.setName("����2");
		win3.setName("����3");

		win1.start();
		win2.start();
		win3.start();
	}
}
