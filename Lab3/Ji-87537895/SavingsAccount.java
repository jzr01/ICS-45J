package labs.lab1;

/**
 * A savings account has a balance that can be changed by deposits,
 * withdrawals, and interest, and also keeps track of the number of
 * transactions
 */
public class SavingsAccount {

	private double balance;
	private double interestRate;
	private int numTransactions;

	/**
	 * Constructs a savings account with a zero balance and zero percent interest rate
	 */
	public SavingsAccount() {
		this.balance = 0;
		this.interestRate = 0;
	}


	/**
	 * Constructs a savings account with a given balance
	 * 
	 * @param initialBalance the initial balance (assume it will be >= 0)
	 * @param rate           the interest rate in percent (assume it will be >= 0)
	 */
	public SavingsAccount(double initialBalance, double rate) {
		this.balance = initialBalance;
		this.interestRate = rate;
	}


	/**
	 * Deposits money into the savings account.
	 * 
	 * @param amount the amount to deposit (assume it will be > 0)
	 */
	public void deposit(double amount) {
		this.balance += amount;
		this.numTransactions += 1;
	}


	/**
	 * Withdraws money from the savings account.
	 * 
	 * @param amount the amount to withdraw (assume it will be > 0)
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
		this.numTransactions += 1;
	}


	/**
	 * Gets the current balance of the savings account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	
	/**
	 * Gets the total number of transactions (deposits and withdrawals)
	 * that have occurred
	 * 
	 * @return	the number of transactions
	 */
	public int getNumTransactions() {
		return this.numTransactions;
	}


	/**
	 * Adds interest to the savings account.
	 */
	public void addInterest() {
		this.balance += this.balance*this.interestRate/100;
	}
}