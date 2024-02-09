package mysql.sec08_bbs.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec08_bbs.entity.Board;
import mysql.sec08_bbs.entity.Reply;
import mysql.sec08_bbs.entity.User;

public class ReplyDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn; // conn 계속 반복되니 반복되는 거 필드로 만듦

	public ReplyDao() {

		// 파일 경로
		String path = "C:/Workspace/Java/lesson1/src/mysql/sec08_bbs/mysql.properties";

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

	public List<Reply> getReplyList(int bid) {

		String sql = "SELECT r.*, u.uname FROM reply r" + "	JOIN users u ON r.uid=u.uid" + "	WHERE r.bid=?"
				+ "	ORDER BY rid";

		List<Reply> list = new ArrayList<Reply>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2),
						LocalDateTime.parse(rs.getString(3).replace(" ", "T")), rs.getString(4), rs.getInt(5),
						rs.getString(6));

				list.add(reply);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertReply(Reply reply) {
		String sql = "insert reply values (default, ?, default, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reply.getComment());
			pstmt.setString(2, reply.getUid());
			pstmt.setInt(3, reply.getBid());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
