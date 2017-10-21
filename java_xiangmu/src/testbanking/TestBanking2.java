package testbanking;

import banking2.Account;
import banking2.Customer;

public class TestBanking2 {

	public static void main(String[] args) {
		Account account;
		Customer customer;
		
		account=new Account(500.00);
		System.out.println("����һ�������500���˻���");
		
		customer=new Customer("Jane","Smith");
		System.out.println("����һ��customer�� Jane Smith.");
		
		customer.setAccount(account);
		System.out.println("������ͻ��и�500�����˻�");
		
		customer.getAccount().withdraw(150.00);
		System.out.println("ȡ150.00");
		
		customer.getAccount().deposit(22.50);
		System.out.println("��22.50");
		
		customer.getAccount().withdraw(47.62);
		System.out.println("ȡ47.62");
		
		System.out.println("customer["+customer.getFirstName()+","+customer.getLastName()+"]�˻���"+customer.getAccount().getBalance());
	}

}
