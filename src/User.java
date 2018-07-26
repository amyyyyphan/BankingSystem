import java.util.ArrayList;

public class User{
	private String name;
	private String username;
	private String password;
	private int userID;
	private ArrayList<Account> accounts;
	
	//constructor
	public User(String name, String username, String password, int userID) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.userID = userID;
		accounts = new ArrayList<Account>();
	}
	
	//sets a new password
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	//returns the User's password
	public String getPassword() {
		return password;
	}
	
	//returns the User's name
	public String getName() {
		return name;
	}
	
	//returns the User's username
	public String getUsername() {
		return username;
	}

	//spends money from the User's account with the given ID
	public void spend(int accID, double amount, String type) {
		int accIndex = getAccountIndex(accID);
		Account account = accounts.get(accIndex);
		if (amount > account.getBalance()) {
			System.out.println("You do not have enough money.");
		}
		else {
			account.withdraw(amount, type);
			if (type.equals("Transfer")) {
				System.out.println("Transfer completed.");
			}
		}
		
	}
	
	//adds a Checkings/Savings account if the User doesn't already have 5 accounts
	public void addAccount(Account newAccount) {
		if (accounts.size() < 5) {
			accounts.add(newAccount);
			System.out.println(newAccount.getAccType() + " account successfully created.");
		}
	}
	
	//search if the account is under the User
	public boolean accountExistsUnderUser(int accountID) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accountID) {
				return true;
			}
		}
		return false;
	}
	
	//removes a Checkings/Savings account
	public void removeAccount(int accountID) {
		int index = getAccountIndex(accountID);
		accounts.remove(index);
	}
	
	//returns the index of the account in the arraylist that has the given account ID
	private int getAccountIndex(int accID) {
		int index = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accID) {
				index = i;
			}
		}
		return index;
	}
	
	//deposits an amount of money to the Account with the given ID
	public void depositToAccount(int accountID, double amount) {
		int index = getAccountIndex(accountID);
		Account account = accounts.get(index);
		account.deposit(amount, "Deposit");
	}
	
	//prints all of the User's Checkings/Savings account information
	public void printAllAccountsInfo() {
		if (accounts.size() == 0) {
			System.out.println("You do not have any accounts.");
		}
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			System.out.println("Account ID: " + account.getAccID());
			System.out.println("Balance: " + account.getBalance());
			System.out.println("Type: " + account.getAccType());
			System.out.println("");
		}
	}
	
	//prints the information and transactions of the Account with the given ID
	public void printAccountInfo(int accID) {
		int accIndex = getAccountIndex(accID);
		Account account = accounts.get(accIndex);
		account.printTransactionLog();
	}
	
	//prints the information and transactions of a certain type of the Account with the given ID
	public void printAccountInfo(int accID, String type) {
		int accIndex = getAccountIndex(accID);
		Account account = accounts.get(accIndex);
		account.printTransactionLog(type);
	}
	
	//receives the money that was transfered to the Account with the given ID
	public void receive(int accID, double amount) {
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		account.deposit(amount, "Transfer");
	}
	
	//checks if the User already has 5 accounts
	public boolean hasFiveAccounts() {
		if (accounts.size() == 5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//checks if the User has enough money in the account with the given ID for the transfer
	public boolean hasEnough(int accID, double amount) {
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		if (account.getBalance() >= amount) {
			return true;
		}
		else {
			return false;
		}
	}
}
