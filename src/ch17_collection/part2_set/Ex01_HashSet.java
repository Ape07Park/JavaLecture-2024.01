package ch17_collection.part2_set;

import java.util.HashSet;
import java.util.Set;
	
public class Ex01_HashSet {

	public static void main(String[] args) {
		// set(집합)은 원소의 중복 허용 x
		Set<String> set = new HashSet<String>();
		
		
		// 데이터 추가 및 저장
		set.add("Java");
		set.add("collection");
		set.add("set");
		set.add("set"); // 중복 저장 x
		System.out.println(set);
		
		// 데이터 삭제
		set.remove("set"); // 특정 원소 삭제
		System.out.println(set);
		set.clear(); // 전체 삭제
		System.out.println(set);
		
		// 정보 추출
		System.out.println(set.isEmpty()); // 안에 원소들이 없는지 확인
		set.add("Java"); set.add("collection"); set.add("set");
		System.out.println(set.size()); // 원소 개수 확인
		System.out.println(set.contains("Java")); // 특정 단어가 있는지 확인
		
		// 모든 객체 꺼내기
		for (String element:set) {
			System.out.println(element);
		}
		
		Set<Integer> intSet = new HashSet<>();
		intSet.add(1); 
		intSet.add(3); 
		intSet.add(6); 
		intSet.add(9); 
		intSet.add(12); 
		System.out.println(intSet);
	}

}
