package ch02_type;

import java.io.IOException;
import java.util.Scanner;

public class Ex04_input {

	public static void main(String[] args) throws IOException { // 예외 처리
		// 하나의 문자를 읽을 때 사용하나 빈번한 사용 x
//		int keyCode = System.in.read();				//  5 -> 0x35 == 3 * 16 + 5 = 53
//		System.out.println("keyCode: " + keyCode); 
		
		Scanner scan = new Scanner(System.in);
//		var scan = new Scanner(System.in);  Scanner 자료형 대신 var 가능
		System.out.print("입력> ");
		String inputText = scan.nextLine(); //Enter를 칠 때까지 문자열 입력을 받음
		System.out.print(inputText); 
	}

}
