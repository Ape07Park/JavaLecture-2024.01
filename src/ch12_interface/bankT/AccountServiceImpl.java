package ch12_interface.bankT;

import java.util.Scanner;

public class AccountServiceImpl implements AccountService{
	private static int index = 3;
	private static Scanner scan = new Scanner(System.in);
	
	@Override
	public void createAccount(Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌 생성");
		System.out.println("----------");
		
		String ano = "" + (1000 + index); // index: 현재 account array 중 빈 곳. index를 문자열로 봐꿈
//		System.out.println("계좌 번호 > ");
//		

		System.out.print("계좌주 이름> ");
		String owner = scan.nextLine();
		System.out.print("최초 입급액> ");
		int balance = Integer.parseInt(scan.nextLine());
		Account account = new Account(ano, owner, balance);
		
		accountArray[index++] = account;
		

	}

	@Override
	public void accountList(Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌 목록");
		System.out.println("----------");
		
		for (int i = 0; i < index; i++) {
			Account acc = accountArray[i];
			System.out.printf("%s %-6s\t%,10d%n", acc.getAno(), acc.getOwner(), acc.getBalance());
			// %6s: 6칸 할당, %10d, 필드 폭을 10칸 확보하고 오른쪽 정렬해서 출력

		}
	}

	@Override
	public void deposit(Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌 입금");
		System.out.println("----------");
		System.out.print("계좌번호 > ");
		
		String ano = scan.nextLine();
		System.out.print("입급액> ");
		int balance = Integer.parseInt(scan.nextLine());
		Account account = findAccount(ano, accountArray );
		
		if (account == null) {
			System.out.println("계좌번호 체크");
			return;
		}
		account.setBalance(balance + account.getBalance());
		System.out.println("입금 완료");
	}

	@Override
	public void withdraw(Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌 출금");
		System.out.println("----------");
		
		System.out.print("계좌번호 > ");
		String ano = scan.nextLine();
		System.out.print("입급액> ");
		int balance = Integer.parseInt(scan.nextLine());
		Account account = findAccount(ano, accountArray);
		
		if (account == null) {
			System.out.println("계좌번호 체크");
			return;
		}
		if (account.getBalance() >= balance) {
			account.setBalance((account.getBalance() - balance));
			System.out.println("입금 완료");
		}else {
			System.out.println("잔액 부족");
		}

	}

	@Override
	public Account findAccount(String ano, Account[] accountArray) {
		for (Account acc: accountArray) {
			if (acc == null)
				return null;
			if (ano.equals(acc.getAno()))
				return acc;
		}
		return null;
	}

}
