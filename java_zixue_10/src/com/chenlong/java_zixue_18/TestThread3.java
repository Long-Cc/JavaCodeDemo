package com.chenlong.java_zixue_18;

// 创建多线程的第一种方式，继承java.lang.Thread类
//创建多线程方式二：通过实现的方式(实现Runnable接口)
/*哪个好？
 *	实现方式好：	避免了Java单继承的局限性
 *		      	如果多个线程要操作同一份资源（数据），用实现要好 
 * 
 * 此程序存在线程的安全问题
 * 线程安全问题存在原因：由于一个线程在操作共享数据过程中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题
 * 				  必须一个线程操作共享数据完毕以后，其他线程才有机会参与共享数据操作。
 * 
 * java如何解决线程安全问题：线程的同步机制
 * 		方式一：同步代码块
 * 				synchronized(同步监视器){
 * 					//需要被同步的代码块(即操作共享数据的代码)
 *			 }
 *				*同步监视器:锁，多个线程必须共用同一把锁
 * 		方式一：同步方法
 * 			public synchronized void show(){
 * 				//需要被同步的代码块(即操作共享数据的代码)
 * 		}	
 * 			public void run(){
 * 			show();
 * }	
 * 
*/

class PrintNum1 implements Runnable {
	public void run() {
		// 子程序执行代码
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
		t1.start();// 启动一个线程，执行Thread对象生成时构造器形参的对象的run（）方法

		// 再创建一个线程
		Thread t2 = new Thread(p);
		t2.start();
	}
}
