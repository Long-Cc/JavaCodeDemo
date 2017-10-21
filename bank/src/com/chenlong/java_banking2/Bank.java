package com.chenlong.java_banking2;

public class Bank {
	private Customer[] customers;
	private int numOfCustomers;
	
	public Bank() {
		customers=new Customer[100];
	}
	public void addCustomer(String f,String l){
		Customer customer=new Customer(f, l);
		customers[numOfCustomers]=customer;
		numOfCustomers++;
	}
	public Customer[] getCustomers() {
		return customers;
	}

	public int getNumOfCustomers() {
		return numOfCustomers;
	}
	public Customer getCustomer(int index){
		return customers[index];
	}
	
}
