package com.day2.q3;

import java.util.Random;

abstract class Account {
	private String memberName;
	private int accountNumber;
	private double accountBalance;
	
	public Account() {}
	public Account(String memberName,double accountBalance)
	{
		Random rand=new Random();
		this.accountNumber=10000+rand.nextInt(89999);
		this.memberName=memberName;
		this.accountBalance=accountBalance;
		System.out.println("Account created sccessfully...");
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getMemberName() {
		return memberName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	
	abstract public double getBalance();
	abstract public double withdraw(double amount);
	
}
