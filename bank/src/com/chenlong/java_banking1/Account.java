package com.chenlong.java_banking1;

public class Account {
	private double balance=0;

	public  Account(double init_balance) {
		this.balance = init_balance;
	}


	public double getBalance() { // 获取经常余额
		return balance;
	}

	public boolean deposit(double amt) {// 向当前余额增加余额
		balance = balance + amt;
		return true;//所有存款是成功的
	}

	public boolean withdraw(double amt) {// 从当前余额中减去余额
		
		if(balance>=amt){
			balance-=amt;
			return true;
		}else{
			return false;
		}
	}
}
