package com.day2.q3;

public class CurrentAccount extends Account{
	private int tradeLicenseNumber;
	
	public CurrentAccount(int tradeLicenseNumber, String username, double balance) {
		super(username,balance);
		this.tradeLicenseNumber = tradeLicenseNumber;
	}
	
	public double getBalance() {
		return this.getAccountBalance();
	}
	
	public double withdraw(double amount) {
		if(amount<this.getAccountBalance()) {
			this.setAccountBalance(this.getAccountBalance()-amount);
		}
		System.out.print("Current amount : ");
		return this.getAccountBalance();
	}
}
