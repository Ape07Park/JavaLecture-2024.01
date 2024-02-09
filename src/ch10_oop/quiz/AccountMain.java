package ch10_oop.quiz;

import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		System.out.println("입금할 가격 입력");
		Scanner scan= new Scanner(System.in);
		int balance = scan.nextInt();
		scan.close();
		// 세터 매개값 음수거나 백만원 넘으면 balance 값 유지
		
		// 여기서 매개값 제어 
		if (balance > 1000000 ||  balance < 0) {
			System.out.println("다시 입력(0 ~ 1,000,000 금액으로");
		}
		
		// 입력값 + balance
		account.setBalance(balance);
		
		System.out.println(account.getBalance() + "원 입금 완료");
		
		account.chcek();
		
		
		

	}

}
