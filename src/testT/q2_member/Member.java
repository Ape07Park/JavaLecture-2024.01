package testT.q2_member;

import java.time.LocalDate;

public class Member {
	private int id;
	private String name;
	private int birthYear;
	private String tel;
	
	public Member() {}
	
	public Member(int id, String name, int birthYear, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.tel = tel;
	}

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
	private int getAge() {
		LocalDate today = LocalDate.now();
		return today.getYear() - birthYear;
	}

	@Override
	public String toString() {
		return "Member ID:" + id + ", 이름:" + name + ", 나이" + getAge() + ", 전화번호:" + tel;
	}
	
	
	
	
}
