package ch17_collection.part3_map;



import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Ex01HashMap {

	public static void main(String[] args) {
		// 첨부파일 받을 때, 남이 만든 거 사용할 때 필요
		// 키 값은 중복 불가
		// hashcode()와 equals() 로 구분 
		Map<String, Integer> map = new HashMap<String, Integer>(); // 인터페이스라 구현 객체를 만드는 과정임
		
		// 데이터 추가
		map.put("사과", 1500);
		map.put("배", 2500);
		map.put("감", 1000);
		map.put("배", 3000); // map 안에 key 값이 없으면 생성, 있으면 값 수정.  
		System.out.println(map);
		
		// 추출
		System.out.println(map.get("사과")); // key 값 넣으면 value 추출
		
		// 정보 추출. key, value 값이 있는지 확인
		System.out.println(map.containsKey("배") + ", " + map.containsValue(4000));
		
		// * 엘리맨트 나열:1) key의 set collection - 권장하는 방법, set으로 줌, 중복배제 
		Set<String> keySet = map.keySet();
		for (String key: keySet) {
			System.out.println(key + ": " + map.get(key));
		}
		
		// 엘리맨트 나열:2)Entry의 Set collection
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry:entrySet) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		// 엘리맨트 나열:3) Stream으로 처리
		System.out.println("======================= Stream으로 처리");
		map.forEach((K, v) -> System.out.println(K + ": " + v));
		
		// 삭제
		map.remove("감");
		System.out.println(map.size());
		map.forEach((K, v) -> System.out.println(K + ": " + v));
		
	}

}
