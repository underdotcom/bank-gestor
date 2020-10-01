package model;

import java.time.LocalDate;

public class User implements Comparable <User>{

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
	
	public double getAccountB() {
		return currentAccount.getBalanceAvailable();
	}
	
	public String getNumberCount() {
		return currentAccount.getNumberAccount();
	}

	public BankAccount getCurrentAccount() {
		return currentAccount;
	}
	
	public LocalDate getConection() {
		int random=(int)(((Math.random())*100));
		return LocalDate.now().plusDays(random);
	}
	
	public LocalDate getPayDate() {
		return LocalDate.now();
	}
	@Override
	public String toString() {
		return "Name: " + name + " Cc: " + cc + " Priority: " + priority + "CreditCard Available: " + creditCard.getBalanceAvailable()
				+ "Current Account Availabe=" + currentAccount.getBalanceAvailable();
	}

	@Override
	public int compareTo(User u) {
		
		if((name.compareTo(u.name))<0) {
			return -1;
		}else if ((name.compareTo(u.name))>0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
}
