package ch04_control;

public class Ex14_PerfectNumber {

	public static void main(String[] args) {
		// 3 ~ 10000이하의 수 중. 자기 자신을 제외한 약수. 의 합.과 자기 자신이 같은 수. Ex) 6, 24
		int count = 0;
		int sum = 0;
		for(int i = 3; i <= 10000; i++) {
			
			// i의 약수 구하기 
			for(int j = 1; j < i; j++) {
				if(i % j == 0) {
					sum += j;
				}
				
				if (sum == i) {
					System.out.println(i);
				}
			}
		}
		
		

	}

}
