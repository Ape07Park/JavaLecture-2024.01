package ch18_IO.grep;

import java.io.*;

public class Grap2 {

	public static void main(String[] args) {
		
		// 1) 검색할 파일 경로 및 정규 표현식 패턴
		// 2) 정규 표현식 패턴 컴파일
		// 3) 파일의 각 라인에 대해 검색
		// 4) 현재 라인에서 패턴 매칭 확인
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("파일 경로"));
			
			int lineNo = 1;
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
