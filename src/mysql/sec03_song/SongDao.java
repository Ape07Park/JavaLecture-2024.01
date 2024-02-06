package mysql.sec03_song;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SongDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn; // conn 계속 반복되니 반복되는 거 필드로 만듦 

	public SongDao() {

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

//	private Connection myConnection() {
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(connStr, user, password);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	public Song getSongbySid(int sid) {
		
//		Connection conn = myConnection();
		String sql = "select * from song where sid=?";
		Song song = null;
		
		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			
			// 실행 후 결과를 ResultSet에 받기
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sid = rs.getInt(1);
				String title = rs.getString(2);
				String lyrics = rs.getString(3);
				
				song = new Song(sid, title, lyrics);
			}
			rs.close();
			pstmt.close();
//			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song; 
	}
	
public Song getSongbyTitle(String title) {
		
//		Connection conn = myConnection();
		String sql = "select * from song where title like ?";
		Song song = null;
		
		try {
			// 파라미터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%"); // 검색 시 양쪽에 와일드카드 넣기, %별빛% - 제목에 별빛 있는 거 검색 
			
			// 실행 후 결과를 ResultSet에 받기
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int sid = rs.getInt(1);
				title = rs.getString(2);
				String lyrics = rs.getString(3);
				
				song = new Song(sid, title, lyrics);
			}
			rs.close();
			pstmt.close();
//			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song; 
	}

	public List<Song> getSongListAll(){
//		Connection conn = myConnection();
		String sql = "select * from song";
		List<Song> list = new ArrayList<Song>();
		try {
			
			Statement stmt = conn.createStatement();
			
			// 실행 후 결과를 ResultSet에 받기
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int sid = rs.getInt(1);
				String title = rs.getString(2);
				String lyrics = rs.getString(3);
				
				Song song = new Song(sid, title, lyrics);
				
				list.add(song);
			}
			
			rs.close();
			stmt.close();
//			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertSong(Song song) {
		String sql = "insert song values(default, ?, ?)";
		
		try {
			// 파라미터 세팅 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyric());
			
			// SQL 실행
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateSong(Song song) {
		String sql = "update song set title=?, lyrics=? where sid=?";
		
		try {
			// 파라미터 세팅 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyric());
			pstmt.setInt(3, song.getSid());
			
			// SQL 실행
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// delete는 primary 키로 지우기
	public void deleteSong(int sid) {
		String sql = "delete from song where sid=?";
		
		try {
			// 파라미터 세팅 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, sid);
			
			// SQL 실행
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
