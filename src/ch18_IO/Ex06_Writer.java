package ch18_IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex06_Writer {

	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/Temp/oupput.txt");
		
		// 1 문자씩 출력
		char a = 'A'; 
		char b = 'B'; 
		
		writer.write(a);
		writer.write(b);
		
		// char 배열 쓰기
		char[] arr = {'C', 'C', 'E'};
		writer.write(arr);
		
		// 문자열 쓰기
		writer.write("FG\n");
		writer.write("한글도 잘 써짐\n");
		
		writer.flush();
		writer.close();
	}

}
