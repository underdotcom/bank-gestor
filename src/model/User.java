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

	public void setId(String cc) {
		this.cc = cc;
	}

	public BankAccount getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(BankAccount creditCard) {
		this.creditCard = creditCard;
	}

	public BankAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(BankAccount currentAccount) {
		this.currentAccount = currentAccount;
	}
}
