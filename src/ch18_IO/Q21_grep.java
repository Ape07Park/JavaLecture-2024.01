package ch18_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q21_grep {
	// 한줄 단위로 읽으며 내가 찿는 문자열이 있으면 출력

	public static void main(String[] args) {
		// 찾을 문자열 
		Scanner scanner = new Scanner(System.in);
		System.out.print("찾을 문자열> ");
		String search = scanner.nextLine();
		// 찾을 파일
		System.out.print("찾을 파일> ");
		String filename = scanner.nextLine();
		scanner.close();
		
		grep(search, filename);
		
	}
	
	static void grep(String search, String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename)); // BufferedReader는 파일 엑세스 x 따라서 파일 엑세스를 위한 파일 리더를 안에 넣기
			// 라인 번호 찍어야 하니 선언함 
			
			int lineNO = 1; 
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				
				String newLine = line.toLowerCase(); // 다 소문자로 만들어서 대소문자 구분 x
				if(newLine.contains(search.toLowerCase())) { // search가 newLine에 있다면 
					System.out.printf("%4d:\t%s%n", lineNO, line);
				}
				/* **문자열에 있는 특정 문자 찾기
				 * 1. indexOf(): 대상 문자열에서 찾고자 하는 문자의 index값을 찾고싶을 때, 조건문 써서 결과가 0보다 크면 있다는 것
				 * 2. contains(): 대상 문자열에서 찾고자 하는 문자열이 포함되어있는지 여부를 알고 싶을때(return은 boolean)
				 * 3. matches(): 대상 문자열에서 정규표현식(숫자, 영문자, 한글)등이 포함되어있는지 여부를 알고 싶을때(return은 boolean)
				 */
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
