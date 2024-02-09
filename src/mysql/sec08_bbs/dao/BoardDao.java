package mysql.sec08_bbs.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec08_bbs.entity.Board;

public class BoardDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn; // conn 계속 반복되니 반복되는 거 필드로 만듦

	public BoardDao() {

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

	public Board getBoard(int bid) {
		Board board = null;
		String sql = "SELECT b.*, u.uname FROM board b" + "	JOIN users u ON b.uid=u.uid" + "	WHERE b.bid=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDateTime.parse(rs.getString(5).replace(" ", "T")), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getString(9));
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	// field 값은 title, content, uid 등 attribute name
	// query 값은 검색어- attribute name

	//
	public List<Board> getBoardsList(String field, String query, int num, int offset) {
		String sql = "SELECT b.*, u.uname FROM board b" + " JOIN users u ON b.uid=u.uid" + " WHERE b.isDeleted=0 AND "
				+ field + " LIKE ?" + " ORDER BY bid desc " + " LIMIT ? OFFSET ?";

		List<Board> list = new ArrayList<Board>();

		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);

			// field는 sql문에 직접 넣어서 여기서 작업 x
			pstmt.setString(1, query);
			pstmt.setInt(2, num);
			pstmt.setInt(3, offset);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDateTime.parse(rs.getString(5).replace(" ", "T")), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getString(9));
				list.add(board);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertBoard(Board board) {
		String sql = "insert board values (default, ?, ?, ?, default, default, default, default)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getUid());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBoard(Board board) {
		String sql = "update board set title=?, content=? where bid=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBid());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(int bid) {
		String sql = "update board set isDeleted where bid=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// field 값은 view 또는 reply(view 또는 reply값 증가 시키기 1씩)
	// 잘 모름
	public void increaseCount(String field, int bid) {
		String sql = "UPDATE board SET " + field + "Count=" + field + "Count+1 WHERE bid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
