package mysql.sec08_bbs.appl;

import java.util.List;

import mysql.sec08_bbs.entity.Board;
import mysql.sec08_bbs.service.BoardService;
import mysql.sec08_bbs.service.BoardServiceMySQLImpl;

public class BoardAppl {

	public static void main(String[] args) {
		BoardService bSvc = new BoardServiceMySQLImpl();
		
		List<Board> list = bSvc.getBoardList(1, "", ""); // * null 이나 "" 넣어도 값 가져오게 함(서버 터짐 방지)
		list.forEach(x -> System.out.println(x.listForm()));
		
		System.out.println("====================");
		Board board = bSvc.getBoard(14);// 12, 16, 15
		System.out.println(board);
		if(board.getReplyList() != null) {
			board.getReplyList().forEach(x -> System.out.println(x));
		}
		
		bSvc.close();
	}

}
