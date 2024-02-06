package ch17_collection.QyizT.q9_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
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
		for (String key : keySet) {
			totalScore += map.get(key); // key로 점수 받아오기 
			if(map.get(key) > maxScore) {
				maxScore = map.get(key);
				name = key;
			}
		}
		System.out.println("평균점수:" + (double) totalScore / map.size() ); // 어떤 숫자 들어올지 모르니 원소 개수로 나누기
		System.out.printf("평균점수: %.1f%n",(double) totalScore / map.size() ); // 소수점 1번 자리까지 표시
		System.out.println("최고점수:" + maxScore);
		System.out.println("최고점수낸 사람:"+ name);
	}
}
