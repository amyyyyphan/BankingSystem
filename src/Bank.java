import java.util.*;

public class Bank {
	private ArrayList<User> users;
	private int userCount;
	private int accountCount;
	
	
	public Bank() {
		this.users = new ArrayList<User>();
		this.userCount = 1;
		this.accountCount = 1;
		showLoginScreen();
	}
	
	//shows login screen
	public void showLoginScreen() {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("             Welcome to the Bank!             ");
		System.out.println("==============================================");
		System.out.println("1. Sign Up");
		System.out.println("2. Login");
		System.out.print("Choose an option: ");
		String choice = scan.next();
		if (choice.equals("1")) {
			signUp();
		}
		else if (choice.equals("2")) {
			login();
		}
		else {
			System.out.println("Please choose an option between 1 and 2.");
			showLoginScreen();
		}
	}
	
	//shows sign up page
	public void signUp() {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                    Sign Up                   ");
		System.out.println("==============================================");
		System.out.print("Enter your name: ");
		String name = scan.nextLine();
		System.out.print("Choose a username: ");
		String username = scan.nextLine();
		if (username.contains(" ")) {
			System.out.println("Username cannot contain spaces.");
			signUp();
		}
		else if (usernameAlreadyExists(username)) {
			System.out.println("Username is already taken.");
			signUp();
		}
		System.out.print("Choose a password: ");
		String password = scan.nextLine();
		User user = new User(name, username, password, userCount);
		users.add(user);
		userCount++;
		System.out.println("Bank account successfully created.");
		showHomepage(user);
	}
	
	//shows login page
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                    Login                     ");
		System.out.println("==============================================");
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		if (username.contains(" ")) {
			System.out.println("Invalid username.");
			login();
		}
		System.out.print("Enter your password: ");
		String password = scan.nextLine();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username)) {
				if (password.equals(users.get(i).getPassword())) {
					showHomepage(users.get(i));
				}
				else {
					System.out.println("Username or password is incorrect.");
					login();
				}
			}
		}
		System.out.println("Username or password is incorrect.");
		login();
	}
	
	//shows Homepage
	public void showHomepage(User user) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                   Homepage                   ");
		System.out.println("==============================================");
		System.out.println("Hello " + user.getName() + "!");
		System.out.println("1. Create an Account");
		System.out.println("2. Delete an Account");
		System.out.println("3. Transfer to another Account");
		System.out.println("4. Deposit");
		System.out.println("5. Withdraw");
		System.out.println("6. Show Account");
		System.out.println("7. Show All Accounts");
		System.out.println("8. Delete User");
		System.out.println("9. Logout");
		System.out.println("10. Quit");
		System.out.print("Choose an option: ");
		String choice = scan.next();
		
		if (choice.equals("1")) {
			showCreateAnAccountPage(user);
		}
		else if (choice.equals("2")) {
			deleteAnAccount(user);
		}
		else if (choice.equals("3")) {
			transferToAnotherAccountPage(user);
		}
		else if (choice.equals("4")) {
			showDepositPage(user);
		}
		else if (choice.equals("5")) {
			showWithdrawPage(user);
		}
		else if (choice.equals("6")) {
			
		}
		else if (choice.equals("7")) {
			
		}
		else if (choice.equals("8")) {
			
		}
		else if (choice.equals("9")) {
			System.out.println("You have logged out.");
			showLoginScreen();
		}
		else if (choice.equals("10")) {
			System.out.println("Exitted program");
			System.exit(0);
		}
		else {
			System.out.println("Please choose an option between 1 and 10.");
		}
	}
		
	//show Create an Account page
	public void showCreateAnAccountPage(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("              Create an Account               ");
		System.out.println("==============================================");
		System.out.println("1. Create a Savings Account");
		System.out.println("2. Create a Checkings Account");
		System.out.print("Choose an option: ");
		String accountType = scan.next();
		if (accountType.equals("1")) {
			accountType = "Savings";
		}
		else if (accountType.equals("2")) {
			accountType = "Checkings";
		}
		else {
			System.out.println("Please choose an option between 1 and 2.");
			showCreateAnAccountPage(user);
		}
		Account account = new Account(accountCount, accountType);
		System.out.println("The account ID is: " + accountCount);
		accountCount++;
		user.addAccount(account);
		showHomepage(user);
	}
	
	//show Delete a Checkings/Savings Account page
	public void deleteAnAccount(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("              Delete an Account               ");
		System.out.println("==============================================");
		System.out.println("Enter the ID of the account you would like to delete: ");
		if (!scan.hasNextInt()) {
			System.out.println("Invalid Account ID.");
			deleteAnAccount(user);
		}
		int accID = scan.nextInt();
		if (user.accountExists(accID)) {
			user.removeAccount(accID);
			System.out.println("Account successfully deleted.");
			
		}
		else {
			System.out.println("Account does not exist.");
		}
		showHomepage(user);
	}
	
	public void transferToAnotherAccountPage(User user) {
		
	}
	
	//show Deposit Page
	public void showDepositPage(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                   Deposit                    ");
		System.out.println("==============================================");
		System.out.print("Enter the ID of the account you would like to deposit money to: ");
		//if the account ID entered is not valid, show deposit page
		if (!scan.hasNextInt()) {
			System.out.println("Invalid Account ID.");
			showDepositPage(user);
		}
		int accID = scan.nextInt();
		if (user.accountExists(accID)) {
			System.out.print("Enter the amount you would like to deposit: ");
			if (!scan.hasNextDouble()) {
				System.out.println("Invalid amount.");
				showDepositPage(user);
			}
			else {
				double amount = scan.nextDouble();
				user.depositToAccount(accID, amount);
			}
		}
		else {
			System.out.println("Account does not exist.");
		}
		showHomepage(user);
	}
	
	//show Withdraw page
	public void showWithdrawPage(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                   Withdraw                   ");
		System.out.println("==============================================");
		System.out.print("Enter the ID of the account you would like to withdraw money from: ");
		if (!scan.hasNextInt()) {
			System.out.println("Invalid Account ID.");
			showWithdrawPage(user);
		}
		int accID = scan.nextInt();
		if (user.accountExists(accID)) {
			System.out.print("Enter the amount you would like to withdraw: ");
			if (!scan.hasNextDouble()) {
				System.out.println("Invalid amount.");
				showDepositPage(user);
			}
			double amount = scan.nextDouble();
			System.out.println("What type of transaction is this?");
			System.out.println("1. Food");
			System.out.println("2. Gas");
			System.out.println("3. Bills");
			System.out.println("4. Clothes");
			System.out.println("5. Withdrawal");
			System.out.println("6. Transfer");
			System.out.print("Choose an option: ");
			String choice = scan.next();
			if (choice.equals("1")) {
				choice = "Food";
			}
			else if (choice.equals("2")) {
				choice = "Gas";
			}
			else if (choice.equals("3")) {
				choice = "Bills";
			}
			else if (choice.equals("4")) {
				choice = "Clothes";
			}
			else if (choice.equals("5")) {
				choice = "Withdrawal";
			}
			else if (choice.equals("6")) {
				choice = "Transfer";
			}
			else {
				System.out.println("Please choose an option between 1 and 6.");
				showWithdrawPage(user);
			}
			user.spend(accID, amount, choice);
		}
		else {
			System.out.println("Account does not exist.");
		}
		showHomepage(user);
	}
	
	//checks if username already exists
	public boolean usernameAlreadyExists(String username) {
		boolean usernameExist = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username)) {
				usernameExist = true;
				break;
			}
		}
		return usernameExist;
	}
}