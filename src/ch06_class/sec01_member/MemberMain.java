package ch06_class.sec01_member;

import java.time.LocalDate;

public class MemberMain {

	public static void main(String[] args) {
		// 객체 생성- 초기 파라미터 x
		Member james = new Member();

		// 객체 생성- 초기 파라미터 o
		Member marry = new Member("Marry", LocalDate.of(2003, 1, 17), "marry@gmail.com");

		// 필드 접근
		james.name = "제임스"; // 접근 제한자가 public이라 가능
//		james.email = "james@naver.com"; // 접근 제한자가 private이라 불가능
		james.setEmail("james@naver.com");
		james.setBirthday(LocalDate.of(2001, 11, 19));

		// 메서드 사용
		System.out.println(james); // james.toString() / toString() 생략가능
		System.out.println(marry.toString());
		
		System.out.println(james.name + ": " + james.getBirthday() +", " + james.getAge());
		System.out.println(marry.name + ": " + marry.getBirthday() +", " + marry.getAge());
	}

}
