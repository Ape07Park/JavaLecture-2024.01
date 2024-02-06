package challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Q3_WordFrequency {

	public static void main(String[] args) throws Exception {
//		Map<String, Integer> // Q1에서 이것이 추가 됨 
		//**  new가 map에 있는지 없는지 보고 있으면 가져와서 +1하고 없으면 map에 추가
		
		// 해쉬맵을 밸류로 sort하는 것 
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 파일> ");
		String filename = scan.nextLine();
		scan.close();
		BufferedReader br = new BufferedReader(new FileReader(filename));

		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> wordSet = new HashSet<String>();
		List<String> wordList = new ArrayList<String>();
		String line = null;
		int count = 0;
		while((line = br.readLine()) != null) {
			count += line.length();
			String cleanText = line.replaceAll("[^0-9A-Za-zㄱ-ㅎㅏ-ㅣ가-힣]", " ");
			String[] cleanWords = cleanText.split("\\s+");
			for (String word: cleanWords) {
				if (word.equals(""))
					continue;
				String lowerWord = word.toLowerCase();
				wordSet.add(lowerWord);
				wordList.add(lowerWord);
				if (map.containsKey(lowerWord))
					map.put(lowerWord, map.get(lowerWord) + 1);
				else
					map.put(lowerWord, 1);
			}
		}
		br.close();
		System.out.println(wordSet.size() + ", " + wordList.size() + ", " + count);
		
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort((Comparator<? super Entry<String, Integer>>) new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
//		System.out.println(entryList);
		for (int i = 0; i < 10; i++) {
			System.out.println(entryList.get(i));
		}

	}

}
