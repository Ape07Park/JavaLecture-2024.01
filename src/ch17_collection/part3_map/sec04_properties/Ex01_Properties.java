package ch17_collection.part3_map.sec04_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ex01_Properties {

	public static void main(String[] args) throws IOException {
		// 키와 벨류가 문자열인 것은 프로퍼티
		Properties prop = new Properties(); // properties: Map<String, String>
		
		// database.properties 파일 로드
		// prop.load(Ex01_Properties.class.getResourceAsStream("database.properties"));
		
		// InputStream 이용하는 방법 
		String fileName = "C:/Workspace/Java/lesson/src/ch17_collection/part3_map/sec04_properties/database.properties";
		InputStream is = new FileInputStream(fileName);
		prop.load(is);
		is.close();
		
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("admin"));
		
		
	}

}
