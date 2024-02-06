package mysql.sec01_basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.Properties;

public class Ex04_Properties {

	public static void main(String[] args) {
		// 절대 경로
		Properties prop= new Properties(); // Properties: Map<String, String>
		String path="C:/Workspace/Java/lesson/src/mysql/mysql.properties";
		try {
			InputStream is = new FileInputStream(path);
			prop.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String host = prop.getProperty("host");
		String port = prop.getProperty("port");
		String database = prop.getProperty("database");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		String connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
		
		System.out.println(connStr);
		System.out.println("DriverManager.getConnection(connStr, user, password);"); // 이런식으로해서 잘 됐는지 확인 및 정보은닉 
	}

}
