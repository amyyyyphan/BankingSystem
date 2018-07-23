import java.util.*;

public class Bank {
	private ArrayList<User> users;
	private int userCount;
	public int accountCount;
	
	public Bank() {
		this.users = new ArrayList<User>();
		this.userCount = 0;
		this.accountCount = 0;
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
		System.out.print("Choose a name: ");
		String name = scan.next();
		System.out.print("Choose a password: ");
		String password = scan.next();
		User user = new User(name, password, userCount);
		users.add(user);
		userCount++;
		System.out.println("Your User ID is: " + user.getUserID());
		users.add(user);
		System.out.println("You've set up an account.");
		showHomepage(user);
	}
	
	//shows login page
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("                    Login                     ");
		System.out.println("==============================================");
		System.out.print("Enter your User ID: ");
		if (!scan.hasNextInt()) {
			System.out.println("Invalid User ID.");
			login();
		}
		int userID = scan.nextInt();
		System.out.print("Enter your password: ");
		String password = scan.next();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID() == userID) {
				if (password.equals(users.get(i).getPassword())) {
					showHomepage(users.get(i));
				}
				else {
					System.out.println("User ID or password is incorrect.");
					login();
				}
			}
		}
		System.out.println("User ID or password is incorrect.");
		login();
	}
	
	//shows homepage
		public void showHomepage(User user) {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("");
			System.out.println("==============================================");
			System.out.println("                   Homepage                   ");
			System.out.println("==============================================");
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
				
			}
			else if (choice.equals("3")) {
				
			}
			else if (choice.equals("4")) {
				
			}
			else if (choice.equals("5")) {
				
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
			System.out.println("You've created a " + accountType + " account.");
			showHomepage(user);
		}
}