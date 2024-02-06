package ch04_control;

import java.util.Scanner;

public class Ex99 {

	public static void main(String[] args) {
		// 알람을 45분 먼저 울리게 한다
		/**
		 * 0 ≤ H ≤ 23, 0 ≤ M ≤ 59 경우의 수 1. m > 45/ h : m - 45
		 * 
		 * 2. m < 45/ h - 1 : m + 60 - 45 h -1 < 0 -> h - 1 = 23
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("시 및 분 입력");
		int h = scan.nextInt();
		int m = scan.nextInt();
		scan.close();

		// m < 45
		if (m < 45) {
			h -= 1;
			m = (m + 60) - 45;
			if (h < 0) {
				h = 23;
			}
		}

		else {
			m = m - 45;
		}

		// output
		System.out.println(h + ":" + m);
	}
}