package com.chenlong.java_banking2;

public class CheckingAccount extends Account {
	private double overdraftProtection;

	public CheckingAccount(double init_balance) {
		super(init_balance);
	}

	public CheckingAccount(double init_balance, double overdraftProtection) {
		super(init_balance);
		this.overdraftProtection = overdraftProtection;
	}

	public boolean withdraw(double amt) {
		if (balance >= amt) {
			balance -= amt;
		} else {
			if(overdraftProtection>=(amt-balance)){
				overdraftProtection-=(amt-balance);
				balance=0;
			}else{
				return false;
			}
		}
		return true;
	}
}
