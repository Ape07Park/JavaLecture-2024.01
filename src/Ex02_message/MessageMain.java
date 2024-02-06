package Ex02_message;

import java.util.Scanner;


public class MessageMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static MessageService messageService = new MessageServiceArrayImpl(); // 인터페이스만 이용할 것임
	

	public static void main(String[] args) {
		
		boolean run = true;
		while (run) {
			System.out.println("+===================================================================================+");
			System.out.println("| 1.작성자로 검색 | 2.전체 메시지 리스트 | 3.글쓰기 | 4. 메시지 수정 | 5.메시지 제거 | 6. 종료 |");
			System.out.println("+===================================================================================+");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scan.nextLine());
			switch(selectNo) {
			case 1:
				String writer = scan.nextLine();
				messageService.messageListByWriter(writer);
			break;
			
			case 2 :
				messageService.messageList();
				break;
				
//			case 3 : 
//				messageService.insertMessage();
//				break;
//				
//			case 4 :
//				messageService.updateMessage();
//				break;
//				
//			case 5 : 
//			messageService.deleteMessage();
//				break;
				
			case 6 :
				run = false;
				break;
				
			default :
				System.out.println("숫자제대로입력좀하세요");
			}
		}
		System.out.println("끝");
	}

}
