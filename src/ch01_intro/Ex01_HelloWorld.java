package ch01_intro;

// class 이름: 대문자로 시작, 숫자가 먼저 못옴
public class Ex01_HelloWorld {
	/**
	 * 도큐먼트 주석 - api 도큐먼트 만들 떼 사용
	 * @param args
	 */
	// method 이름: 소문자로 시작
	public static void main(String[] args) { // public: 접근 제어자, static: 메모리 영역, void: return 값 x 
		// sysout, syso 치고 ctrl + space치면 System.out.println()이 생김

		System.out.println("Hello World");
		System.out.println("안녕하세요" + "여러분"); // ,가 아닌 +로 연접 뛰어쓰기 x/ 하나의 문자열만 올 수 있음 
		// ctrl + /: 문장을 주석처리(토글)
	}
}
