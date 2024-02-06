package ch05_reference;

public class Ex11_String {

	public static void main(String[] args) {
		// 생성
		String str1 = new String("문자열");

		String str2 = "문자열";

		// 참고용
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 }; // Hello Java
		String str3 = new String(bytes);
		System.out.printf("%s, %s, %s%n", str1, str2, str3);
		
		String str4 = "문자열"; 
		System.out.println(str2 == str4); // str2와 str4의 주소값 동일 
		
		Person james = new Person("제임스", 29, "프로그래머");
		Person marry = new Person("메리", 25, "학생");
		
		System.out.println(james + " - 123"); //person class의 toString() method 적용 
		System.out.println(marry + " - 123");
		
	}

}
