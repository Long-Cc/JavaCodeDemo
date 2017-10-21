package testbanking;

import banking1.Account;

public class TestBanking1 {

	public static void main(String[] args) {
		Account account;
		
		account=new Account(500.00);
		System.out.println("创建一个余额有500的账户。");
		account.withdraw(150.00);
		System.out.println("取150.00");
		account.deposit(22.5);
		System.out.println("存22.50");
		account.withdraw(46.62);
		System.out.println("取46.62");
		System.out.println("余额："+account.getBalance());
	}

}
