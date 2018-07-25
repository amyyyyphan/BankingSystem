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
	
	//sets a new name
	public void setName(String newName) {
		this.name = newName;
	}
	
	//returns the User's name
	public String getName() {
		return name;
	}
	
	//returns the User's username
	public String getUsername() {
		return username;
	}

	//spends money from one of the User's accounts
	public void spend(int accID, double amount, String type) {
		int accIndex = getAccountIndex(accID);
		Account account = accounts.get(accIndex);
		if (amount > account.getBalance()) {
			System.out.println("You do not have enough money.");
		}
		else {
			account.withdraw(amount, type);
		}
		
	}
	
	//adds a Checkings/Savings account if the User doesn't already have 5 accounts
	public void addAccount(Account newAccount) {
		if (accounts.size() < 5) {
			accounts.add(newAccount);
			System.out.println(newAccount.getAccType() + " account successfully created.");

		}
		else {
			System.out.println("You can only have five accounts.");
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
	public int getAccountIndex(int accID) {
		int index = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accID) {
				index = i;
			}
		}
		return index;
	}
	
	//deposits an amount of money to the account that has the given account ID
	public void depositToAccount(int accountID, double amount) {
		int index = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accountID) {
				index = i;
			}
		}
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
			System.out.println("    Balance: " + account.getBalance());
			System.out.println("    Type: " + account.getAccType());
			System.out.println("");
		}
	}
	
	public void receive(int accID, double amount) {
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		account.deposit(amount, "Transfer");
	}
}
