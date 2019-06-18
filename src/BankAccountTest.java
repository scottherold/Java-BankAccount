import com.sherold.accounts.*;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		
		System.out.println(b1.getAccountNumber());
		System.out.println(BankAccount.getAccountsCountTotal());
		
		b1.deposit("checking", 100.50);
		System.out.println(BankAccount.getAccountsMoneyTotal());
		
		BankAccount b2 = new BankAccount();
		b1.deposit("savings", 50);
		b1.deposit("account", 100);
		
		System.out.println(BankAccount.getAccountsCountTotal());
		b2.deposit("checking",500.25);
		
		System.out.println(BankAccount.getAccountsMoneyTotal());
		b1.accountsTotal();
		
		b1.withdraw("checking", 50);
		System.out.println(b1.accountsTotal());
		System.out.println(BankAccount.getAccountsMoneyTotal());
		
		b1.withdraw("savings", 1000);
	}

}
