package com.chenlong.java_zixue_8;

public class TestAccount {
	public static void main(String[] args) {
		Account a1=new Account("123zxc",1000);
		Account a2=new Account("123qwe",2000);
		Account a3=new Account("123asd",5000);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

	}
}
class Account{
	private int id;
	private String password;//密码
	private double balance;//余额
	private static double rate=0.5;//利率
	private static double minBlance=1;//最小余额
	private static int init=1000;//static：使用静态的变量可以实现累加的效果，因为静态的变量在内存中独一份！
	
	public Account(String password,double balance){
		this.id=init++;
		this.password=password;
		this.balance=balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		Account.rate = rate;
	}
	public static double getMinBlance() {
		return minBlance;
	}
	public static void setMinBlance(double minBlance) {
		Account.minBlance = minBlance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", balance=" + balance + "]";
	}
	
	
}
