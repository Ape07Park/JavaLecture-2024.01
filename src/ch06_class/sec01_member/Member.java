package ch06_class.sec01_member;

import java.time.LocalDate;

public class Member {
	// 필드 or 맴버 or 속성
	public String name;
	private LocalDate birthday;
	private String email;
	
	// 생성자(constructor)
	public Member() { }
	
	public Member(String name, LocalDate birthday, String email) {
	
		this.name = name; // public String name; 가리킴
		this.birthday = birthday;
		this.email = email;
	}
	
	// Method(메서드)
	public int getAge() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		int age = (month < birthday.getMonthValue() || 
				   (month == birthday.getMonthValue() && day < birthday.getDayOfMonth())) ? 
				year - birthday.getYear() - 1 : year - birthday.getYear();
		return age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", birthday=" + birthday + ", email=" + email + "]";
	}
	
	
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	// 이너 클래스 
	class InnerClass{
		
	}

}

// 이너, 외부 클래스 안쓰니 버리기
// 접근제한자는 public, private만 외우기
// 외부 클래스 
class ExternalClass { // 접근 제한자 안쓰면 default임, 외부 클래스는 public 사용 x
	
}
