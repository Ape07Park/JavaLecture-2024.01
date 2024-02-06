package ch04_control;

public class Ex14_PerfectNumberFunc {

	public static void main(String[] args) { 
		for (int i = 2; i <= 10000; i++) {		      
			int divSum = sumOfDivisors(i);
		    if (i == divSum)        
		        System.out.println(i);
		}			
	}
	
	// 함수
	static int sumOfDivisors(int num) {
		int divSum = 0;
		for (int i = 1; i < num; i++)
			if (num % i == 0)
				divSum += i;
		return divSum;
	}
}
