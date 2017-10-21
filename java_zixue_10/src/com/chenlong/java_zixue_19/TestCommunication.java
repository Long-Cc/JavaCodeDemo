package com.chenlong.java_zixue_19;
//�߳�ͨ��
/*
 * wait():һ��һ���߳�ִ�е�wait�����ͷŵ�ǰ����
 * notifyaAll()/notifyAll:����wait��һ�������е��߳�
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

		t1.setName("��");
		t2.setName("��");

		t1.start();
		t2.start();
	}

}
