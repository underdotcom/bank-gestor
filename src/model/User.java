package model;

public class User {

	private String name;
	private String cc;
	private int priority;
	private BankAccount creditCard;
	private BankAccount currentAccount;
	
	public User(String name, String cc, BankAccount creditCard, BankAccount currentAccount,int  priority) {
		this.name = name;
		this.cc = cc;
		this.creditCard = creditCard;
		this.currentAccount = currentAccount;
		this.priority=priority;
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
	
	public int getPriority() {
		return priority;
	}

	public BankAccount getCreditCard() {
		return creditCard;
	}

	public BankAccount getCurrentAccount() {
		return currentAccount;
	}

	@Override
	public String toString() {
		return "Name: " + name + " Cc: " + cc + " Priority: " + priority + "CreditCard Available: " + creditCard.getBalanceAvailable()
				+ "Current Account Availabe=" + currentAccount.getBalanceAvailable();
	}
	
	
}
