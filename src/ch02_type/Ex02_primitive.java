package ch02_type;

public class Ex02_primitive {

	public static void main(String[] args) {
		// boolean
		boolean a = true, b = false;
		System.out.println("a:" + a +",b:" + b);
		
		// 기본 자료형의 종류들(기본 자료형 타입 표시시 소문자 ex) float / 사용자 자료형은 대문자 시작 ex) String
		/**
		 * 정수 계열 - 기본: int 
		 * 1. byte: 1 byte, -128 ~ 127
		 * 2. short: 2 byte, -32768 ~ 32767
		 * 3. int: 4 byte, -2147483648 ~ 2147483647
		 * 4. long: 8 byte -2 ** 63 ~ 2 ** 63 - 1 
		 * 
		 * 주의사항
		 * 1. 숫자값(예, -123, 57)은 기본적으로 int 타입
		 * 2. long 타입 숫자값 뒤에는 L을 붙여야 함(15L), 소문자도 상관 x 다만 햇갈릴 염려 o
		 */
		byte w = 10;
		short x = 1024;
		int y = 1000000;
		long z = 300000000L;
		System.out.printf("%d, %d, %d, %d\n", w, x, y, z); // format, d: 정수 f: 실수 s:문자열
		
		/**
		 * 실수 계열 - 기본: double
		 * 1.float: 4 byte, 12.3f, 유효자리: 약 소수점 7자리 이하 
		 * 2. double: 8 byte, 유효자리: 약 소수점 15자리 이하 double precison의 줄임말
		 * 주의사항
		 * 숫자값(예, 3.14, e(2.728)은 기본적으로 double 따라서 float뒤에 숫자값 붙임 ex) 3.14F 소문자 o
		 */
		float f1 = 1.0000001f, f2 = 1.00000001f;
		double d1 = 1.000000000001, d2 = 1.00000000000000001; // 유효자리 넘어가면 처리 1.0으로 표시
		System.out.println("f1: "+ f1 + ", f2:" + f2);
		System.out.println("d1: "+ d1 + ", d2:" + d2);
		// 자바는 float, double로 많이 x, 은행권에서 쓰는 정도
		
		/**
		 * 문자: 1 글자
		 */
		char eng = 'A', kor = '안';
		System.out.println("eng: " + eng + ", kor: " + kor);
		// stack: Last In First Out(LIFO), 객체의 주소값, 변수 값 등 저장되어 있음
		// queue: First In First Out(FIFO)
		// heap: 객체의 값 저장 
		// \u0112: 유니코드로 표기
	}

}
