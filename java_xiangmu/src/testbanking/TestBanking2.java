package testbanking;

import banking2.Account;
import banking2.Customer;

public class TestBanking2 {

	public static void main(String[] args) {
		Account account;
		Customer customer;
		
		account=new Account(500.00);
		System.out.println("创建一个余额有500的账户。");
		
		customer=new Customer("Jane","Smith");
		System.out.println("创建一个customer叫 Jane Smith.");
		
		customer.setAccount(account);
		System.out.println("创建这客户有个500余额的账户");
		
		customer.getAccount().withdraw(150.00);
		System.out.println("取150.00");
		
		customer.getAccount().deposit(22.50);
		System.out.println("存22.50");
		
		customer.getAccount().withdraw(47.62);
		System.out.println("取47.62");
		
		System.out.println("customer["+customer.getFirstName()+","+customer.getLastName()+"]账户余额："+customer.getAccount().getBalance());
	}

}
