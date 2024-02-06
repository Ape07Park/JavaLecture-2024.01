package mysql.sec06_messageT;

import java.util.List;

public interface MessageService {
	int DELETED = 1;

	Message findByMid(int mid);
	
	List<Message> messageList();
	
	List<Message> messageListByWriter(String writer);
	
	void insertMessage(Message message);
	
	void updateMessage(Message message);
	
	void deleteMessage(int mid);
	
	void close();
}
