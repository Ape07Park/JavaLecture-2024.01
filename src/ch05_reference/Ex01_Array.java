package ch05_reference;

import java.util.Arrays;

public class Ex01_Array {

	public static void main(String[] args) {
		// 프로그램 로직 구현엔 ArrayList 사용. 배열은 한정적 상황에서 사용
		// 배열(메모리 상에 연속된 공간 확보) 생성

		// 배열 생성 및 초기화 즉 배열 생성하며 값 지정. 이 방식 많이 씀
		int[] score = { 80, 90, 78, 93, 65 };
		char grade[] = { 'B', 'A', 'C', 'A', 'D' };

		// 배열 생성하며 크기를 지정 // 이 방식 많이 씀
		int[] newArray = new int[10];

		// 배열 인텍싱
		System.out.println(score[0] + " , " + score[4]);
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println();

		// 값을 할당
		score[0] = 90;
		grade[0] = 'A';
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = 1 + (int) (Math.random() * 6);
		}
		System.out.println(Arrays.toString(newArray)); // array 스트링으로 줄줄이 출력
		System.out.println(Arrays.toString(score));
		// 클래스의 맴버변수, array는 처음부터 0으로 초기화 되어 있음
		// heap 메모리 초기값: 기본자료형 0 / 사용자 정의 자료형 null

	}

}
