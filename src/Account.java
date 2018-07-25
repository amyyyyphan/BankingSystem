import java.util.ArrayList;
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
	public void deposit(double amount) {
		balance += amount;
		if (transactions.size() < 10) {
			Transaction newTransaction = new Transaction(transactionCount, amount, "Deposit");
			transactionCount++;
			transactions.add(newTransaction);
		}
		else {
			transactions.remove(0);
			Transaction newTransaction = new Transaction(transactionCount, amount, "Deposit");
			transactionCount++;
			transactions.add(newTransaction);
		}
	}
	
	public int getAccID() {
		return accID;
	}
}
