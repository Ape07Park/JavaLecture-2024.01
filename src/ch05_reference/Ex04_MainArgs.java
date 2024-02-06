package ch05_reference;

import java.util.Arrays;

public class Ex04_MainArgs {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args)); // 매개변수의 타입은 문자열이고 배열 형태로 들어옴

		String[] commend = "git add .".split(" ");
		commend = "git  commit	 -m \"Reference Type\"".split("\\s+"); // white space(공백) 여러 개로 분리
		System.out.println(Arrays.toString(commend));

	}

}
