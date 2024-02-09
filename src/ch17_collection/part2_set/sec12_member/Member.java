package ch17_collection.part2_set.sec12_member;

public class Member implements Comparable {// 트리 형태로 들어갈려면 implements Comparable 해서 compareTo 메서드 구현 필요

	private int age;
	private String name;

	public Member() {
	}

	public Member(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	// *TreeSet, TreeMap에서 사용되는 객체는 Comparable I/F 구현 필요
	// *트리셋에선 0, 음수, 양수로 대소 비교
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Member) {
			Member m = (Member) obj;
			// 이름으로 비교
//				return this.compareTo(m.getName());
			
			// 나이 비교 후 이름 비교. 둘의 비교 순서 바꿀려면 두 조건문의 위치를 바꿀 것
			if (this.name.compareTo(m.getName()) == 0) {
				return m.getAge() - this.age;
			} else {
				return this.name.compareTo(m.getName());
			}

		} else {
			return 0; // 0이면 같다고 판단
		}
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

	@Override
	public String toString() {
		return "Member [age=" + age + ", name=" + name + "]";
	}
}
