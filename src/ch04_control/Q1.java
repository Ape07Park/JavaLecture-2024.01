package ch04_control;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		
		if(score >= 90) {
			System.out.println("A");
		}
		
		else if(score >= 80) {
			System.out.println("B");
		}
		
		else if(score >= 70) {
			System.out.println("C");
		}
		
		else {
			System.out.println("D");
		}

	}

}
