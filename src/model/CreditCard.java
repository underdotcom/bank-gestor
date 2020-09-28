package model;

import java.time.LocalDate;

public class CreditCard extends BankAccount{

	public static final double quota = 5000000;
	
	private double balanceOwing;
	private LocalDate payDate;
	
	public CreditCard(double balanceAvailable, String numberAccount, double balanceOwing, LocalDate payDate) {
		super(balanceAvailable, numberAccount);
		this.balanceOwing = balanceOwing;
		this.payDate = payDate;
	}

	public void pay() {
		super.setBalanceAvailable(quota);
		balanceOwing = 0;
	}
	
	public double getBalanceOwing() {
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
