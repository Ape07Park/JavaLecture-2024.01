package mysql.sec06_messageT;

import java.util.List;

public class MessageServiceMySQLImpl implements MessageService {
	// MessageDAO에 종속적 즉 MessageDAO가 바뀌면 MessageServiceMySQLImpl도 바뀜. 이유는 내용물이 MessageDAO()니까  
	
	private MessageDAO msgDao = new MessageDAO();
	// @AutoWired private MessageDAO msgDao; 스프링이 자동으로 객체 생성해줌 즉 *의존성 주입 
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