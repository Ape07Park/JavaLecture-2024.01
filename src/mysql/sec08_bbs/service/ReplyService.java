package mysql.sec08_bbs.service;

import java.util.List; 

import mysql.sec08_bbs.entity.Reply;

public interface ReplyService {
	
	List<Reply> getReplyList(int bid);
	
	void insertReply(Reply reply);
	
	void close();
	
}
