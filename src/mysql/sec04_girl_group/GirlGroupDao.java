package mysql.sec04_girl_group;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GirlGroupDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn; // conn 계속 반복되니 반복되는 거 필드로 만듦

	public GirlGroupDao() {

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

	public GirlGroup getGirlGroupByGid(int gid) {
		String sql = "select * from girl_group where gid=?";
		GirlGroup gg = new GirlGroup();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				gg.setGid(rs.getInt(1));
				gg.setName(rs.getString(2));

				// gg.setDebut(LocalDate)
				String debutStr = rs.getString(3); // yyyy-mm-dd
				gg.setDebut(LocalDate.parse(debutStr)); // String을 LocalDate 타입으로 바꾸기
				gg.setHitSongId(rs.getInt(4));

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return gg;
	}

	public GirlGroup getGirlGroupByName(String name) {
		String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l" + "	JOIN song r ON l.hit_song_id=r.sid"
				+ "	WHERE l.name LIKE ?";

		GirlGroup gg = new GirlGroup();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			// sql 실행
			ResultSet rs = pstmt.executeQuery();

			// 레코드의 값들 채우기
			while (rs.next()) {
				gg.setGid(rs.getInt(1));
				gg.setName(rs.getString(2));
				gg.setDebut(LocalDate.parse(rs.getString(3))); // String을 LocalDate 타입으로 바꾸기
				gg.setHitSongTitle(rs.getString(4)); // id로
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return gg;
	}

	public List<GirlGroup> getGirlGroupByDebut(int fromYear, int toYear) {
		String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l" + " JOIN song r ON l.hit_song_id=r.sid"
				+ " WHERE l.debut BETWEEN ? AND ?" + " order by l.debut";

		List<GirlGroup> list = new ArrayList<GirlGroup>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fromYear + "-01-01");
			pstmt.setString(2, toYear + "-12-31");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GirlGroup gg = new GirlGroup(rs.getInt(1), rs.getString(2), LocalDate.parse(rs.getString(3)),
						rs.getString(4));
				list.add(gg);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertGirlGroup(GirlGroup gg) {
		String sql = "insert into girl_group values(default, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, gg.getName());
			pstmt.setString(2, gg.getDebut().toString()); // toString(): String으로 자동으로 봐꿈
			pstmt.setInt(3, gg.getHitSongId()); // DB에는 id가 들어가서 이거 씀

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateGirlGroup(GirlGroup gg) {
		String sql = "update girl_group set name=?, debut=?, hit_song_id=? where gid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, gg.getName());
			pstmt.setString(2, gg.getDebut().toString()); // toString(): String으로 자동으로 봐꿈
			pstmt.setInt(3, gg.getHitSongId()); // DB에는 id가 들어가서 이거 씀
			pstmt.setInt(4, gg.getGid()); 

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteGirlGroup(int gid) {
		String sql = "delete from girl_group where gid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, gid); 

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
