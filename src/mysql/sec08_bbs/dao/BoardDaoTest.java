package mysql.sec08_bbs.dao;

import java.util.ArrayList;
import java.util.List;

import mysql.sec08_bbs.entity.Board;

public class BoardDaoTest {

	public static void main(String[] args) {
		BoardDao bDao = new BoardDao();
		String sessionUid = "james"; // 제임스가 로그인한 걸로 가정
		
		// sessionUid 값이 같으면 조회수 상승 x 
		Board b = bDao.getBoard(12);
		
		if(!b.getUid().equals(sessionUid)) { // 제임스가 작성 x면
			bDao.increaseCount("view", 12);	// viewCount up
		}
		
		System.out.println(b);
		
//		b = new Board("제목 12", "본문 12", "james");
//		bDao.insertBoard(b);
//		
//		b = new Board("제목 13", "본문 13", "james");
//		bDao.insertBoard(b);
//		
//		b = new Board("제목 14", "본문 14", "maria");
//		bDao.insertBoard(b);
//		
//		b = new Board("제목 15", "본문 15", "sarah");
//		bDao.insertBoard(b);
		
		// foreign key constraint(참조 무결성): usertable에 없는 건 등록 x
//		b = new Board("제목 6", "본문 6", "brian");
//		bDao.insertBoard(b);
		
//		b = new Board("제목 16", "본문 16", "brian");
//		bDao.insertBoard(b);
		
		
		List<Board> list =bDao.getBoardsList("title", "%", 10, 0);
		list.forEach(x -> System.out.println(x.listForm()));
		System.out.println("==============================");
		
//		// uid가 user, table에도 있어서 그냥 uid하면 뭔 모름
//		list =bDao.getBoardsList("b.uid", "james", 10, 0);
//		list.forEach(x -> System.out.println(x.listForm()));
//		System.out.println("==============================");
//		
//		 list =bDao.getBoardsList("b.uname", "maria", 10, 0);
//		list.forEach(x -> System.out.println(x.listForm()));
		
		bDao.close();
	}

}
