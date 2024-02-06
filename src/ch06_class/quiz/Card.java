package ch06_class.quiz;

public class Card {
	private int cash;
	private int age;
	
	public int charge(int money) {
		cash = cash + money;
		return cash;
	}
	
	public int getCash(int money) {
		return money;
	}
	
	public boolean ride(int cash, int age) {
		if(age >= 19 && cash >= 1450 ) {
			return true;
		}else if(age >= 19 && cash < 1450){
			return false;
		}else if(age >= 13 || age <= 18 && cash >= 1010) {
			return true;
		}else if(age >= 13 || age <= 18 && cash < 1010) {
			return false;
		}else if(age >= 7 || age <= 12 && cash >= 730) {
			return true;
		}else if(age >= 7 || age <= 12 && cash < 730) {
			return false;
		}
		return false;
	}
	
	public String toString() {
		return "7 <= age <= 12면 교통비 730원" + "\n" + "13 <= age <= 18면 교통비 1010" + "\n" + "age >= 19면 교통비 1450";
	}
	
	
	
	
}
