package ch18_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex07_BufferedIO {

	public static void main(String[] args) throws Exception {
		/*
		 *  buffer를 썼을 때와 안썼을 때 비교 
		 */
		
		// Case 1) 미사용 
		InputStream is = new FileInputStream("c:/Temp/eiffer.JFIF");
		OutputStream os = new FileOutputStream("c:/Temp/에펠.jpg");
		
		long noBufferTime = copy(is, os);
		System.out.println("버퍼 미사용: " + noBufferTime + " ns"); // 1.3초 
		is.close();
		os.close();
		
		// * Case 2) 버퍼 사용: 속도 개선을 위한 사용 
		is = new BufferedInputStream(new FileInputStream("c:/Temp/eiffer.JFIF"));
		os = new BufferedOutputStream(new FileOutputStream("c:/Temp/에펠.jpg"));
		
		long BufferTime = copy(is, os);
		System.out.println("버퍼 사용: " + BufferTime + " ns"); // 0.3초 
		is.close();
		os.close();
	}
	
	static long copy(InputStream is, OutputStream os) throws IOException {
		long startTime = System.nanoTime();
		// 1바이트씩 일고 쓰기 
		while (true) {
			int data = is.read();
			if (data == -1) {
				break;
			}
			os.write(data);
		}
		os.flush();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

}
