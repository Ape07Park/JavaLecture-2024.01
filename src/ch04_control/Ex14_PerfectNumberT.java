package ch04_control;

public class Ex14_PerfectNumberT {

	public static void main(String[] args) {
		for (int i = 2; i <= 10000; i++) {
			int divSum = 0;
		for (int k = 1; k < i; k++) {
			if (i % k == 0) {
				divSum += k;
				}		
			}
		
		// 자기 자신을 제외한 약수의 합과 자기자신이 같으면
		if (i == divSum) {
			System.out.println(i);
			}
		}
	}
}