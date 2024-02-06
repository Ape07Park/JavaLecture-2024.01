package ch18_IO.grep;

import java.io.*;

import java.nio.*;

import java.nio.channels.*;

import java.nio.charset.*;

import java.util.regex.*;

public class Grep {
	public static void main(String[] args) {
		

    // 1) 검색할 파일 경로 및 정규 표현식 패턴
    String filePath = "C:\\Users\\human-04\\Desktop\\hi\\test.txt";
    String patternString = "mon+day"; // a와 b 사이에 뭔가가 들어오면 

    // 2) 정규 표현식 패턴 컴파일
    Pattern pattern = Pattern.compile(patternString); // patternString이라는 정규 표현식을 컴파일해서 패턴에 저장

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //  FileReader로 filePath를 읽고 BufferedReader에 저장 
    	
        String line; // String 타입의 line 선언
        int lineNumber = 0; // line의 수는 0

        // 3) 파일의 각 라인에 대해 검색
        while ((line = br.readLine()) != null) { // 버퍼 리더로 읽은 것을 라인에 넣고 라인에 아무 것도 없으면 lineNumber++로 다음 라인으로 넘어감
            lineNumber++;

            // 4) 현재 라인에서 패턴 매칭 확인
            Matcher matcher = pattern.matcher(line); 
            if (matcher.find()) {
                System.out.println("패턴 발견 - 파일: " + filePath + ", 라인: " + lineNumber + ", 내용: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}




