package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_Selcet {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 커넥션 설정 및 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", // 호스트, 포트번호, DB명
					"hmuser", "hmpass" // 사용자 이름, 패스워드
			);
			// Statement: sql에 파라미터 없을 시 사용
			stmt = conn.createStatement();

			// sql문 
			String sql = "select * from city where countrycode='KOR' limit 10";

			// Select 실행 및 받을 객체 생성
			ResultSet rs = stmt.executeQuery(sql);

			// 데이터 받아올 때 무조건 사용
			while (rs.next()) {
				int id = rs.getInt(1); // rs.getInt("ID");도 가능. 대신 ID o
				String name = rs.getString(2); // Name o
				String countryCode = rs.getNString(3);
				String district = rs.getNString(4);
				int population = rs.getInt(5);
				System.out.println(id + ", " + name + ", " + countryCode + ", " + district + ", " + population);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
