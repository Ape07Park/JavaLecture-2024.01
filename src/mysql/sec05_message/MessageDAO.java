package mysql.sec05_message;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.exceptions.RSAException;

public class MessageDAO {
	private String connStr;
	private String user;
	private String password;
	private Connection conn; // conn 계속 반복되니 반복되는 거 필드로 만듦

	public MessageDAO() {

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
		// id로 메시지 불러오기: sql로 레코드 고르기, Messaage 타입의 객체 생성, 파라미터 설정 즉 어디에 뭘 넣을지, 쿼리 실행, Messaage 타입 객체의 각 변수에 내용 넣기 
		public Message getMessageByMid(int mid) {
			
			String sql = "select * from message where mid=?";
			Message message = new Message();
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mid);
				
				ResultSet rs = pstmt.executeQuery(); 
				
				while (rs.next()) {
					message.setMid(rs.getInt(1));
					message.setContent(rs.getString(2));
					message.setWriter(rs.getString(3));
					String genTimeStr = rs.getString(4);
					message.setGenTime(LocalDateTime.parse(genTimeStr.replace(" ", "T")));
					message.setIsDeleted(rs.getInt(5));
				}
				
				rs.close();
				pstmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return message;
		}
		
//		writer로 메시지 리스트 불러오기: sql로 레코드 고르기, Messaage list 타입의 객체 생성, 파라미터 설정 즉 어디에 뭘 넣을지, 쿼리 실행, Messaage 타입 객체의 각 변수에 내용 넣기 
		
		public List<Message> getMessageListByWriter(String writer){
			String sql = " SELECT * FROM message l"
					+ "	WHERE l.writer"
					+ "	ORDER BY modTime DESC";
			
					List<Message> list = new ArrayList<Message>();
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, writer);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Message msg = new Message(rs.getString(1), rs.getString(2), 
							LocalDateTime.parse(rs.getString(3)), rs.getInt(4));
					list.add(msg);
				}
				
				rs.close();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		// insert: sql 작성, 파라미터 설정, sql문 실행
		public void insertMessage(Message msg) {
			String sql = "insert into message values(default, ?, ?, ?, ?)";
			
			try {
				PreparedStatement pstmt;
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, msg.getContent());
				pstmt.setString(2, msg.getWriter());
				pstmt.setString(3, msg.getGenTime().toString());
				pstmt.setInt(4, msg.getIsDeleted());
				
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public void updateMessage(Message msg) {
			String sql = "update message set content=?, writer=?, modTime=?, isDeleted=? where mid=?";
			
			try {
				PreparedStatement pstmt =  conn.prepareStatement(sql);
				
				pstmt.setString(1, msg.getContent());
				pstmt.setString(2, msg.getWriter());
				pstmt.setString(3, msg.getGenTime().toString());
				pstmt.setInt(4, msg.getIsDeleted());
				pstmt.setInt(5, msg.getMid());
				
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public void deleteMessage(int msg) {
			String sql = "delete from message where mid=?";
			
			try {
				PreparedStatement pstmt =  conn.prepareStatement(sql);
				
				pstmt.setInt(1, msg);
				
				
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}
