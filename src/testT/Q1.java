package testT;

public class Q1 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1에서 100까지 3의 배수의 합 = " + sum);
		
		int oddSumOfSquare = 0;
		for(int i = 1; i <= 20; i += 2) {
			oddSumOfSquare = i * i;
		}
		System.out.println("1에서 20까지 홀수 제곱의 합 = " + oddSumOfSquare);
		
		int sumOfPrimeNumber = 0;
		for (int i = 2; i <= 100; i++) {
			if (isPrime(i))
				sumOfPrimeNumber += i;
		}
		System.out.println("2에서 100까지 소수의 합 = " + sumOfPrimeNumber);
		
	}
	

	static boolean isPrime(int num) {
		for (int i = 2; i <= num - 1; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
