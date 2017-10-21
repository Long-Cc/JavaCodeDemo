package com.chenlong.java_zixue_19;
//线程通信
/*
 * wait():一旦一个线程执行到wait，就释放当前的锁
 * notifyaAll()/notifyAll:唤醒wait的一个或所有的线程
 */
class PrintNum implements Runnable {
	int num = 1;

	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (num <= 100) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + num);
					num++;
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

public class TestCommunication {
	public static void main(String[] args) {
		PrintNum pn = new PrintNum();
		Thread t1 = new Thread(pn);
		Thread t2 = new Thread(pn);

		t1.setName("甲");
		t2.setName("乙");

		t1.start();
		t2.start();
	}

}
