package ch18_IO;


import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * byte 단위로 읽기 및 쓰기
 * InputStream, OutputStream
 */
public class Ex02_inputStream {
	// io는 예외처리 하자

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp/README.txt");
		
		// 읽는 방법 1
		while(true) {
			int data = is.read(); // 1 byte를 읽어서 정수형으로 반환 
			if(data == -1) { 	  // 마지막이면  1111 1111 -> -1 
				break;
			}
			System.out.print((char)data);
		}
		System.out.println();
		
		// 읽는 방법 2: 한글도 제대로 나옴 
		is = new FileInputStream(new File("C:/Temp/README.txt"));
		byte[] arr = new byte[512];
		while(true) {
			int num = is.read(arr);
			System.out.println("읽은 바이트 수: " + num);
			if(num == -1) { 	  // 마지막이면  1111 1111 -> -1 
				break;
			}
		}
		System.out.println(new String(arr));
		is.close();
	}

}
