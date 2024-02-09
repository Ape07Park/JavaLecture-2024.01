package mysql.sec08_bbs.dao;

import java.util.List;

import mysql.sec08_bbs.entity.Reply;

public class ReplyDaoTest {

	public static void main(String[] args) {
		ReplyDao rDao = new ReplyDao();
		BoardDao bDao = new BoardDao();
		String sessionUid = "sarah";
		int bid =12;
		
		Reply r = new Reply();
		
		r.setComment("댓글 3"); 
		r.setUid(sessionUid);
		r.setBid(bid);
		
		rDao.insertReply(r);
		
		bDao.increaseCount("reply", bid);
		
		List<Reply> list = rDao.getReplyList(bid);
		list.forEach(x -> System.out.println(x));
		// rDao.getReplyList() 완성 직후 돌린 거에서 bid 12번의 reply 수 7개
		
		bDao.close();
		rDao.close();
	}

}
