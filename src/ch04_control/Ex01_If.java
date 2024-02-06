package ch04_control;

public class Ex01_If {

	public static void main(String[] args) {
		int score = 60 + (int) (41 * Math.random()); // 60 ~ 100
		
		if (score >= 80) {
			System.out.println(score + "점은 평균 이상임");
		}else { 	
			System.out.println(score + "점은 평균 미만임");
			// ctrl + alt + 아래 화살표: 아래로 복사 
		}
		// 범위가 작은 거 부터 위에 적기
		char grade;
		if(score >= 90) {
			grade = 'A';
		}else if(score >= 80) {
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else {
			grade = 'D';
		}
		
		System.out.println("score:" + score + ", grade:"+ grade);
			
		switch(score / 10) {
		case 10:
		case 9:
			grade = 'A'; break;
		case 8:
			grade = 'B'; break;
		case 7:
			grade = 'C'; break;
		default:
			grade = 'D';	
		}
		System.out.println("score:" + score + ", grade:"+ grade);
	}

}
