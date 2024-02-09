package extra_api;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RoadAddrApi {
	public String getRoadAddr(String keyword) throws Exception {
		
		// key 가져오기 
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/roadApiKey.txt"));

		String confmKey = br.readLine();
		br.close();

		// get 할 것 정의

		int currentPage = 1;
		int countPerPage = 5;
		String resultType = "json";

		keyword = URLEncoder.encode(keyword, "utf-8");
		String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do" + "?confmKey=" + confmKey // 시작 은 ?로 이어서는 &
				+ "&currentPage=" + currentPage + "&countPerPage=" + countPerPage + "&resultType=" + resultType
				+ "&keyword=" + keyword;

		/*
		 * 읽기
		 */
		URL url = new URL(apiUrl);
		br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer(); // 기억장소 절약 시 사용, 새로 할당이 아닌 기존 장소에 추가
		String tempStr = null;

		while (true) {
			tempStr = br.readLine();
			if (tempStr == null) {
				break;
			}
			sb.append(tempStr); // 응답결과 JSON 저장
		}
		br.close();

		/*
		 * JSON 데이터에서 원하는 값 추출하기
		 */
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(sb.toString());

		// result 항목 가져오기
		JSONObject results = (JSONObject) object.get("results");

		// result에서 "juso" 가져오기
		JSONArray juso = (JSONArray) results.get("juso");
		System.out.println(juso.size());
		JSONObject jusoItem = (JSONObject) juso.get(0); // 인덱스 값
		System.out.println(jusoItem.keySet());
		
		//jusoItem에서 "roadAddr" 가져오기
		String roadAddr = (String) jusoItem.get("roadAddr");

		return roadAddr;
	}

}
