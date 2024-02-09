package ch14_exception;

import java.io.IOException;
import java.io.InputStreamReader;

// 이런 류의 프로그램을 실행할려면 예외처리 필요 

public class Ex01_Checked {

	public static void main(String[] args) { // throws InterruptedException 나를 부른 얘가 예외 전가
		// 이 방법 많이 사용
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		
		try {
			Class cls = Class.forName("java.lang.kobject");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			isr.read(); // 읽으라고 해서 syso 안뜸 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("프로그램의 마지막입니다");

	}

}
