package ch17_collection.part1_list.sec03_message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceListImpl implements MessageService {

	private List<Message> messageList = new ArrayList<Message>(); // main에서 생성함 
	
	private int index = 0;

	public MessageServiceListImpl() {
		messageList.add(new Message(101, "자바", "제임스", LocalDateTime.now(), 0));
		messageList.add(new Message(102, "Hi", "정아름", LocalDateTime.now(), 0));
		messageList.add(new Message(103, "오신걸", "크리스", LocalDateTime.now(), 0));
		messageList.add(new Message(104, "환영합니다", "박성민", LocalDateTime.now(), 0));
		messageList.add(new Message(105, "짝짝.", "제임스", LocalDateTime.now(), 0));
	}

	@Override
	public Message findByMid(int mid) { // mid값 받아서 찾기

		for (Message m : messageList) { // 메시지 리스트 불러와 메시지 타입 m에 넣기
			if (m.getMid() == mid) {
				return m;
			}
		}
		return null;
	}

	@Override
	public List<Message> messageListAll() { // 목록 반환
		// 초기화를 위해 빈 리스트 만들 필요 o
		// 메시지 리스트 불러와 출력하기
		for (Message m : messageList) {
			System.out.println(m);
		}
		return null;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) { // 글쓴이 입력받아 목록 반환
		// 메시지 리스트 불러오기. 불러온 거 글쓴이 비교 후. 맞으면 출력
		for (Message m : messageList) {
			if (m.getWriter().equals(writer)) {
				System.out.println(m);
			}
		}
		return null;
	}

	@Override
	public void insertMessage(Message message) { // message 입력 받아 content에 삽입하기
		// 입력 받은 message에 번호와 시간 붙이기 messageList에 add하기
		// 내용에 mid와 시간도 같이 넣어야하니 set으로 추가함.
		int mid = 106 + index++; //  mid는 따로 선언이 안됐으니 맨 위에서 0으로 선언
		message.setMid(mid);
		message.setModTime(LocalDateTime.now()); // 시간 넣어야 하니 set으로 추가
		messageList.add(message);
	}

	@Override
	public void updateMessage(Message message) { // message입력받아 content 내용 수정
		// 반복문 돌기 전에 인덱스 초기화 필요 
		

	}

	@Override
	public void deleteMessage(int mid) { // 메시지 내역 삭제
		// *루프 도는 동안엔 원래 리스트 손상되면 x 
		
		// 예외처리 할 것. 루프 도는 중 내역을 삭제해 에러 발생 
		try {
			for (Message m : messageList) {
				if (mid == m.getMid()) {
					messageList.remove(m); // 루프 도는 동안 원래 리스트 엘리먼트 제거 시도 따라서 에러남 
				}
			}
		} catch (Exception e) {
			return;
		}

	}
	
	
}
