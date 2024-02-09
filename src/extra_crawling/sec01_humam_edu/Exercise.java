package extra_crawling.sec01_humam_edu;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Exercise {

	public static void main(String[] args) throws IOException {
		// 접속할 url 만들기
		String url = "https://www.human.or.kr/";
		Document doc= Jsoup.connect(url).get(); 
		/* DOM 객체 만들어짐- 노드 밑에 텍스트가 있는데 이 코드는 노드를 찾는 중. 찾는 것은 css 선택자로 찾음. 
		 li, tr에 반복요소 많음 따라서 그거 가져오면 됨. li, tr 찾는 게 핵심. 웹사이트마다 다르니 수단방법 가리지말고 가져올 것  */
		
		// 1개의 엘리먼트 가지고 올 경우 
		Element strong = doc.selectFirst(".f_right > strong");  
		System.out.println(strong.text()); // text 태그값 안가져다 줌
		
		Element address = doc.selectFirst(".f_left > address");
		System.out.println(address.html()); // html은 태그도 가져다 줌
		
		System.out.println();
		
		String[] addressArray = address.html().split("<br>"); // br 지우기
//		for (String addr:addressArray) {
//			System.out.println(addr.strip());
//		}
		List<String> addressList = new ArrayList<String>(); // 공백 제거 
		for(String addr:addressArray) {
			addressList.add(addr.strip());
		}
		addressList.forEach(x -> System.out.println(x));
		System.out.println("==================");
		
		
		// 한글 주소는 인코딩 되어서 보임. %EC%88%98%EC%9B%90 -> 수원
		// url = "https://www.human.or.kr/program?sca=%EC%88%98%EC%9B%90";
//		url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode("수원", "utf-8");
//		doc= Jsoup.connect(url).get(); // 페이지 바뀌어서 다시 만듦
//		
//		// 여러 개의 엘리먼트 
//		Elements lis = doc.select(".dp_li.num-1"); // 여러 개면 클래스 이름마다 . 붙이기 
//		System.out.println(lis.size());
//		
//		Element li = lis.get(0); // lis 여러개중 1번째 li
//		String title = li.selectFirst(".txt_wrap > h2").text().strip();
//		String desc = li.selectFirst(".txt_content").text().strip();
//		System.out.println(title);
//		System.out.println(desc);
		
//		for (Element li: lis ) {
//			String title = li.selectFirst(".txt_wrap > h2").text().strip();
//			String desc = li.selectFirst(".txt_content").text().strip();
//			System.out.println(title);
//			System.out.println(desc);	
//			System.out.println("==================");
//		}
		
		// 서울, 수원, 천안의 과정을 출력 
		for (String place: new String[] {"서울", "수원", "천안"}) {
			url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode(place, "utf-8");
			doc= Jsoup.connect(url).get();
			
			Elements lis = doc.select(".dp_li.num-1");
			System.out.println(place + " 과정수:" + lis.size());
			
			for (Element li: lis ) {
				String title = li.selectFirst(".txt_wrap > h2").text().strip();
				String desc = li.selectFirst(".txt_content").text().strip();
				System.out.println("==================");
				System.out.println(title);
//				System.out.println(desc);	
			}
		}
		
	}

}
