package mysql.sec06_messageT;

import java.util.List;

public class MessageServiceMySQLImpl implements MessageService {
	private MessageDAO msgDao = new MessageDAO();
	
	@Override
	public Message findByMid(int mid) {
		Message msg = msgDao.getMessageByMid(mid);
		return msg;
	}

	@Override
	public List<Message> messageList() {
		List<Message> list = msgDao.getMessageListByWriter("%");
		return list;
		
	}

	@Override
	public List<Message> messageListByWriter(String writer) {
		List<Message> list = msgDao.getMessageListByWriter("%" + writer+ "%");
		return list;
		
	}

	@Override
	public void insertMessage(Message message) {
		msgDao.insertMessage(message);
		
	}

	@Override
	public void updateMessage(Message message) {
		msgDao.updateMessage(message);
		
	}

	@Override
	public void deleteMessage(int mid) {
		msgDao.deleteMessage(mid);
		
	}

	@Override
	public void close() {
		msgDao.close();
	}
	
}
