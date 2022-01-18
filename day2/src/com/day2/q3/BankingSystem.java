package com.day2.q3;

public class BankingSystem {
	public static void main(String[] args) {
		Account account=new CurrentAccount(1230 , "Suhani", 75550.80);
		System.out.println(account.withdraw(1000.50));
		System.out.println("Account Details ....");
		System.out.println("Username : " + account.getMemberName());
		System.out.println("Account Number : " + account.getAccountNumber());
		System.out.println("Account Balance : " + account.getAccountBalance());	
	}
}
