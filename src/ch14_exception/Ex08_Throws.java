package ch14_exception;

public class Ex08_Throws {

	public static void main(String[] args) throws Exception { // JVM에 떠넘김 
//		try {
//			findClass();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("클래스 찾기 실패함");
//		}
		findClass();
//		System.out.println("프로그램 끝"); JVM에 떠넘겨서 더 출력 x

	}
	
	static void findClass() throws ClassNotFoundException {
		Class clazzClass = Class.forName("java.lang.String2");
	}
}
