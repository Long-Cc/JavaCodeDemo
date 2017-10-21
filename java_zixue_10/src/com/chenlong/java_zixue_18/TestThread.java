package com.chenlong.java_zixue_18;

/*
 * 创建一个子线程，完成1-100的自然数输出，主线程执行同样操作
 * 创建多线程的第一种方式，继承java.lang.Thread类
 */
class SubThread extends Thread {                                  
	// 重写Thread类的run()方法,方法内实现此子线程要完成的功能
	@SuppressWarnings("static-access")
	public void run() {       
		for (int i = 0; i <= 100;i++) {
			try {
				Thread.currentThread().sleep(1000);//sleep(long 1):让当前线程睡眠1毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		// 创建一个子类对象
		SubThread st = new SubThread();
		// 调用线程start()方法：启动此线程：调用相应的run()方法
		st.setName("=============子线程");
		st.start();
		Thread.currentThread().setName("主线程");// 设置此线程名字
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			// if(i%10==0){
			// Thread.currentThread().yield();//yield()释放CPU使用权
			// }
			if (i == 20) {
				try {
					st.join();// 在A线程中调用B线程的join()，表示，当执行到此方法，A线程停止执行，直至B线程执行完毕；
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
