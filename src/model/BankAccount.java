package model;

public abstract class BankAccount {

	private long balanceAvailable;
	private String numberAccount;
	
	public BankAccount(long balanceAvailable, String numberAccount) {
		this.balanceAvailable = balanceAvailable;
		this.numberAccount = numberAccount;
	}
	
	public long getBalanceAvailable() {
		return balanceAvailable;
	}
	
	public void setBalanceAvailable(long balanceAvailable) {
		this.balanceAvailable = balanceAvailable;
	}
	
	public String getNumberAccount() {
		return numberAccount;
	}
}
