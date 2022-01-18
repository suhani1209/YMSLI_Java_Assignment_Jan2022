package com.day2.q3;

public class SavingAccount extends Account{
	private int interest=5;
	private int maxWtithdrawAmountLimit;
	
	
	public SavingAccount() {
		super();
	}

	public SavingAccount(String memberName, double accountBalance,int maxLimit) {
		super(memberName, accountBalance);
		this.maxWtithdrawAmountLimit=maxLimit;
	}

	public double getBalance() {
		return ((interest/100)*this.getAccountBalance()+this.getAccountBalance());
	}
	
	public double withdraw(double amount)
	{
		if(amount<maxWtithdrawAmountLimit && (this.getAccountBalance()-amount>50000)) {
			this.setAccountBalance(this.getAccountBalance()-amount);
		}
		System.out.print("Current Amount : ");
		return this.getAccountBalance();
	}
}
