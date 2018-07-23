import java.util.ArrayList;
import java.util.Scanner;

public class User{
	private String name;
	private String password;
	private int userID;
	private ArrayList<Account> accounts;
	
	public User(String name, String password, int userID) {
		this.name = name;
		setPassword(password);
		this.userID = userID;
		accounts = new ArrayList<Account>();
	}
	
	public int getUserID() {
		return userID;
	}
	
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
	
	//spend method
	
	public void addAccount(Account newAccount) {
		if (accounts.size() < 5) {
			accounts.add(newAccount);
		}
		else {
			System.out.println("You can only have five accounts.");
		}
	}
}
