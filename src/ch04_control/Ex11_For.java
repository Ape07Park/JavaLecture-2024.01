package ch04_control;

import java.util.Scanner;

public class Ex11_For {

	public static void main(String[] args) {
		// 1에서 100까지 합
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			// crtl + shift + f: 들여쓰기 정렬
		}
		System.out.println("1에서 100까지 합:" + sum);
		
		// 1에서 100까지 홀수 합
		int oddSum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 != 0) {
				oddSum += i;
			}
		}
		System.out.println(oddSum);
		
		// 자기 자신을 제외한 약수의 합, num = 28
		int divSum = 0, num = 28;
		
		for(int i = 1; i < num; i++) {
			if(num % i == 0) {
				divSum += i;
			}
		}
		System.out.println(divSum);
		
		// 초기식, 증감식에 여러 개의 변수를 사용할 수 있음 
		for (int i = 1, k =2; i * k < 10; i ++, k++) {
			System.out.println("i =" + i + ", k = " + k );
		}
		
		// 사용자가 5번 입력한 문자열을 받아 공백을 사이에 넣고 하나의 문자열로 만들어 출력 
		Scanner scan = new Scanner(System.in);
		String text = "";
		for(int i = 1; i <= 5; i++) {
			System.out.println("입력> ");
			String line = scan.nextLine();
			text += line + " ";
		}
		scan.close();
		System.out.println(text);
		
		// Enhanced for-loop
		String[] fruits = {"apple", "banana", "cherry"};
		for (String fruit:fruits) {
			System.out.println(fruit);
		}
	}

}
