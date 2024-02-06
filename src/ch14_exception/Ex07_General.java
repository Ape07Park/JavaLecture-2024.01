package ch14_exception;

public class Ex07_General {
	public static void main(String[] args) {
	int value = 0;
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	try {
		value = Integer.parseInt(args[0]);
	
		} catch (Exception e) { // Exception e 웬만한 모든 종류의 에러 다 잡음, 이걸 쓰려면 제일 작은 범위를 위에 먼저 작성할 것 if문 처럼 
			e.printStackTrace();
			System.out.println("사용법: 매개변수가 필요하고 숫자 입력 필요함");
		} 
		System.out.println(value);
	}
}
