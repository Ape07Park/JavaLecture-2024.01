package ch06_class.sec03_calculator;

public class Calculator {
	// return 타입은 사용자 정의 자료형도 가능

	public int add(int x, int y) {
		return x + y;
	}
	
	// 메서드 오버로딩: 메서드 이름 or 매개변수 타입, 매개변수 숫자 다르면 다른 메서드로 인식. 따라서 같은 이름으로 중복 정의 가능
	public double add(double x, double y) { 
		return x + y;
	}
	
	// 메서드 오버로딩
	public double add(double x, int y) { 
		return  x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}

	public int mul(int x, int y) {
		return x * y;
	}

	public double div(int x, int y) {
		return (double) x / y;
	}
	
	public void print(int x, int y) {
		System.out.println(x + " + " + y + "=" + add(x, y));
		System.out.println(x + " - " + y + "=" + sub(x, y));
		System.out.println(x + " * " + y + "="+ mul(x, y));
		System.out.println(x + " / " + y + "=" + div(x, y));
	}
}
