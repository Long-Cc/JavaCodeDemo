package com.chenlong.java_banking1;

public class Account {
	private double balance=0;

	public  Account(double init_balance) {
		this.balance = init_balance;
	}


	public double getBalance() { // ��ȡ�������
		return balance;
	}

	public boolean deposit(double amt) {// ��ǰ����������
		balance = balance + amt;
		return true;//���д���ǳɹ���
	}

	public boolean withdraw(double amt) {// �ӵ�ǰ����м�ȥ���
		
		if(balance>=amt){
			balance-=amt;
			return true;
		}else{
			return false;
		}
	}
}
