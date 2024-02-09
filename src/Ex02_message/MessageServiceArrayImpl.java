package Ex02_message;

import java.util.Scanner;

import ch12_interface.bank_refetor.Account;


public class MessageServiceArrayImpl implements MessageService {

	private static Message[] messageArray = new Message[100]; // 원래 main에 있던 것인데 가져옴
	private static Scanner scan = new Scanner(System.in);
	private static int index = 4;

	public MessageServiceArrayImpl() { // 생성자임. 따라서 void 넣으면 x 
		messageArray[0] = new Message(1000, "안녕하세요", "송햇님", "15:03");
		messageArray[1] = new Message(1001, "안녕", "송햇님", "15:04");
		messageArray[2] = new Message(1002, "안녕하시오", "김용현", "15:05");
		messageArray[3] = new Message(1003, "HI", "정아름", "15:00");
		messageArray[4] = new Message(1004, "안녕하십시오", "이강성", "15:06");

	}

	// 몇번째 메시지 메시지내용 작성자 작성시간

	// 완성함.
	@Override
	public Message findByMid(int mid) {
		System.out.println("----------");
		System.out.println("아이디 찾기");
		System.out.println("----------");

		for (int i = 0; i <= messageArray.length; i++) {
			if (messageArray[i].equals(null)) {
				continue;

			}
			if (mid == messageArray[i].getMid()) {
				return messageArray[i];
			}
		}
		return null;
	}

	@Override
	public void messageList() {
		System.out.println("----------");
		System.out.println("메세지 리스트");
		System.out.println("----------");
		
	for (int i = 0; i < index; i++) {
		
		Message me = messageArray[i];
		
		System.out.print(me.getMid() + "\t" +  me.getContent() + "\t" + me.getWriter() + "\t" + me.getGenTime()+"\t" + "/");
		}
	}
	
	@Override
	public void messageListByWriter(String writer) {
		System.out.println("----------");
		System.out.println( /* 사람 */ "메세지 리스트");
		System.out.println("----------");
		// 어레이 반복. 아닌 사람 건너띄기. 사람이 같다면 그 사람 거 가져오기. 내역 출력

//		for (int i = 0; i <= messageArray.length; i++) {
//			if (me ==1 ) {
//				continue;
//			}
//
//			if (me.getWriter().equals(writer)) {
//				System.out.println(messageArray[i]);
//			}
//		}
//		return;

	}

	@Override
	public void insertMessage(Message message) {
		System.out.println("----------");
		System.out.println("메시지 입력");
		System.out.println("----------");

		String content = scan.nextLine();
		System.out.print("입력할 메시지> ");

		int mid = Integer.parseInt(scan.nextLine());

//		Message message = findByMid(mid);

//		LocalDateTime.now()을 인설트 할 때 같이 집어넣기 

//		if (mid == null) {
//			System.out.println("아이디 번호 체크");
//			return;
//		}

		message.setContent(content + message.getContent());
		System.out.println("메시지 입력 완료");

	}

	@Override
	public void updateMessage(Message message) {
		System.out.println("----------");
		System.out.println("수정");
		System.out.println("----------");

		System.out.print("번호 > ");
		int mid = Integer.parseInt(scan.nextLine());
		System.out.print("내용 수정> ");
		String content = scan.nextLine();

		//Message message = findByMid(mid);

//		if (account == null) {
//			System.out.println("계좌번호 체크");
//			return;
//		}	
	}

	@Override
	public void deleteMessage(int mid) {
		System.out.println("----------");
		System.out.println("메세지 제거");
		System.out.println("----------");

	}

}
