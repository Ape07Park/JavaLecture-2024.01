package ch04_control;

import java.util.Scanner;

public class Ex02_Leapyear {

	public static void main(String[] args) {
		System.out.println("연도 입력 >");
		Scanner scan = new Scanner(System.in);
		String inputStr = scan.nextLine();
		int year = Integer.parseInt(inputStr);
		scan.close();
		// 4로 나누어지면 윤년, 100으로 나누어지면 평년, 400으로 나누어지면 윤년
		
		if(year % 400 == 0) {
			System.out.println("윤년");
		}else if(year % 100 == 0) {
			System.out.println("평년");
		}else if(year % 4 == 0) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
		// 코드 개선 - Refactoring
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
	}

}
