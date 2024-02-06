package ch10_oop.quiz;

import java.util.Scanner;

public class BankApplicationMain {
	private static Account2[] accountsArray = new Account2[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("--------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("________________________________");
			System.out.println("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
//				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}

		System.out.println("프로그램 종료");
	}
	// 계좌생성
	private static void createAccount() {
		// 처음 누르면 홍길동 두 번째면 강자바  
		
		System.out.println("----------------");
		System.out.println("계좌생성");
		System.out.println("----------------");
		
		System.out.println("계좌번호");
		String ano0 = scanner.nextLine();
		accountsArray[0].setAno(ano0);
		
		System.out.println("계좌주");
		String owner0 = scanner.nextLine();
		accountsArray[0].setOwner(owner0);
		
		System.out.println("초기입금액");
		int money0 = scanner.nextInt();
		accountsArray[0].setBalance(money0);
		
		System.out.println("계좌번호");
		String ano1 = scanner.nextLine();
		accountsArray[1].setAno(ano1);
		
		System.out.println("계좌주");
		String owner1 = scanner.nextLine();
		accountsArray[1].setOwner(owner1);
		
		System.out.println("초기입금액");
		int money1 = scanner.nextInt();
		accountsArray[1].setBalance(money1);
		
	}
	
	// 계좌목록 보기 
	private static void AccountList() {
		
		
		System.out.println("----------------");
		System.out.println("계좌목록");
		System.out.println("----------------");
		System.out.println(accountsArray[0].getAno() + accountsArray[0].getOwner() + accountsArray[0].getBalance());
		System.out.println(accountsArray[1].getAno() + accountsArray[1].getOwner() + accountsArray[1].getBalance());
	}
	
	// 예금
	private static void deposit() {
		
		System.out.println("----------------");
		System.out.println("예금");
		System.out.println("----------------");
		
		System.out.println("계좌번호:");
		String aNum = scanner.nextLine();
		
		System.out.println("예금액: ");
		int money = scanner.nextInt();
		
		System.out.println("예금 성공");
	}
	
	// 출금
	private static void withdraw() {
		System.out.println("----------------");
		System.out.println("출금");
		System.out.println("----------------");
		
		System.out.println("계좌번호:");
		String aNum = scanner.nextLine();
		
		System.out.println("출금액: ");
		int money = scanner.nextInt();
		
		System.out.println("출금 성공");
	}
	
//    private static Account2 findAccount(String ano) {
//    	if(ano == "111-111")
//    accountsArray[0] = new Account2("111-111", "홍길동", 10000);
//	accountsArray[1] = new Account2("111-222", "강자바", 20000);
//
//	System.out.println("----------------");
//	System.out.println("계좌목록");
//	System.out.println("----------------");
//	System.out.println(accountsArray[0].getAno() + accountsArray[0].getOwner() + accountsArray[0].getBalance());
//	System.out.println(accountsArray[1].getAno() + accountsArray[1].getOwner() + accountsArray[1].getBalance());
//	
//	}
	
	
	
	
	
}
