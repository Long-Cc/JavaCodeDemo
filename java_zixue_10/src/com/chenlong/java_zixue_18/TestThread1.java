package com.chenlong.java_zixue_18;

class SubThread1 extends Thread {
	// ��дThread���run()����,������ʵ�ִ����߳�Ҫ��ɵĹ���
	@SuppressWarnings("static-access")
	public void run() {
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.currentThread().sleep(1000);// sleep(long 1):�õ�ǰ�߳�˯��1����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":"+i);
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		// ����һ���������
		SubThread1 st = new SubThread1();
		// �����߳�start()�������������̣߳�������Ӧ��run()����
		st.setName("=============���߳�");
		st.setPriority(Thread.MAX_PRIORITY);
		st.start();
		Thread.currentThread().setName("���߳�");// ���ô��߳�����
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			// if(i%10==0){
			// Thread.currentThread().yield();//yield()�ͷ�CPUʹ��Ȩ
			// }
			if (i == 20) {
				try {
					st.join();// ��A�߳��е���B�̵߳�join()����ʾ����ִ�е��˷�����A�߳�ִֹͣ�У�ֱ��B�߳�ִ����ϣ�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
