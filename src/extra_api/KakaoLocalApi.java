package extra_api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class KakaoLocalApi {
	/*
	 * 도로명 주소로 부터 위도(latitude) 경도(longitude) 정보를 구해주는 메소드
	 */
	
	public Map<String, Double> getGeocode(String addr) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/kakaoApiKey.txt"));
		String kakaoKey = br.readLine();
		br.close();
		
		String query = URLEncoder.encode(addr, "utf-8"); 
		
		String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json"
						+ "?query=" + query;
		
		URL url = new URL(apiUrl);
		
		// Header 설정
//		HttpHeaders headers = new HttpHeaders(null);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "KakaoAK " + kakaoKey);
//		conn.setRequestProperty("content-type","application/json");
//		conn.setDoInput(true);
		
		// 응답 결과 확인
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
		
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = null;
		
		while ((line = br.readLine())!= null) {
			sb.append(line);
			}
		br.close();
		System.out.println(sb.toString());
		System.out.println();
		
		/*
		 * JSON 데이터에서 원하는 값 추출하기
		 */
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(sb.toString());
		
		System.out.println(object.keySet());
		
		JSONArray documents = (JSONArray) object.get("documents"); // 일반 오브젝트라 타입 바꿔야함
		// documents의 타입이 배열임
		System.out.println(documents.size());
		
		JSONObject item = (JSONObject) documents.get(0);
		System.out.println(item.keySet()); // [address, address_type, x, y, address_name, road_address]
		
		String lon_ = (String) item.get("x"); // 경도
		String lat_ = (String) item.get("y"); // 위도
		System.out.println(lon_ + ", " + lat_);
		
	 // Map<String, Double> 형태로 반환하기 위해 
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("lon", Double.parseDouble(lon_));
		map.put("lat", Double.parseDouble(lat_));
		return map;
	}
}
