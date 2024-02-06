package ch18_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Ex03_OutputStream {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("c:/Temp/output.txt");
			// 여기다 필요한 코드 다 적기
			
			byte a = 0x41; // A
			char b = 'B';
			int c = 0x43;
			os.write(a);
			os.write(b);
			os.write(c);
			
			byte[] arr = {97, 98, 99, 100, 101};
			os.write(arr);
			
			os.write(arr, 1, 3); // byte[], offset, length
			
			os.flush(); // flush : 버퍼에 있는 것들 다 흘려보내라 즉 다 작업해라 
			os.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
