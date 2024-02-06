package ch05_reference;

import java.util.Arrays;

public class Ex02_ArrayCopy {

	public static void main(String[] args) {
		int src[] = { 1, 2, 4, 8 };
		int[] dst = src;
		System.out.println(Arrays.toString(dst));

		dst[2] = 5;
		System.out.println(Arrays.toString(dst));
		// Side effect(부작용) 발생: 원치 않은 src 내용도 변경됨
		System.out.println(Arrays.toString(src));

		int[] newSrc = { 3, 4, 7, 9 };
		int[] newDst = new int[4];
		// Deep copy: 2차원 배열에선 사용 x
		System.arraycopy(newSrc, 0, newDst, 0, newSrc.length); // newSrc 0번째 부터 카피해서, newDst 인덱스 0부터 newDst의 길이까지에 넣기
		System.out.println(Arrays.toString(newDst));

		newDst[2] = 15;
		System.out.println(Arrays.toString(newDst));
		System.out.println(Arrays.toString(newSrc));

	}

}
