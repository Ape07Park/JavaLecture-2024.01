package ch02_type;

public class Ex03_TypeConversion {
	public static void main(String[] args) {
		/**
		 * 자동 타입 변환(promotion): 작은 것 -> 큰 것
		 * byte -> short -> int -> long -> float -> double -> String
		 * 
		 */
		short a = 256;
		int b = a;
		long c = b;
		float d = c;
		double e = d;
		System.out.printf("%d, %d, %.1f, %.1f%n" , b, c, d, e); // .1f: 소숫점 1자리 까지 표시, %n: 한칸 띄기
		
		/**
		 * 강제 타입 변환(Type Casting): 큰 것에서 작은 것으로 갈 경우, 값의 손실 o, 표시 가능한 범위 벗어나면 x
		 */
		long f = 250l;
		int g = (int) f;
		short h = (short) g;
		double i = 3.14;
		double j = (float) i;
		System.out.printf("%d, %d, %.2f, %.2f%n" , g, h, i, j);
		System.out.println("(int) i: " + (int) i); // Type Casting으로 인한 값의 손실
		
		// 연산에서 자동 타입변환 
		long k = a + b + c; // short + int + long -> long. 가장 큰 걸로 change
		double l = d + e; // float + double -> double
		double m= a / b; // int / int -> truncate 후 정수로 바뀜 -> double(내가 double 타입 변수 선언 해야함), 선언 x 면 truncate 후 정수로 바뀜
		System.out.println("k :" + k + ", l: " + l + ", m:" + m);
		 
	}
}
