package ch10_oop.quiz;

// MIN_BALANCE 0 ~  MAX_BALANCE 100만원 
// balance 값의 범위 제한 

public class Account {
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	private int balance;
	
	public void chcek() {
		if (balance > MAX_BALANCE || balance < MIN_BALANCE ) {
			System.out.println("계좌 확인할 것");
		}else {
			System.out.println("문제 X");
		}
	}
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int addBalance) {
		
		this.balance = balance + addBalance ;
	} 
	
	
}


