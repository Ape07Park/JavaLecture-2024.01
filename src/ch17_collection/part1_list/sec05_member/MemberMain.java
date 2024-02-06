package ch17_collection.part1_list.sec05_member;


import java.util.ArrayList;
import java.util.List;

public class MemberMain {
	private static List<Member> list = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			int age = 20 + (int) (Math.random() * 20);
			list.add(new Member(age, "이름" + i, Math.random() >0.5 ? "남":"여"));
		}
		for (Member m:list) {
			System.out.println(m);
		}
		System.out.println("===========================");
		
		// 나이가 30세 이상인 Member list (R)
		List<Member> mList = getMemberListAbove30();
		mList.forEach(x -> System.out.println(x));
		
		System.out.println("===========================");
		
		// 남성 Member list 
		List<Member> gList = getMemberListByGender("남");
		gList.forEach(y -> System.out.println(y));
		
		System.out.println("===========================");
		
		//  Member 추가 (C)
		Member member = new Member(39, "제임스", "남");
		insertMember(member);
		list.forEach(x -> System.out.println(x));
		
		System.out.println("===========================");
		
		// Member 삭제 (D)
		DeleteMember("이름7");
		list.forEach(x -> System.out.println(x));
		
		System.out.println("===========================");
		
		// 여성 맴버의 나이를 -1 (U)
		for(Member m:list) {
			if (m.getGender().equals("여")) {
				updateMember(m);
			}
		}
		list.forEach(x -> System.out.println(x));
		
		System.out.println("===========================");
		
	}
	
	// 메서드 구현 
	
		static List<Member> getMemberListAbove30() {
			List<Member > mList = new ArrayList<>();
			for (Member m:list) {
				if(m.getAge() > 30) {
					mList.add(m);
				}
			}
			return mList;
		}
		
		static List<Member> getMemberListByGender(String gender){
			List<Member> mListForGender = new ArrayList<>(); 
			// 맴버 리스트 타입의 변수 mListForGender에 맴버 타입 ArrayList 생성
			
			for(Member m: list) { 
				if(m.getGender().equals(gender)) {
					mListForGender.add(m);
				}
			}
			return mListForGender;
		}
		
		static void insertMember(Member member) {
			list.add(member);
		}
		
		static void DeleteMember(String name) {
			Member member = null;
			for(Member m:list) {
				if(m.getName().equals(name)) {
					member = m;
					break;
				}
			}
			list.remove(member);
		}
		
		static void updateMember(Member member) { 
			int index = list.indexOf(member);
			if(index >= 0) { // 없는 거 고르는 거 방지 
				member.setAge(member.getAge()-1);
				list.set(index, member);	
				
			}
		}
}
