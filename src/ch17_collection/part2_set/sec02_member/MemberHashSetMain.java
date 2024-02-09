package ch17_collection.part2_set.sec02_member;

import java.util.HashSet;
import java.util.Set;

public class MemberHashSetMain {

	public static void main(String[] args) {
		
		// 1) hashCode()와 2) equals()에서 같다고 판정나야 같은 것으로 취급
		Set<Member> set = new HashSet<>();
		
		Member m1 = new Member(21, "james");
		Member m2 = new Member(20, "maria");
		Member m3 = new Member(21, "james");
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		System.out.println(set);
		System.out.println(m1.hashCode() + ", " + m2.hashCode() + ", " + m3.hashCode());
		
		

	}

}
