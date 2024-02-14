package mysql.sec02_kcity;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * City DAO(Data Access Object) - DB table을 다루는 *라이브러리
 *  	Select, Insert, Update, Delete를 처리하는 프로그램
 */

public class CityDao {
	private String connStr;
	private String user;
	private String password;

	public CityDao() {

		// 파일 경로
		String path = "C:/Workspace/Java/lesson/src/mysql/mysql.properties";

		try {
			// 파일 읽기
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));

			// Property 가져오기
			String host = prop.getProperty("host"); // 호스트 이름: local host
			String port = prop.getProperty("port"); // 포트 번호: 3306
			String database = prop.getProperty("database"); // DB명: 월드

			// 파일에서 읽은 걸 리터럴로 필드에 채우기
			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection myConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connStr, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public City getCityId(int id) {
		Connection conn = myConnection();
		String sql = "select * from kcity where id=?";
//		City city = new City(); // 방법 1 기본 생성자

		// 방법 2: 오버로딩 생성자에 인자 넣기
		City city = null; // 먼저 빈 City 타입 변수 선언

		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			// select 실행 및 결과 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				// 방법 1: 기본 성성자 + 게터, 세터
//				city.setId(rs.getInt(1));
//				city.setName(rs.getString(2));
//				city.setCountryCode(rs.getString(3));
//				city.setDistrict(rs.getString(4));
//				city.setPopulation(rs.getInt(5));

				// 방법 2: 오버로딩 생성자에 인자 넣기
				city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

	public City getCityByname(String name) {
		Connection conn = myConnection();
		String sql = "select * from kcity where name=?";

		// 방법 2: 오버로딩 생성자에 인자 넣기
		City city = null;

		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			// select 실행 및 결과를 ResultSet으로 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return city;
	}

	public List<City> getCityListAll() {
		Connection conn = myConnection();
		String sql = "select * from kcity";
		List<City> list = new ArrayList<City>(); // 구현 객체 만들기

		try {
			Statement stmt = conn.createStatement();
			// select 실행 및 결과를 ResultSet으로 받기
			ResultSet rs = stmt.executeQuery(sql);
			// list 객체 만들어서 집어넣음

			while (rs.next()) {
				// loop 안에서 객체 만들어서 list에 저장
				City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

				list.add(city);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<City> getCityListByDistrict(String district) {
		Connection conn = myConnection();
		String sql = "select * from kcity where district=?";
		List<City> list = new ArrayList<City>(); // 구현 객체 만들기
		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, district);

			// select 실행 및 결과 받기
			ResultSet rs = pstmt.executeQuery();

			// city에 City 객체 생성 및 집어넣기
			while (rs.next()) {
				City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

				list.add(city);
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 추가(Create)
	public void insertCity(City city) {
		Connection conn = myConnection();
		String sql = "insert into kcity values(default, ?, ?, ?, ?)"; // default는 id값

		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 업데이트(Update)
	public void updateCity(City city) {
		Connection conn = myConnection();
		String sql = "update kcity set name=?, countrycode=?, district=?, population=? where id=?";

		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			pstmt.setInt(5, city.getId());

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 제거(Delete)
	public void deleteCity(int id) {
		Connection conn = myConnection();
		String sql = "delete from kcity where id=?";

		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
