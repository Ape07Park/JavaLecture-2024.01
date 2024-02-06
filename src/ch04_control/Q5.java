package ch04_control;

public class Q5 {

	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 2) {
					continue;
				}
				if(j == 1) {
					break;
				}
				System.out.println('a');
				count++;
			}
		}
		System.out.println(count);
		

	}

}
