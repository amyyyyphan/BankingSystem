import java.util.*;

public class Tester{
	
	public static void main(String[] args) {
		//Bank bank = new Bank();
		Account acc1 = new Account(1, "S");
		acc1.deposit(90, "D");
		Account acc2 = new Account(1, "S");
		acc2.deposit(100, "D");		
		Account acc3 = new Account(1, "S");
		acc3.deposit(70, "D");
		
		ArrayList<Account> list = new ArrayList<Account>();
		list.add(acc1);
		list.add(acc2);
		list.add(acc3);
		
		Collections.sort(list);

		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j).getBalance());
		}
		
	}
	
}
