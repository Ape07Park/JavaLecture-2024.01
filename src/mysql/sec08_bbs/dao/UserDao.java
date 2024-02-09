package mysql.sec08_bbs.dao;

import java.io.FileInputStream; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec08_bbs.entity.User;



public class UserDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn; // conn 계속 반복되니 반복되는 거 필드로 만듦

	public UserDao() {

		// 파일 경로
		String path = "C:/Workspace/Java/lesson/src/mysql/sec08_bbs/mysql.properties";;

		try {
			// 파일 읽기
			// Property: map<String, String>
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));

			// Property 가져오기
			String host = prop.getProperty("host"); // 호스트 이름: local host
			String port = prop.getProperty("port"); // 포트 번호: 3306
			String database = prop.getProperty("database"); // DB명: 월드

			// 파일에서 읽은 걸 리터럴로 필드에 채우기
			
			// * DB URL
			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			// * username
			this.user = prop.getProperty("user");
			// * password
			this.password = prop.getProperty("password");
			// * getConnection 메소드로 DB와 연결 
			this.conn = DriverManager.getConnection(connStr, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// close도 반복되니 반복되는 거 함수로 만듦
	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByUid(String uid) {
		String sql = "select * from users where uid=?";
		User user = null;
		
		try {
			// * 매개변수 세팅
			// SQL을 DB에 전송하기 위한 객체로 sql 실행시 사용됨
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			// * sql 실행 및 그 결과를 -DB에서 가져온 데이터를- rs에 저장
			ResultSet rs = pstmt.executeQuery(); 
			
			// DB에서 가져온 결과를 get하여 불러오고 user에 set함 
			while (rs.next()) {
				user = new User();
				user.setUid(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setUname(rs.getString(3));
				user.setEmail(rs.getString(4));
				String regDateStr = rs.getString(5);
				user.setRegDate(LocalDate.parse(regDateStr));// LocalDate.parse(rs.getgetString(5))
				rs.getInt(6);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> getUserList(int num, int offset){
		String sql = "select * from users where isDeleted=0"
				+ " order by regDate desc, uid limit ? offset ?";// 같은 날짜면 알파벳 순으로 되도록 함 
		List<User> list = new ArrayList<User>();
		try {
			
			// * 매개변수 세팅
			// SQL을 DB에 전송하기 위한 객체로 sql 실행시 사용됨
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, offset);
			
			// * sql 실행 및 그 결과를 -DB에서 가져온 데이터를- rs에 저장
			ResultSet rs =  pstmt.executeQuery();
			
			// DB에서 가져온 결과를 get하여 불러오고 user 객체를 생성하며 필드에 집어넣기
			while (rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), LocalDate.parse(rs.getString(5)), rs.getInt(6)
						);
				// list에 user 집어넣기 
				list.add(user);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertUser(User user) {
		String sql = "insert users values (?, ?, ?, ?, default, default)";
		try {
			
			PreparedStatement pstmt;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		String sql = "update users set pwd=?, uname=?, email=? where uid=?";
		
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUid());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(String uid) {
		String sql = "update users set isDeleted=1 where uid=?";
		
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, uid);
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
