package mysql.song;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec02_kcity.City;

public class SongDao {
	private String connStr;
	private String user;
	private String password;

//	public SongDao() {
//		
//
//		// 파일 경로
//		String path = "C:/Workspace/Java/lesson/src/mysql/mysql.properties";
//		
//		try {
//			// 파일 읽기
//			Properties prop = new Properties(); // Property:Map<String,String>
//			prop.load(new FileInputStream(path)); 
//			
//			// Property 가져오기
//			String host = prop.getProperty("host"); // 호스트 이름: local host
//			String port = prop.getProperty("port"); // 포트 번호: 3306
//			String database = prop.getProperty("database"); // DB명: 월드
//			
//			// 파일에서 읽은 걸 리터럴로 필드에 채우기
//			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
//			this.user = prop.getProperty("user");
//			this.password = prop.getProperty("password");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	private Connection myConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC", "hmuser",
					"hmpass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Song getSongBySid(int sid) {
		Connection conn = myConnection(); // DB의 호스트, 포트, 페스워드 가져오기
		String sql = "select * from song where sid=?";
		Song song = new Song();

		try {
			// 몇번째 파라미터에 어떤 것을 넣을 것인지 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);

			// select 실행
			ResultSet rs = pstmt.executeQuery();

			// song 변수에 값 집어넣기
			while (rs.next()) {
				song.setSid(rs.getInt(1));
				song.setTitle(rs.getString(2));
				song.setLyrics(rs.getString(3));
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return song;
	}

	public List<Song> getSongList() {
		// 송 리스트 만들고, DB와 연결, sql로 송들 선택, songDB에서 뭘 받을지 알리기, sql 실행, 송들 불러오기, list에 담기
		List<Song> list = new ArrayList<Song>();
		Connection conn = myConnection();
		String sql = "select * from song";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(song);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*
	 * 수정 필요
	 */
	
	public void insertSong(Song song) {
		// DB와 연결, sql로 song 테이블에 생성할 레코드의 매개변수 세팅, 매개변수에 뭘 받을지 알리기, sql 실행

		Connection conn = myConnection();
		String sql = "insert into song values(default, ?, ?)";

		try {
			// 몇번째 파라미터에 어떤 것을 넣을 것인지 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyrics());

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSong(Song song) {
		// DB와 연결, sql로 song 테이블에 업데이트할 레코드의 매개변수 세팅, 매개변수에 뭘 받을지 알리기, sql 실행

		Connection conn = myConnection();
		String sql = "update song set title=?, lyrics=? where sid=?"; // 에러:sql where 빼먹음 

		try {
			// 몇번째 파라미터에 어떤 것을 넣을 것인지 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyrics());
			pstmt.setInt(3, song.getSid()); // 이거 빼먹음 

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSong(int sid) {
		// DB와 연결, sql로 song 테이블에 업데이트할 레코드의 매개변수 세팅, 매개변수에 뭘 받을지 알리기, sql 실행

		Connection conn = myConnection();
		String sql = "delete from song where sid=?";

		try {
			// 몇번째 파라미터에 어떤 것을 넣을 것인지 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sid);
			

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
