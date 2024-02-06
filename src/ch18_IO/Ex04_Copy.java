package ch18_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex04_Copy {
	// 인풋에서 카피 대상 읽어서 아웃풋에 결과(카피한 거) 보여주기 
	public static void main(String[] args) throws Exception {
		String srcFile = "c:/Temp/cat.jpg", dstFile = "c:/Temp/고양이.jpg";
		InputStream is = new FileInputStream(srcFile); 
		OutputStream os = new FileOutputStream(dstFile);
		
		byte [] buffer = new byte[2048];
		while (true) {
			int num = is.read(buffer);
			if (num == -1) {
				break;
			}
			os.write(buffer, 0, num);
		}
		os.flush();
		os.close();
		is.close();
		System.out.println("Copy is done");
		
	}
}
