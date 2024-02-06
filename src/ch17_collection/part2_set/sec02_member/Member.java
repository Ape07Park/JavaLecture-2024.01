package ch17_collection.part2_set.sec02_member;

import java.util.Objects;


public class Member {
	private int age;
	private String name;
	
	public Member() {}
	
	public Member(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	// HasgSet, HashMap 등에  사용하려면  hashCode(), equals() 재정의 필요
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(age,name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member) obj; // 다운 캐스팅 시 instanceof 쓸 것
			return m.getAge() == this.age && m.getName().equals(this.name);
		}else
			return false;
	}

	

	@Override
	public String toString() {
		return "Menber [age=" + age + ", name=" + name + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
