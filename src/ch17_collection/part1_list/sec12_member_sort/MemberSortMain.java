package ch17_collection.part1_list.sec12_member_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MemberSortMain {

	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(23, "james"));
		list.add(new Member(21, "maria"));
		list.add(new Member(27, "brain"));
		list.add(new Member(31, "sarah"));
		list.add(new Member(33, "james"));
		list.add(new Member(21, "maria")); // 같은 사람은 같은 위치에 나옴 
		
		// 이름: 오름차순, 나이: 내림차순으로 정렬
		list.sort(Comparator.naturalOrder());
		for(Member m:list) {
			System.out.println(m);
		}
		

	}

}
