import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Account{
	
	private int accID;
	private double balance;
	private String accType;
	private ArrayList<Transaction> transactions;
	private int transactionCount;

	//constructor
	public Account(int accID, String accType) {
		this.accID = accID;
		this.balance = 0;
		this.accType = accType;
		this.transactions = new ArrayList<Transaction>();
		transactionCount = 0;
	}
	
	//gets the current balance of the Account
	public double getBalance() {
		return balance;
	}
	
	//deposits money into the account
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
	
	//withdraws money from the Account
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
	
	//prints transaction log and creates a txt file of the log
	public void printTransactionLog() {
		System.out.println("");
		System.out.println("Account ID: " + getAccID());
		System.out.println("Balance: " + getBalance());
		System.out.println("Type: " + getAccType());
		System.out.println("");
		System.out.println("                 Transactions                 ");
		System.out.println("                ==============                ");
		if (transactions.size() == 0) {
			System.out.println("No transactions.");
		}
		for (int i = 0; i < transactions.size(); i++) {
			Transaction transaction = transactions.get(i);
			System.out.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());
		}
		
		try {
			File file = new File("TransLog.txt");
			if (!file.exists()){
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("");
			writer.println("Account ID: " + getAccID());
			writer.println("Balance: " + getBalance());
			writer.println("Type: " + getAccType());
			writer.println("");
			writer.println("                 Transactions                 ");
			writer.println("                ==============                ");
			if (transactions.size() == 0) {
				writer.println("No transactions.");
			}
			for (int i = 0; i < transactions.size(); i++) {
				Transaction transaction = transactions.get(i);
				writer.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());
			}
			writer.close();
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void printTransactionLog(String type) {
		System.out.println("");
		System.out.println("Account ID: " + getAccID());
		System.out.println("Balance: " + getBalance());
		System.out.println("Type: " + getAccType());
		System.out.println("");
		System.out.println("                 Transactions                 ");
		System.out.println("                ==============                ");
		if (transactions.size() == 0) {
			System.out.println("No transactions.");
		}
		boolean hasType = false;
		for (int i = 0; i < transactions.size(); i++) {
			Transaction transaction = transactions.get(i);
			if (transaction.getType().equals(type)) {
				System.out.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());
				hasType = true;
			}
		}
		if (!hasType) {
			System.out.println("No transaction of this type.");
		}
		
		try {
			String fileName = "TransLog_" + type + "_.txt";
			File file = new File(fileName);
			if (!file.exists()){
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("");
			writer.println("Account ID: " + getAccID());
			writer.println("Balance: " + getBalance());
			writer.println("Type: " + getAccType());
			writer.println("");
			writer.println("                 Transactions                 ");
			writer.println("                ==============                ");
			if (transactions.size() == 0) {
				writer.println("No transactions.");
			}
			for (int i = 0; i < transactions.size(); i++) {
				Transaction transaction = transactions.get(i);
				if (transaction.getType().equals(type)) {
					writer.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());
				}
			}
			if (!hasType) {
				writer.println("No transaction of this type.");
			}
			writer.close();
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	//returns the Account ID
	public int getAccID() {
		return accID;
	}
	
	//returns the type of the Account
	public String getAccType() {
		return accType;
	}
}
