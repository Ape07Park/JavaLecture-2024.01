package ch03_operation;

public class Ex01_Operation {

	public static void main(String[] args) {
		//  사용자 정의 자료형은 equal() 메서드 사용해야 함 즉  == x
		int i = 2, k = 3;
		double f = k / (double) i;
		System.out.printf("%d, %d, %d%n", k/i, i++, --k); // 1, 2, 2
		System.out.printf("%.1f, %d, %d%n", f, i++, --k); // 1.5, 3, 1
		
		char c = '안';
		System.out.println(c == '안'); // == (값 비교) 은 primitive type(기본 자료형)에만 사용가능
		String s = "hello";
		System.out.println(s == "hello"); // 주소값이 같냐고 묻는 것
		s = new String("hello"); // 참조형에선 저장 위치가 같나고 물어보는 것 
 		System.out.println(s.equals("Hello:")); // 사용자 정의 자료형 비교 시 사용
 		
 		
 		System.out.println(i == k && k == 4);
 		/**
 		 * short circuit: 결과 이미 확정 시 계산 x
 		 * 논리식 1 && 논리식 2 : 1이 false면 2 계산 x
 		 * 논리식 1 \\ 논리식 2 : 1이 true면 2 계산 x
 		 */
 		
 		// 성적이 70점 이상이면 합격, 그렇지 않으면 불합격
 		int score= 40 + (int) (61 * Math.random()); // 40 ~ 100
 		char grade = score >= 70 ? 'P' : 'F';
 		System.out.printf("%d, %c%n", score, grade);
	}

}
