package extra_crawling.melonT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import extra_crawling.sec03_melon.MelonChart;

public class Main {
	
	/*
	 * 크롤링 7단계
	 * 1. 사이트에 접속하고 HTML 데이터를 가져와 추출
	 * 2. 원하는 데이터 찾기(<li>, <tr>, ..)
	 * 3. 하나를 선택해서 원하는 정보 추출(연습 게임)
	 * 4. 반복문을 사용하여 페이지 
	 * 5. 오류 발생 시 오류를 해결하고 2,3,4 과정 반복- 에러찾기는 try-catch로 잡기
	 * 6. 모든 페이지에 대해 반복 
	 * 7. CSV 파일로 봐꾸기 
	 */

	public static void main(String[] args) throws IOException {
		// 여기부터
		String url = "https://www.melon.com/chart/index.htm";
		Document doc = Jsoup.connect(url)
//				.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
//				.header("scheme", "https")		
				.get();
		
		Elements trs = doc.select(".service_list_song.type02.d_song_list > table > tbody > tr");
		
		// 담기 위해 list 만듦
		List<MelonChart> list = new ArrayList<MelonChart>();
		for (Element tr : trs) {
		String rank_ = tr.selectFirst(".rank").text().strip();	
		int rank = Integer.parseInt(rank_);
		String title = tr.selectFirst(".ellipsis.rank01 > span > a").text().strip();
		String artist = tr.selectFirst(".ellipsis.rank02 > a").text().strip();
		String album = tr.selectFirst(".ellipsis.rank03 > a").text().strip();
		String src = tr.selectFirst("td:nth-child(4) > div > a > img").attr("src");
		
		MelonChart mc = new MelonChart(rank, title, artist, album, src);
		list.add(mc);
		}
		// 여기까지 반복해서 다른 페이지도 가능 
		
	// 에러 확인 코드
//	for(int i = 0; i < tr.size(); i++) {
//		try {
//			Element trElemen = trs.get(i);
//			// 작업 진행 
//		} catch (Exception e) {
//			System.out.println(i); // 에러 발생 위치 출력해줌 
//			
//		}
//	}
	for(int i = 0; i <=10; i++) {
		System.out.println(list.get(i));
	}
	}

}
