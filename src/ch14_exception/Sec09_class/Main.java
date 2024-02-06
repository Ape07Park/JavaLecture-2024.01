package ch14_exception.Sec09_class;

public class Main {

	public static void main(String[] args) {
		MyExecption me1 = new MyExecption();
		MyExecption me2 = new MyExecption("내가 만든 예외 클래스");
		
//		throw me1;
//		throw me2;
//		throw new MyExecption("의도적 예외 발생");
		
		// 밑의 방식으로 많이 사용함 
		
//		throw new MyRunTimeExcption("의도적 runtime 예외 발생");
		// 이거도 사용 많이 함
		
		try {
			
			for (int i = 0; i <= 100000; i++) {
				for (int k = 0; k <= 100000; k++) {
					if (i == 100 && k== 100) {
						throw new MyExecption("의도적 예외 발생");
					}
				}
			}
		} catch (MyExecption e) {
			e.printStackTrace(); // 이건 꼭 필요한 건 아님
		}
		System.out.println("이중루프 탈출");

	}

}
