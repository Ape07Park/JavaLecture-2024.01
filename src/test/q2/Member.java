package test.q2;

import java.time.LocalDateTime;
import java.util.ArrayList;

// 1-1 속성

public class Member {
	private int id;
	private String name;
	private int birthYear;
	private String tel;

	// 1-2 생성자

	public Member() {
	}

	public Member(int id, String name, int birthYear, String tel) {
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.tel = tel;
	}

	// 1-3 Getter/Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {

		return "Member [id:" + id + ", 이름:" + name + ", 나이:" + (LocalDateTime.now().getYear() - birthYear) + ", 전화번호:"
				+ tel + "]";
	}

}
