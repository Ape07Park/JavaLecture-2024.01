package ch17_collection.Quiz.Prob9;

import java.util.*;
public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		 
		String name = null; // 최고 점수 아이디
		int maxScore = 0; // 최고 점수 
		int totalScore = 0; // 점수 합계
		
		// 점수로만 비교 
		// 맵의 점수 전부 추출. 더하기. 비교하기. 벨류, 키 출력
		
		Set<String> keySet = map.keySet(); // * keySet(): map의 키를 set 타입으로 얻고 keySet에 저장 
		for (String key: keySet) {
			totalScore += map.get(key);
		}
		System.out.println("평균점수:" + totalScore / 3);
		
		for (String key: keySet) { 
			if(maxScore < map.get(key)){ 
				maxScore = map.get(key);
				name = key; 
			}
		}
		System.out.println(maxScore);	
		System.out.println(name);
	}

}
