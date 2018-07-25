import java.util.ArrayList;
import java.util.Scanner;

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
		setPassword(password);
		this.userID = userID;
		accounts = new ArrayList<Account>();
	}
	
	//sets a new password
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	//returns the User's username
	public String getUsername() {
		return username;
	}
	
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
	
	public void addAccount(Account newAccount) {
		if (accounts.size() < 5) {
			accounts.add(newAccount);
			System.out.println(newAccount.getAccType() + " account successfully created.");

		}
		else {
			System.out.println("You can only have five accounts.");
		}
	}
	
	//search if the account is under the user
	public boolean accountExists(int accountID) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accountID) {
				return true;
			}
		}
		return false;
	}
	
	//removes Checkings/Savings account
	public void removeAccount(int accountID) {
		int index = getAccountIndex(accountID);
		accounts.remove(index);
	}
	
	//returns index of the account with given ID
	public int getAccountIndex(int accID) {
		int index = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accID) {
				index = i;
			}
		}
		return index;
	}
	
	//deposits money to an account
	public void depositToAccount(int accountID, double amount) {
		int index = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccID() == accountID) {
				index = i;
			}
		}
		Account account = accounts.get(index);
		account.deposit(amount);
	}
	
}
