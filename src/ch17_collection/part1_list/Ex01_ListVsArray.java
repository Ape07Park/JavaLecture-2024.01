package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01_ListVsArray {

	public static void main(String[] args) {
		String[] array = "가나다라마바사".split("");
		System.out.println(Arrays.toString(array));

		List<String> list = new ArrayList<String>(); // 구현객체(ArrayList)에 있는 <String>에서 String은 생략 o. 이유는 앞에 변수선언에서 자료형
														// 선언해서. 동적선언. 파이썬 리스트와 매우 유사함
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		list.add("바");
		list.add("사");
		
		for (String element : list) {
			System.out.print(element + " ");
		}
		
		System.out.println();
		list.forEach(x -> System.out.print(x + " ")); // 람다함수 사용함
		System.out.println();
		
		// 삭제
		array[2] = null; array[5] = null;
		System.out.println(Arrays.toString(array));
		
		// list에서의 삭제
		list.remove("다"); list.remove("바");
		System.out.println(list);
		
		// 삭제 후 크기 비교
		System.out.println(array.length + ", " + list.size());
		
		// 추가(삽입)
		list.add("아"); list.add("자"); list.add("차");
		System.out.println(list);
		
		// 추가후 크기
		System.out.println(list.size());
		System.out.println(list);
	}

}
