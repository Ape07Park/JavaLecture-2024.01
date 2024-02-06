package ch12_interface.bankT;

public interface AccountService {
	
		void createAccount(Account[] accountArray);
		
		void accountList(Account[] accountArray);
		
		void deposit(Account[] accountArray);
		
		void withdraw(Account[] accountArray);
		
		Account findAccount(String ano, Account[] accountArray);
		
}
