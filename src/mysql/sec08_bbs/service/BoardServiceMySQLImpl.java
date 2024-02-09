package mysql.sec08_bbs.service;

import java.util.List;

import mysql.sec08_bbs.dao.BoardDao;
import mysql.sec08_bbs.dao.ReplyDao;
import mysql.sec08_bbs.entity.Board;
import mysql.sec08_bbs.entity.Reply;

public class BoardServiceMySQLImpl implements BoardService {
	
	private String sessionUid = "james"; // james로 로그인 했다고 가정
	private BoardDao bDao = new BoardDao();
	private ReplyDao rDao = new ReplyDao();
	
	@Override
	public List<Board> getBoardList(int page, String field, String query) {
		int offset = (page - 1) * COUNT_PER_PAGE;
//		* null 이나 "" 넣어도 값 가져오게 함(서버 터짐 방지)
		if (field == null || field.equals("")) { // 필드가 비거나 없으면 
			field = "title";  // 필드와 쿼리 자동으로 채워줌 
			query = "%";
		}
		List<Board> list = bDao.getBoardsList(field, query, COUNT_PER_PAGE, offset);
		return list;
	}

	@Override
	public Board getBoard(int bid) {
		Board board = bDao.getBoard(bid);
		// 로그인한 id가 다르면 viewCount up
		if(! board.getUid().equals(sessionUid)) {
			bDao.increaseCount("view", bid);
			board.setViewCount(board.getViewCount() + 1);
		}
		
		List<Reply> list = rDao.getReplyList(bid);
		if(list.size() > 0) {
			board.setReplyList(list);
		}
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int bid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		bDao.close();
		rDao.close();
		
	}

}
