package com.chenlong.java_zixue_18;

class Window3 implements Runnable{
	int ticket = 100;
	public void run(){
		while(true){
			show();
		}
	} 
	public synchronized void show(){//锁：当前对象 this
		if(ticket>0){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+ticket--);
		}
	}
}
	
public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w=new Window3();
		
		Thread t1=new Thread(w);
		Thread t2=new Thread(w);
		Thread t3=new Thread(w);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
