package ch14_exception;

public class Ex04_Finally {

	public static void main(String[] args) {
		String str = null;
		try {
			str = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("사용법: 매개변수 입력하시오");
		}
		System.out.println(str);
		int value = 0;
		try {
			 value = Integer.parseInt(str);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("사용법: 숫자만 입력하시오");
		} finally {
			System.out.println("예외와 상관없이 무조건 실행"); // close에 쓰는 경우 있음 ex Scanner
		}
		System.out.println(value); // 로컬 변수를 밖에서 찍을려고 해서 에러남 

	}

}
