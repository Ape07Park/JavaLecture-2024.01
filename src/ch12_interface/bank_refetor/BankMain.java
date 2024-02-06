package ch12_interface.bank_refetor;

import java.util.Scanner;

public class BankMain {
	private static Scanner scan = new Scanner(System.in);
	
//  private static AccountService accountService = new AccountServiceFileImpl();
//	private static AccountService accountService = new AccountServiceMySQLImpl();
	
	private static AccountService accountService = new AccountServiceArrayImpl();
	
// 스프링 부트: @Autowired private static AccountService accountService;	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		
		
		while (run) {
			System.out.println("+===========+=============+=========+=========+=======+============+");
			System.out.println(" 1 계좌 생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 삭제 | 6. 종료");
			System.out.println("+===========+=============+=========+=========+=======+============+");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scan.nextLine());
			switch (selectNo) {
			case 1:
				accountService.createAccount();
				break;

			case 2:
				accountService.accountList();
				break;

			case 3:
				accountService.deposit();
				break;

			case 4:
				accountService.withdraw();
				break;
			
			case 5:
				accountService.delete();
				break;

			case 6:
				run = false;
				break;
			default:
				System.out.println("Warning 1 ~ 5사이의 숫자만 입력");
			
			}
		
		}
		System.out.println("종료");
	}
			
}
