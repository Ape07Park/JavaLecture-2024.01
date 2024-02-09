package challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.zone.ZoneOffsetTransitionRule;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q1_CountWorld {

	public static void main(String[] args) throws Exception {
		// 고유단어 개수 구하기 위해 set 사용
		Scanner scan = new Scanner(System.in);
		System.out.println("찾을 파일> ");
		String filename = scan.nextLine();
		scan.close();
		
		// 파일 읽기
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		Set<String> wordSet = new HashSet<String>(); // 고유 단어는 반복되면 안되니 set 사용함
		List<String> wordList = new ArrayList<String>(); // 일반 단어 (중복 o)
		String line = null;
		int count = 0; // 문자 개수
		
		while((line = br.readLine()) != null) {
			count += line.length();
			String cleanText = line.replaceAll("[^0-9A-Za-z ㄱ-ㅎㅏ-ㅣ가-힣]", " "); // 문자, 숫자 제외한 것들 공백으로 만들기
			String[] cleanWords = cleanText.split("\\s+"); // \\s+ : 연속된 공백을 기준으로 문자열 분리
			// .split(): 괄호 안의 것을 기준으로 문자열 분리
			
			for (String word:cleanWords) {
				if(word.equals("")) {
					continue;
				}
				wordSet.add(word.toLowerCase());
				wordList.add(word);
			} 
		}
		br.close();
		System.out.println(wordSet.size() + ", " + wordList.size() + ", " + count);
		System.out.println(wordSet);
		
		
		//  고유 단어와 그냥 단어를 다른 변수에 저장 
		// 글자 제외한 특수기호 등 제거
		// \\s+ : 임의의 연속된 공백

	}

}
