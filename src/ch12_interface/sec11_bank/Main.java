package ch12_interface.sec11_bank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AccountServiceImpl ac = new AccountServiceImpl();
		
		Account[] accountArray = new Account[100];
		Scanner scan = new Scanner(System.in);

		boolean run = true;
		accountArray[0] = new Account("1000", "제임스", 10000);
		accountArray[1] = new Account("1001", "마리", 300000);
		accountArray[2] = new Account("1002", "브라이언", 200000);
		
		while (run) {
			System.out.println("+===========+=============+=========+=========+=======+");
			System.out.println(" 1 계좌 생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("+===========+=============+=========+=========+=======+");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scan.nextLine());
			switch (selectNo) {
			case 1:
				ac.createAccount(accountArray);
				break;

			case 2:
				ac.accountList(accountArray);
				break;

			case 3:
				ac.deposit(accountArray);
				break;

			case 4:
				ac.withdraw(accountArray);
				break;

			case 5:
				run = false;
				break;
			default:
				System.out.println("Warning 1 ~ 5사이의 숫자만 입력");
			}

		}
	}

}
