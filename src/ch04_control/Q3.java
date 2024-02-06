package ch04_control;

public class Q3 {

	public static void main(String[] args) {
		for(int i = 0; ; i++) {
			if(i > 10) {
				break;
			}
			
			if(i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
		
		for(int i = 0; i <=10; i+=2) {
			System.out.println(i);
		}

	}

}
