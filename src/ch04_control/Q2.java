package ch04_control;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		switch(score/10) {
		case 10: // 주의할 것
		case 9:
			System.out.println('A');
			break;
			
		case 8:
			System.out.println('B');
			break;
			
		case 7:
			System.out.println('C');
			break;
		
		default:
			System.out.println('D');
		
		
		}
		
		
			
		

	}

}
