package ch18_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ex09_PrintStream {
	/*
	 * PrintStream: System.out.println();과 비슷함 
	 */
	
	public static void main(String[] args) throws Exception {
		// 파라미터에 true 가 있으면 append mode(기존에 쓴 거에 더해서 쓰기)
		// 파라미터가 x면 ovrewrite mode(기존에 쓴 거 지우고 다시 쓰기)
		PrintStream ps = new PrintStream(new FileOutputStream("c:/Temp/print.txt", true));
		System.out.println();
		ps.print("마치 ");
		ps.println("System.out이 출력하는 것 처럼");
		ps.println("데이터 출력");
		ps.println("아래와 같이 포맷티드 출력도 가능");
		ps.printf("%-6s%,8d%n", "딸기", 12000);
		ps.printf("%-6s%,8d%n", "사과", 3000);
		
		ps.flush();
		ps.close();

	}

}
