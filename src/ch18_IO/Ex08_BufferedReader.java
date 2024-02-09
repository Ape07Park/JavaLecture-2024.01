package ch18_IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Ex08_BufferedReader {

	public static void main(String[] args) throws Exception {
		/*
		 *  줄 단위로 읽을 수 있음 - 편의성 개선 
		 */
		BufferedReader br = new BufferedReader(new FileReader("c:/Temp/README.txt")); // 추상클래스라 안에 내용 넣기 o
		
		int lineNo = 1;
		while(true) {
			String line = br.readLine();		
			if(line == null) {
				break;
			}
			System.out.println(lineNo + ": " + line);
			lineNo++;
		}
		br.close();
	}

}
