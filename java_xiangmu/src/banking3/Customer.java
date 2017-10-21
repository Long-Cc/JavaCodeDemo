package banking3;

public class Customer {
	private String firstname;
	private String lasttname;
	private Account account;
	
	public Customer(String f,String l){
		firstname=f;
		lasttname=l;
	}
	public String getFirstName(){
		return firstname;
	}
	public String getLastName(){
		return lasttname;
	}
	public Account getAccount(){
		return account;
	}
	public void setAccount(Account acct){
		account=acct;
	}
}
