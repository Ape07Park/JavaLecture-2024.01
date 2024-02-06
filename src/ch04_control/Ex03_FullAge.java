package ch04_control;

import java.time.LocalDate;
import java.util.Scanner;


public class Ex03_FullAge {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("%d, %d, %d%n", year, month, day); // 2024, 1, 16
		System.out.print( year + "\n" +  month + "\n" + day); // 2024, 1, 16 한줄 한줄로 나옴
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("생년>");
		int bYear = Integer.parseInt(scan.nextLine());
		
		System.out.print("생월>");
		int bMonth = Integer.parseInt(scan.nextLine());
		
		System.out.print("생일>");
		int bDay = Integer.parseInt(scan.nextLine());
		
		// 1) 이번 년 - 생년: 나이   2) 이번 월 < 생월 : 나이  -1하는 경우 3) 이번 월 > 생월 : 나이 - 1  4) 이번 일 > 나이 -1
		int age = year - bYear;
		
		if(month < bMonth) {
			System.out.println(age - 1);
		}
		else if(month == bMonth && day < bDay) {
			System.out.println(age - 1);
		}else {
			System.out.println(age);
		}
		
		// Refactoring 
		int fullAge = year - bYear;
		if (month < bMonth || (month == bMonth && day < bDay)) {
			fullAge--;
		}
		System.out.println(fullAge);
		
		int age2 = (month < bMonth || (month == bMonth && day < bDay)) ? 
				year - bYear - 1: year - bYear;
		System.out.println(age2);
		
	}

}
