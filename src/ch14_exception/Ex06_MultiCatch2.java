package ch14_exception;



public class Ex06_MultiCatch2 {
	public static void main(String[] args) {
	int value = 0;
	
	try {
		value = Integer.parseInt(args[0]);
	
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			e.printStackTrace();
			System.out.println("사용법: 매개변수가 필요하고 숫자 입력 필요함");
		} 
		System.out.println(value);
	}
}
