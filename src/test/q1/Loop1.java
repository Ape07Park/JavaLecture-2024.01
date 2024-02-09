package test.q1;

import java.util.Scanner;

public class Loop1 {
	public static void main(String[] args) {
		/* 1) 1에서 100까지 3의 배수의 합을 구하세요 */
		
		// 합 만들기 ,1 ~ 100까지 반복하기, 3으로 나누었을 때 나머지가 0인 거 꺼내서 합에 더하기
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1에서 100까지 3의 배수의 합:" + sum);
		
		System.out.println();
		
		/* 1에서 20까지 홀수 제곱의 합을 구하세요 */
		// sum 초기화, 1~20 까지 반복, 2로 나누었을 때 나머지가 0 아닌 것 고르기, 아닌 것에 제곱하고 더하기, 출력
		sum = 0;
		for(int i = 1; i <=20; i++) {
			if(i % 2 != 0) {
				sum += Math.pow(i, 2);
			}
		}
		System.out.println("1에서 20까지 홀수 제곱의 합:" + sum);
		
		System.out.println();	
		// 스캐너 만들고 int 자료형 받기 및 num에 저장, main 밖에 isPrime 메서드 만들기(반복문, 조건문), 결과 리턴
		// 소수: 자기로 나누거나 1로 나누었을 때만 나머지 0
		
		/* 4) 메소드를 이용하여 2에서부터 100까지 소수의 합을 구하세요 */
		sum = 0;
		for(int i = 2; i <= 100; i++) {
			if(Loop1.isPrime(i) == true) {
				sum += i; 
				
			}
		}
		System.out.println("2에서부터 100까지 소수의 합:" + sum);
		
	}
	
	/* 3) 어떤 수가 소수(prime number: 1과 자기자신만을 약수로 갖는 수, 예: 2, 3, 5 …)인가를
	판단하는 메소드 Boolean isPrime(int num); 를 만드세요. */
	// 소수 구하는 방법: 2,3,5,7,11,13
	
	// 1 * 16, 2 * 8, 4 * 4,  8 * 2, 16 * 1 즉 제곱근 기준으로 좌우 대칭 교환법칙
	public static Boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
	}
}
