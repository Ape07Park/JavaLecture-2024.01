package ch17_collection.part1_list.sec03_message.teach;

import java.util.List;

public interface MessageService {
	int DELETED = 1;

	Message findByMid(int mid); // mid값 받아서 찾기

	List<Message> messageListAll(); // 목록 반환

	List<Message> getMessageListByWriter(String writer); // 글쓴이 입력받아 목록 반환

	void insertMessage(Message message); // message 입력 받아 content에 삽입하기

	void updateMessage(Message message); // message입력받아 content 내용 수정

	void deleteMessage(int mid); // 메시지 내역 삭제
}
