package model;

public abstract class BankAccount {

	private double balanceAvailable;
	private String numberAccount;
	
	public BankAccount(double balanceAvailable, String numberAccount) {
		this.balanceAvailable = balanceAvailable;
		this.numberAccount = numberAccount;
	}
	
	public double getBalanceAvailable() {
		return balanceAvailable;
	}
	
	public void setBalanceAvailable(double balanceAvailable) {
		this.balanceAvailable = balanceAvailable;
	}
	
	public String getNumberAccount() {
		return numberAccount;
	}
}
