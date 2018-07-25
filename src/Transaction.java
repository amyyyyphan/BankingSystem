import java.time.LocalTime;

public class Transaction{
	private int transactionID;
	private double amount;
	private String type;
	private LocalTime time;
	
	//constructor
	public Transaction(int transactionID, double amount, String type) {
		this.transactionID = transactionID;
		this.amount = amount;
		this.type = type;
		this.time = java.time.LocalTime.now();
	}
	
	//returns the time of the transaction
	public LocalTime getTime() {
		return time;
	}
	
	//returns the type of the transaction
	public String getType() {
		return type;
	}
	
	//returns the amount of the transaction
	public double getAmount() {
		return amount;
	}
	
	//compare method
}
