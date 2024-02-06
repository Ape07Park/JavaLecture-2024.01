package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02_ArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); // 대부분 이렇게 사용함
		
		ArrayList<String> aList = new ArrayList<>(); // 이렇게는 잘 사용 x 
		
		list.add("class"); 
		list.add("interface");
		list.add("inheritance");
		System.out.println(list);
		
		List<String> fruitList = Arrays.asList(new String[] {"apple", "banana", "cherry"} );
		System.out.println(fruitList);
//		fruitList.add("mango"); // 정적인 리스트, 추가/삭제 불가
		
		// 기본 자료형의 경우 Wrapper 클래스(int -> Integer, double -> Double)로 리스트를 생성해야 함 
		List<Integer> numList = new ArrayList<>();
		numList.add(1); numList.add(3); numList.add(5);
		System.out.println(numList);
		
		// 추출(indexing)
		System.out.println(list.get(0)); System.out.println(list.get(1));
		
		
		// 데이터 추가 // 맨 앞, 맨 뒤 추가를 많이 사용함
		// list.add(0, "collection"); - 맨 앞에 추가 
		list.add("list"); // 맨 뒤에 추가함 
		list.add(3, "collection"); // 원하는 인덱스에 추가. 원래 있던 건 뒤로 밀림 
		System.out.println(list);
		list.addAll(fruitList);// 리스트 이어붙이기 
		System.out.println(list);
		
		// 데이터 삭제 후 변경
		list.set(5, "set"); // 5번 자리 거 지우고 set으로 변경. 특정 인덱스의 값 지우고 대체
		System.out.println(list);
		
		// 데이터 삭제
		list.remove(6); // 오버로딩, 6번 인덱스 값 삭제
		list.remove("cherry"); // 오버로딩, 체리 엘리먼트 삭제 
		System.out.println(list);
		numList.clear(); // 리스트 전체 원소 삭제
		
		// 리스트에 대한 정보 추출
		System.out.println(numList.isEmpty() + ", " + numList.size()); // 리스트가 비었는지?
		System.out.println(list.contains("set")); // "set"을 포함하고 있니?
		System.out.println(list.indexOf("list")); // "list"는 몇 번 인덱스에 있니?
		System.out.println(list.indexOf("list3")); // 없으면 - 값이 나온다
		
	}
	

}
