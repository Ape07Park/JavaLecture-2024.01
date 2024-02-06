package Ex02_message;

public interface MessageService {
	int DELETED = 1;
	
	 Message findByMid(int mid); // mid값 받아서 찾기
	   
	 void messageList(); // 목록 반환
	   
	 void messageListByWriter(String writer); // 글쓴이 입력받아 목록 반환 
	   
	 void insertMessage(Message message); // message 입력 받아 content에 삽입하기 
	   
	 void updateMessage(Message message); // message입력받아 content 내용 수정
	   
	 void deleteMessage(int mid); // 메시지 내역 삭제 
//	   List 
//	   List 제임스가 쓴 거면 제임스 거 다 출력 
//	   insert: 메세지를 array에 
//	   update: content 변경
//
//	   수정: 번호 받음, 수정 내용 받음

	
}
