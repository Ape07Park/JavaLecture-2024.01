package ch17_collection.part3_map;

import java.util.HashMap;
import java.util.Map;

import ch17_collection.part2_set.sec12_member.Member;

public class Ex02_MemberHashMap {

	public static void main(String[] args) {
		// 객체를 map에 넣기
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		map.put(101, new Member(21, "james"));
		map.put(102, new Member(24, "maria"));
		map.put(103, new Member(29, "brain"));
		
		map.forEach((k, v) -> System.out.println(k + ": " + v));
		
		// 객체를 키로도 가능 그러나 잘 안사용
		Map<Member, Integer> map2 = new HashMap<Member, Integer>();
		map2.put( new Member(21, "james"), 100000);
		map2.put( new Member(24, "maria"), 300000);
		map2.put( new Member(29, "brain"), 150000);
		map2.put( new Member(21, "james"), 200000); // hashcode가 달라서 다른 걸로 인식 
		
		map2.forEach((k, v) -> System.out.println(k + ": " + v));
		
	}

}
