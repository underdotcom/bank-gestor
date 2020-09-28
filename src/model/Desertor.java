package model;

import java.time.LocalDate;

public class Desertor extends User{

	private String cancelationReason;
	private LocalDate cancelationDate;
	
	public Desertor(String name, String cc, BankAccount creditCard, BankAccount currentAccount,String cancelationReason, LocalDate cancelationDate) {
		super(name, cc, creditCard, currentAccount, 0);
		this.cancelationReason = cancelationReason;
		this.cancelationDate = cancelationDate;
	}
	
	public Desertor(User user, String cancelationReason, LocalDate cancelationDate) {
		super(user.getName(), user.getId(), user.getCreditCard(), user.getCurrentAccount(), 0);
		this.cancelationReason = cancelationReason;
		this.cancelationDate = cancelationDate;
	}

	public String getCancelationReason() {
		return cancelationReason;
	}

	public LocalDate getCancelationDate() {
		return cancelationDate;
	}
}
