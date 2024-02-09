package ch12_interface.bank_refetor;

public class Account {
	private String ano;
	private String owner;
	private int balance;
	private int isDeleted;  // 1이면 없는 것이니 1만 안보이게
	
	// 생성되면 0으로 초기화 됨 따라서 제임스 등에 인자 추가 x 
	
	
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	
	
	
	public Account(String ano, String owner, int balance, int isDeleted) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.isDeleted = isDeleted;
	}



	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
	
	
	
	


