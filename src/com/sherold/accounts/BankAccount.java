package com.sherold.accounts;
import java.util.Random;

public class BankAccount {
	// <----- Attributes ----->
	protected String accountNumber;
	protected double checkingBalance;
	protected double savingsBalance;
	
	// Static attributes (for bank)
	private static int accountsCountTotal;
	private static double accountsMoneyTotal;
	
	// <----- Constructors ----->
	public BankAccount() {
		// Creates account number when the object is instantiated.
		accountNumber = generateAccountNumber();
		checkingBalance = 0;
		savingsBalance = 0;
		
		// Adds a counter to the Bank's Account Total
		accountsCountTotal++;
		
		// Adds total to accountsMoneyTotal
		accountsMoneyTotal += checkingBalance + savingsBalance;
	}
	
	// <----- Getters/Setters ----->
	// Getter -- accountNumber;
	public String getAccountNumber() {
		return accountNumber;
	}

	public static int getAccountsCountTotal() {
		return accountsCountTotal;
	}

	public static double getAccountsMoneyTotal() {
		return accountsMoneyTotal;
	}

	// <----- Methods ----->
	// Creates 10 digit random account number -- Private so that it can only be accessed during instantiation
	private String generateAccountNumber() {
		String accountNum = "";
		Random r = new Random();
		int i = 0;
		
		while (i < 10) {
			accountNum += Integer.toString(r.nextInt(10));
			i++;
		}		
		return accountNum;
	}
	
	// Allows user to deposit money into checking or savings account
	public void deposit(String account, double amount) {					
		// If account == checking
		if (account == "checking") {
			checkingBalance += amount;
			
			// Adds total to the bank total
			accountsMoneyTotal += amount;
		
			// Else if account == savings
		} else if (account == "savings") {
			savingsBalance += amount;
			
			// Adds total to the bank total
			accountsMoneyTotal += amount;
			
		// Else throw error message
		} else {
			System.out.println("Please select a proper account type for deposit: 'checking' or 'savings'!");
		}
	}
	
	// Allows user to withdraw money from checking or savings account
	public void withdraw(String account, double amount) {
		// if account == checking
		if (account == "checking") {
			// If amount is more than funds available
			if (amount > checkingBalance) {
				System.out.println("Insufficient funds!");
			} else {
				checkingBalance -= amount;
				
				// Removes amount from bank total
				accountsMoneyTotal -= amount;
			}
			// if account == savings
		} else if (account == "savings") {
			// If amount is more than funds available
			if (amount > savingsBalance) {
				System.out.println("Insufficient funds!");
			} else {
				savingsBalance -= amount;
				
				// Removes amount from bank total
				accountsMoneyTotal -= amount;
			}
			
		// Else throw error message
		} else {
			System.out.println("Please select a proper account type for withdraw: 'checking' or 'savings'!");
		}		
	}
	
	// Allows the user to see the total balance of their checking and saving accounts
	public String accountsTotal() {
		double accountsTotal = checkingBalance + savingsBalance;
		return "Checking Balance: " + checkingBalance + 
				"\nSavings Balance: " + savingsBalance + 
				"\nTotal Balance : " + accountsTotal;
	}
}
