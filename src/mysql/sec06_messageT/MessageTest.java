package mysql.sec06_messageT;

import java.util.List;

public class MessageTest {

	public static void main(String[] args) {
		MessageDAO msgDao = new MessageDAO();
		
		Message msg = msgDao.getMessageByMid(102);
		System.out.println(msg);
		
//		msg = new Message("집에 가자", "브라이언");
//		msgDao.insertMessage(msg);
		
//		msg = msgDao.getMessageByMid(109);
//		msg.setContent("MessageDao 프로그램을 완성하고 싶다");
//		msgDao.updateMessage(msg);
		
		msgDao.deleteMessage(109);
		
		List<Message> list = msgDao.getMessageListByWriter("브라이언");
		list.forEach(x -> System.out.println(x));
	
		msgDao.close();
		
	}

}
