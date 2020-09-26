package model;

public class User {

	private String name;
	private String cc;
	private BankAccount creditCard;
	private BankAccount currentAccount;
	
	public User(String name, String cc, BankAccount creditCard, BankAccount currentAccount) {
		this.name = name;
		this.cc = cc;
		this.creditCard = creditCard;
		this.currentAccount = currentAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return cc;
	}

	public BankAccount getCreditCard() {
		return creditCard;
	}

	public BankAccount getCurrentAccount() {
		return currentAccount;
	}
}
