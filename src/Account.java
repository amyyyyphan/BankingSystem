import java.util.ArrayList;
import java.time.LocalTime;

public class Account {
	
	private int accID;
	private double balance;
	private String accType;
	private ArrayList<Transaction> transactions;
	private int transactionCount;
	
	public Account(int accID, String accType) {
		this.accID = accID;
		this.balance = 0;
		this.accType = accType;
		this.transactions = new ArrayList<Transaction>();
		transactionCount = 0;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount, String type) {
		balance += amount;
		LocalTime time = java.time.LocalTime.now();
		if (transactions.size() < 10) {
			Transaction newTransaction = new Transaction(transactionCount, amount, type, time);
			transactionCount++;
			transactions.add(newTransaction);
		}
		else {
			transactions.remove(0);
			Transaction newTransaction = new Transaction(transactionCount, amount, type, time);
			transactionCount++;
			transactions.add(newTransaction);
		}
	}
	
	public void withdraw(double amount, String type) {
		balance -= amount;
		LocalTime time = java.time.LocalTime.now();
		if (transactions.size() < 10) {
			Transaction newTransaction = new Transaction(transactionCount, -amount, type, time);
			transactionCount++;
			transactions.add(newTransaction);
		}
		else {
			transactions.remove(0);
			Transaction newTransaction = new Transaction(transactionCount, -amount, type, time);
			transactionCount++;
			transactions.add(newTransaction);
		}
	}
	
	public int getAccID() {
		return accID;
	}
	
	public String getAccType() {
		return accType;
	}
}
