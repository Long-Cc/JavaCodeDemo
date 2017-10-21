package com.chenlong.java_zixue_18;
//模拟火车售票窗口，开启三个售票窗口，总数为100张

//此程序存在线程的安全问题

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
					System.out.println(Thread.currentThread().getName() + "售票，号为:" + ticket--);
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

		win1.setName("窗口1");
		win2.setName("窗口2");
		win3.setName("窗口3");

		win1.start();
		win2.start();
		win3.start();
	}
}
