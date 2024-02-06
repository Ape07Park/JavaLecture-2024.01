package ch17_collection.part1_list.sec03_message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageExample {

	
	public static void main(String[] args) {
		List<Message> list = new ArrayList<Message>();

		// 객체 추가 원할 시
		// 1)
		Message message = new Message(1, "Hello", "james", LocalDateTime.now(), 0);
		list.add(message);

		// 2)
		list.add(new Message(2, "World", "maria", LocalDateTime.now(), 0));
		
		// 이거 외울 것 
		for (int i = 1; i <= 3; i++) {
			Message msg = new Message(2 + i, "내용" + i, "저자" + i, LocalDateTime.now(), 0);
			list.add(msg);
		}

		for (Message m : list) {
			System.out.println(m);
		}
		
		list = generateMessage();
		System.out.println(list);
		// 리스트에서 하는 일은 주로 객체를 추가하는 일임
		
		// 이름이 3글자 이상인 사람의 글- 반복하고 조건에 맞으면 추출 
		
		List<Message> newList = new ArrayList<Message>();
		for (Message msg: list) {
			if (msg.getWriter().length() >= 3)
				newList.add(msg);
		}
		for (Message m: newList)
			System.out.println(m);
	}
	
	// 메세지 객체를 3개 생성해서 리스트로 반환. 많이 사용됨 
	static List<Message> generateMessage() {
		List<Message> list = new ArrayList<Message>();
		Scanner scan = new Scanner(System.in);
		
		for (int i = 1; i <= 3; i++) {
			System.out.print("저자> ");
			String writer = scan.nextLine();
			System.out.print("내용> ");
			String content = scan.nextLine();
			Message msg = new Message(i, content, writer, LocalDateTime.now(), 0);
			list.add(msg);
		}
		scan.close();
		return list;
	}
}
