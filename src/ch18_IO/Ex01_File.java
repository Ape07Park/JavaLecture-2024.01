package ch18_IO;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.plaf.synth.SynthToggleButtonUI;


public class Ex01_File {

	public static void main(String[] args) throws IOException {
		File file = new File(("C:/Temp/test/README.txt"));
		File dir = new File("C:/Temp/test");
		
		if (!dir.exists()) { // dir이 존재 x 시 
			dir.mkdir(); // dir 만들기 
		}  
		if(!file.exists()) { // file이 존재 x 시
			file.createNewFile(); // file 생성 
		}
		
		// cmd 창에서 dir \temp한 결과 
		File temp = new File("c:/Temp");
		File[] contents = temp.listFiles();
		for (File content: contents) {
			System.out.println(content);
		}
		
		// CMD처럼 dir 입력하면 화면에 output 띄우기 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a hh:mm");
		for (File f: contents) {
			System.out.printf("%-24s", sdf.format(f.lastModified()));
			if(f.isDirectory()) {
				System.out.printf("%-14s %-20s%n", "<DIR>", f.getName());
			}else {
				System.out.printf("%,14d %-20s%n", f.length(), f.getName());
			}
		}
		
		//.getByte("UTF-8)
	}

}
