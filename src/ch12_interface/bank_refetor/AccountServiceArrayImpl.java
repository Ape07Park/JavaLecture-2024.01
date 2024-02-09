package ch12_interface.bank_refetor;

import java.util.Scanner;

public class AccountServiceArrayImpl implements AccountService {
	
	private static Account[] accountArray = new Account[100]; // 원래 main에 있던 것인데 가져옴
	private static Scanner scan = new Scanner(System.in);
	private static int index = 3;
	
	public void AccountServiceArrayImpl() {
		accountArray[0] = new Account("1000", "제임스", 10000);
		accountArray[1] = new Account("1001", "마리", 300000);
		accountArray[2] = new Account("1002", "브라이언", 200000);
	}
	
	@Override
	public void createAccount() {
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
	public void accountList() {
		System.out.println("----------");
		System.out.println("계좌 목록");
		System.out.println("----------");
		
		for (int i = 0; i < index; i++) {
			
			Account acc = accountArray[i];
			
			// 1이면 안보이게 함 
			if(acc.getIsDeleted() == AccountService.DELETED) {
				continue;
			}
			System.out.printf("%s %-6s\t%,10d%n", acc.getAno(), acc.getOwner(), acc.getBalance());
			// %6s: 6칸 할당, %10d, 필드 폭을 10칸 확보하고 오른쪽 정렬해서 출력

		}
	}

	@Override
	public void deposit() {
		System.out.println("----------");
		System.out.println("계좌 입금");
		System.out.println("----------");
		System.out.print("계좌번호 > ");
		
		String ano = scan.nextLine();
		System.out.print("입급액> ");
		int balance = Integer.parseInt(scan.nextLine());
		Account account = findAccount(ano);
		
		if (account == null) {
			System.out.println("계좌번호 체크");
			return;
		}
		account.setBalance(balance + account.getBalance());
		System.out.println("입금 완료");
		
	}

	@Override
	public void withdraw() {
		 
			System.out.println("----------");
			System.out.println("계좌 출금");
			System.out.println("----------");
			
			System.out.print("계좌번호 > ");
			String ano = scan.nextLine();
			System.out.print("입급액> ");
			int balance = Integer.parseInt(scan.nextLine());
			Account account = findAccount(ano);
			
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
	public Account findAccount(String ano) {
		for (Account acc: accountArray) {
			if (acc == null)
				return null;
			if (ano.equals(acc.getAno()) && acc.getIsDeleted() != AccountService.DELETED)
				return acc;
		}
		return null;
		}

	@Override
	public void delete() {
		System.out.println("----------");
		System.out.println("계좌 삭제");
		System.out.println("----------");
		
		System.out.print("계좌번호 > ");
		String ano = scan.nextLine();
		Account account = findAccount(ano);
		
		account.setIsDeleted(AccountService.DELETED);
		
	}

}
