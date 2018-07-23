import java.util.ArrayList;
public class Account {
	
	private int accID;
	private double balance;
	private String accType;
	private ArrayList<String> transactions;
	
	public Account(int accID, String accType) {
		this.accID = accID;
		this.balance = 0;
		this.accType = accType;
		this.transactions = new ArrayList<String>();
	}
}
