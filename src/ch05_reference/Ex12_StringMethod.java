package ch05_reference;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class Ex12_StringMethod {

	public static void main(String[] args) {

		String str1 = "Hello Java";
		String str2 = "안녕하세요? 반갑습니다.";

		// 스트링의 길이: 속성 x 메소드 o
		System.out.println(str1.length() + " ," + str2.length());

		// 문자열 검색 : String 타입 변수.charAt(인덱스)
		System.out.println(str2.charAt(0) + ", " + str2.charAt(7)); // 안, 반 

		// 주민등록번호를 입력받아 남자인지 여자인지 구별

		Scanner scan = new Scanner(System.in);
		String forword = scan.nextLine();
		
		System.out.println("-");
		
		String backword = scan.nextLine();
		
		if(backword.charAt(0) == 1 || backword.charAt(0) == 3) {
			System.out.println("남");	
		}
		
		else if(backword.charAt(0) == 2 || backword.charAt(0) == 4) {
			System.out.println("여");
		}

		// 찾고자 하는 문자열이 대상 문자열에 있는지 확인해 인덱스 반환 String 타입 변수.indexOf("찾을려는 문자열")
		System.out.println(str1.indexOf("Java") + ", " + str2.indexOf('반'));

		// 출력이 0보다 크다는 것은 찾는 문자열이 있다는 것 의미
		if (str1.toLowerCase().indexOf("java") >= 0) {
			System.out.println("문장 안에 java라는 글자 존재");
		}

		System.out.println("apple pineapple".lastIndexOf("pp"));

		/* 문자열 변환 */

		// 문자열로 변환: 명시적(explicit)
		boolean a = true;
		int b = 123;
		double c = 3.14;
		char d = 'a';
		System.out.println(
				String.valueOf(a) + " ," + String.valueOf(b) + " ," + String.valueOf(c) + " ," + String.valueOf(d));
		// 암묵적 변환 (implicit)
		System.out.println(a + ", " + b + ", " + c + ", " + d);

		/* 문자열로 배열 변환, 문자열 --> byte[], char[] */

		// byte[]
		byte[] byteStr1 = str1.getBytes();
		byte[] byteStr2 = str2.getBytes(Charset.defaultCharset());
		System.out.println(Arrays.toString(byteStr1));
		System.out.println(Arrays.toString(byteStr2)); // UTF-8: 초성 + 중성 + 종성 각 1바이트씩 차지

		// char[] -현업에선 이거 쓸 것임
		System.out.println(Arrays.toString(str2.toCharArray()));
		
		/* 문자열 내용 비교 */
		System.out.println(str1.equals("hello World")); // 문자열 비교시 == 사용 x 
		System.out.println(str1.equalsIgnoreCase("hello java")); // 문자열 비교인데 대소문자 구분 x 

	}

}
