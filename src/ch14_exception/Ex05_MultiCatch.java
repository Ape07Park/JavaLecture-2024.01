package ch14_exception;



public class Ex05_MultiCatch {
	public static void main(String[] args) {
	int value = 0;
	
	try {
		value = Integer.parseInt(args[0]);
	
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("매개변수 입력하시오");
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("바른 숫자 입력");
		}
		System.out.println(value);
	
	}
}
