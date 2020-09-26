package model;

import java.time.LocalDate;

public class CreditCard extends BankAccount{

	private long balanceOwing;
	private LocalDate payDate;
	
	public CreditCard(long balanceAvailable, String numberAccount, long balanceOwing, LocalDate payDate) {
		super(balanceAvailable, numberAccount);
		this.balanceOwing = balanceOwing;
		this.payDate = payDate;
	}

	public long getBalanceOwing() {
		return balanceOwing;
	}

	public void setBalanceOwing(long balanceOwing) {
		this.balanceOwing = balanceOwing;
	}

	public LocalDate getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}
}
