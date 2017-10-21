package com.chenlong.java_zixue_18;

// �������̵߳ĵ�һ�ַ�ʽ���̳�java.lang.Thread��
//�������̷߳�ʽ����ͨ��ʵ�ֵķ�ʽ(ʵ��Runnable�ӿ�)
/*�ĸ��ã�
 *	ʵ�ַ�ʽ�ã�	������Java���̳еľ�����
 *		      	�������߳�Ҫ����ͬһ����Դ�����ݣ�����ʵ��Ҫ�� 
 * 
 * �˳�������̵߳İ�ȫ����
 * �̰߳�ȫ�������ԭ������һ���߳��ڲ����������ݹ����У�δִ����ϵ�����£�������̲߳�����������¹������ݴ����˰�ȫ����
 * 				  ����һ���̲߳���������������Ժ������̲߳��л�����빲�����ݲ�����
 * 
 * java��ν���̰߳�ȫ���⣺�̵߳�ͬ������
 * 		��ʽһ��ͬ�������
 * 				synchronized(ͬ��������){
 * 					//��Ҫ��ͬ���Ĵ����(�������������ݵĴ���)
 *			 }
 *				*ͬ��������:��������̱߳��빲��ͬһ����
 * 		��ʽһ��ͬ������
 * 			public synchronized void show(){
 * 				//��Ҫ��ͬ���Ĵ����(�������������ݵĴ���)
 * 		}	
 * 			public void run(){
 * 			show();
 * }	
 * 
*/

class PrintNum1 implements Runnable {
	public void run() {
		// �ӳ���ִ�д���
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}

public class TestThread3 {
	public static void main(String[] args) {
		PrintNum1 p = new PrintNum1();
		Thread t1 = new Thread(p);
		t1.start();// ����һ���̣߳�ִ��Thread��������ʱ�������βεĶ����run��������

		// �ٴ���һ���߳�
		Thread t2 = new Thread(p);
		t2.start();
	}
}
