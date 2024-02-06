package ch05_reference;

import java.util.Arrays;

public class Ex03_MultiDimArray {

	public static void main(String[] args) {
		// 2차원 배열(matrix)
		int[][] matrix = new int[2][3];
		int score[][] = { { 80, 90, 70 }, { 85, 88, 72 } };

		System.out.println(Arrays.toString(score)); // score 배열 값 자체 출력
		System.out.println(Arrays.toString(score[0]));
		System.out.println(Arrays.toString(score[1]));

		// indexing [행][열]
		System.out.println(score[0][0] + ", " + score[1][1]);

		int gear[][] = { { 1, 3, 5, 9 }, { 2, 6 }, { 8, 5, 3 } };

		// 실력향상 연습문제
		// 두 행렬의 dot product 구하기
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } }; // 2 x 3
		int[][] b = { { 1, 2 }, { 3, 4 }, { 5, 6 } }; // 3 x 2
		int[][] c = new int[2][2];

		// 지뢰 찾기, padding 주면 더 쉽게 찾을 수 있음
		char[][] mines = new char[8][8];
		for (int i = 0; i < mines.length; i++) {
			for (int j = 0; j < mines[i].length; ++j) {
				mines[i][j] = (Math.random() > 0.7) ? '*' : '.';
			}
		}
		printMines(mines);
	}

	static void printMines(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}
	}
}
