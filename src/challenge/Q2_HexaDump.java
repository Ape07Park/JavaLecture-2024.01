package challenge;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;

public class Q2_HexaDump {

	public static void main(String[] args) throws Exception {
		// 바이너리 파일이라 인풋스트림쓸 것 
		// addr 헥사라 16되면 10단위로 업 
		// %x 소문자 헥사로 찍을 것 
		// 너무 넘어가면 3칸 띄기 
		// k == 7이면 한칸 띄기 
		// 12 && 쪽 눈으로 볼수 있는 아스키 코드는 찍어라 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 바이너리 파일> ");
		String filename = scan.nextLine();
		scan.close();
		InputStream is = new FileInputStream(filename);
		
		byte[] buffer = new byte[1024];
		int addr = 0;
		while (true) {
			int num = is.read(buffer);
			if (num == -1)
				break;
			for (int i = 0; i <= num / 16; i++) {
				System.out.printf("%04x:  ", addr);
				for (int k = 0; k < 16; k++) {
					int index = i * 16 + k;
					if (index >= num)
						System.out.print("   ");
					else
						System.out.printf("%02x ", buffer[index]);
					if (k == 7)
						System.out.print(" ");
				}
				System.out.print(" ");
				for (int k = 0; k < 16; k++) {
					int index = i * 16 + k;
					if (index >= num)
						break;
					if (buffer[index] >= 32 && buffer[index] < 127)
						System.out.print((char)buffer[index]);
					else
						System.out.print(".");
					if (k == 7)
						System.out.print(" ");
				}
				System.out.println();
				if ((i + 1) * 16 >= num)
					break;
				addr += 16;
			}
			System.out.println();
		}

	}

}
