package testbanking;

import banking1.Account;

public class TestBanking1 {

	public static void main(String[] args) {
		Account account;
		
		account=new Account(500.00);
		System.out.println("����һ�������500���˻���");
		account.withdraw(150.00);
		System.out.println("ȡ150.00");
		account.deposit(22.5);
		System.out.println("��22.50");
		account.withdraw(46.62);
		System.out.println("ȡ46.62");
		System.out.println("��"+account.getBalance());
	}

}
