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
		if (username.equals("")) {
			System.out.println("Please enter a valid username.");
			signUp();
		}
		else if (username.contains(" ")) {
			System.out.println("Username cannot contain spaces.");
			signUp();
		}
		else if (usernameAlreadyExists(username)) {
			System.out.println("Username is already taken.");
			signUp();
		}
		else {
			System.out.print("Choose a password: ");
			String password = scan.nextLine();
			if (password.equals("")) {
				System.out.println("Please enter a valid password.");
				signUp();
			}
			else {
				User user = new User(name, username, password, userCount);
				users.add(user);
				userCount++;
				System.out.println("Bank account successfully created.");
				showHomepage(user);
				
			}
			
		}
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
		else{
			System.out.print("Enter your password: ");
			String password = scan.nextLine();
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUsername().equals(username)) {
					if (password.equals(users.get(i).getPassword())) {
						showHomepage(users.get(i));
					}
				}
			}
			System.out.println("Username or password is incorrect.");
			login();
		}
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
		
		switch (choice) {
		case "1":
			showCreateAnAccountPage(user);
			break;
		case "2":
			deleteAnAccountPage(user);
			break;
		case "3":
			showTransferToAnotherAccountPage(user);
			break;
		case "4":
			showDepositPage(user);
			break;
		case "5":
			showWithdrawPage(user);
			break;
		case "6":
			
		case "7":
			showAccountsPage(user);
			break;
		case "8":
			
		case "9":
			System.out.println("You have logged out.");
			showLoginScreen();
			break;
		case "10":
			System.out.println("Exitted program");
			System.exit(0);
			break;
		default:
			System.out.println("Please choose an option between 1 and 10.");
			showHomepage(user);
			break;
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
			createAccount("Savings", user);
		}
		else if (accountType.equals("2")) {
			createAccount("Checkings", user);
		}
		else {
			System.out.println("Please choose an option between 1 and 2.");
			showCreateAnAccountPage(user);
		}

	}
	
	private void createAccount(String type, User user) {
		Account account = new Account(accountCount, type);
		System.out.println("The account ID is: " + accountCount);
		accountCount++;
		user.addAccount(account);
		showHomepage(user);
	}
	
	//show Delete a Checkings/Savings Account page
	public void deleteAnAccountPage(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("              Delete an Account               ");
		System.out.println("==============================================");
		System.out.print("Enter the ID of the account you would like to delete: ");
		if (!scan.hasNextInt()) {
			System.out.println("Invalid Account ID.");
			deleteAnAccountPage(user);
		}
		int accID = scan.nextInt();
		if (user.accountExistsUnderUser(accID)) {
			user.removeAccount(accID);
			System.out.println("Account successfully deleted.");
			//????
		}
		else {
			System.out.println("Account does not exist.");
		}
		showHomepage(user);
	}
	
	public void showTransferToAnotherAccountPage(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                   Transfer                   ");
		System.out.println("==============================================");
		System.out.println("Enter the amount you would like to transfer: ");
		if (!scan.hasNextDouble()) {
			System.out.println("Invalid amount.");
			showTransferToAnotherAccountPage(user);
		}
		double amount = scan.nextDouble();
		System.out.println("Enter the ID of the account you would like to transfer money to: ");
		if (!scan.hasNextInt()) {
			System.out.println("Invalid Account ID.");
			showTransferToAnotherAccountPage(user);
		}
		int recipientAccID = scan.nextInt();
		if (accountExists(recipientAccID)) {
			System.out.println("Enter the ID of the account you would like to withdraw the money from: ");
			if (!scan.hasNextInt()) {
				System.out.println("Invaid Account ID.");
				showTransferToAnotherAccountPage(user);
			}
			int senderAccID = scan.nextInt();
			if (user.accountExistsUnderUser(senderAccID)) {
				user.spend(senderAccID, amount, "Transfer");
				User recipient = findRecipient(recipientAccID);
				recipient.receive(recipientAccID, amount);
				System.out.println("Transfer completed.");
			}
			else {
				System.out.println("Account does not exist.");
			}
		}
		showHomepage(user);
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
		if (user.accountExistsUnderUser(accID)) {
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
		if (user.accountExistsUnderUser(accID)) {
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
	
	//show Accounts page
	public void showAccountsPage(User user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                   Accounts                   ");
		System.out.println("==============================================");
		user.printAllAccountsInfo();
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
	
	public boolean accountExists(int accID) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.accountExistsUnderUser(accID)) {
				return true;
			}
		}
		return false;
	}
	
	public User findRecipient(int accID) {
		User recipient = null;
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.accountExistsUnderUser(accID)) {
				recipient = user;
			}
		}
		return recipient;
	}
}