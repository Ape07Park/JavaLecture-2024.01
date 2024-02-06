package ch12_interface.bank_refetor;

public interface AccountService {
	int DELETED = 1; // public static final 생략됨
	
		void createAccount(); // public abstract 생략됨
		
		void accountList();
		
		void deposit();
		
		void withdraw();

		void delete();
		
		Account findAccount(String ano);
		
}
